package am.test.data.util;

import am.test.data.model.CSVKeys;
import am.test.data.service.CalculateService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by karlen on 4/17/17.
 */
public class FileCreator {

    private final String FILE_FORMAT = ".csv";

    private CalculateService calculateService;

    private ConfigurationUtil configurationUtil;
    private final char SEPARATOR = ',';

    public FileCreator(CalculateService calculateService, ConfigurationUtil configurationUtil) {
        this.calculateService = calculateService;
        this.configurationUtil = configurationUtil;
    }

    public void saveAmountOfDifferentValues() {
        CSVFormat format = CSVFormat.DEFAULT.withDelimiter(SEPARATOR);
        try (FileWriter fileWriter = new FileWriter(createAndGetFile());
             CSVPrinter printer = new CSVPrinter(fileWriter, format)) {
            Map<CSVKeys, Integer> result = calculateService.amountOfDifferentValues();
            for (CSVKeys csvKeys : CSVKeys.values()) {
                printer.printRecord(csvKeys.getName(), result.get(csvKeys));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAppearTimes() {
        CSVFormat format = CSVFormat.DEFAULT.withDelimiter(SEPARATOR);
        try (FileWriter fileWriter = new FileWriter(createAndGetFile());
             CSVPrinter printer = new CSVPrinter(fileWriter, format)) {
            List<Map<String, Long>> result = calculateService.appearTimes();
            printer.printRecord(CSVKeys.getNames());
            for (Map<String, Long> stringLongMap : result) {
                for (Map.Entry<String, Long> stringLongEntry : stringLongMap.entrySet()) {
                    printer.printRecord(stringLongEntry.getKey(), stringLongEntry.getValue());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File createAndGetFile() throws IOException {
        String path = configurationUtil.getResultFilePath() + getFileName();
        File file = new File(path);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        file.createNewFile();
        return file;
    }

    public String getFileName() {
        return UUID.randomUUID().toString() + FILE_FORMAT;
    }
}
