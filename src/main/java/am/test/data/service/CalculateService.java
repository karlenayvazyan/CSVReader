package am.test.data.service;

import am.test.data.model.CSVKeys;
import am.test.data.model.FileContent;
import am.test.data.util.FileContentProvider;
import am.test.data.util.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by karlen on 4/16/17.
 */
public class CalculateService {

    private FileContentProvider fileContentProvider;

    public CalculateService(FileContentProvider fileContentProvider) {
        this.fileContentProvider = fileContentProvider;
    }

    // Calculate how many different values are in each column
    public Map<CSVKeys, Integer> amountOfDifferentValues() {
        FileContent fileContent = fileContentProvider.getFileContent();
        Map<CSVKeys, Integer> result = new HashMap<>();
        for (CSVKeys csvKeys : CSVKeys.values()) {
            List<String> values = fileContent.getValues(csvKeys);
            if (!Validator.isEmpty(values)) {
                Map<String, Long> collect = values.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                result.put(csvKeys, collect.size());
            }
        }
        return result;
    }

    // Calculate how many times each value in each column appears
    public List<Map<String, Long>> appearTimes() {
        FileContent fileContent = fileContentProvider.getFileContent();
        List<Map<String, Long>> result = new ArrayList<>();
        for (CSVKeys csvKeys : CSVKeys.values()) {
            List<String> values = fileContent.getValues(csvKeys);
            if (!Validator.isEmpty(values)) {
                Map<String, Long> collect = values.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                result.add(collect);
            }
        }
        return result;
    }
}
