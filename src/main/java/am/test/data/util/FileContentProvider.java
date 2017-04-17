package am.test.data.util;

import am.test.data.model.CSVKeys;
import am.test.data.model.FileContent;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by karlen on 4/16/17.
 */
public class FileContentProvider {

    private ConfigurationUtil configurationUtil;

    public FileContentProvider(ConfigurationUtil configurationUtil) {
        this.configurationUtil = configurationUtil;
    }

    public FileContent getFileContent() {
        CSVFormat format = CSVFormat.DEFAULT.withHeader(CSVKeys.getNames());
        try (FileReader reader = new FileReader(configurationUtil.getFilePath());
             CSVParser parser = new CSVParser(reader, format)) {
            List<CSVRecord> records = parser.getRecords();
            return getFileContent(records);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private FileContent getFileContent(List<CSVRecord> records) {
        FileContent fileContent = new FileContent();
        for (CSVRecord record : records) {
            for (CSVKeys csvKey : CSVKeys.values()) {
                fileContent.add(csvKey, record.get(csvKey.getName()));
            }
        }
        return fileContent;
    }
}
