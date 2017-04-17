package am.test.data.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by karlen on 4/17/17.
 */
public class FileContent {

    private Map<CSVKeys, List<String>> content;

    public FileContent() {
        this.content = new HashMap<>();
    }

    public void add(CSVKeys key, String value) {
        if (CSVKeys.conteinsName(value)) {
            return;
        }
        content.put(key, addAndGetValues(key, value));
    }

    public List<String> getValues(CSVKeys key) {
        List<String> values = content.get(key);
        if (values == null) {
            values = new ArrayList<>();
        }
        return values;
    }

    private List<String> addAndGetValues(CSVKeys key, String value) {
        List<String> values = getValues(key);
        values.add(value);
        return values;
    }
}
