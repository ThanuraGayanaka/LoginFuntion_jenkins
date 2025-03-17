package utilities;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVUtility {

    // Method to read data from CSV file and return it as a List of Object arrays
    public static Object[][] readCSV(String filePath) throws IOException {
        List<Object[]> data = new ArrayList<>();
        FileReader reader = new FileReader(filePath);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);

        for (CSVRecord record : records) {
            String username = record.get("username");
            String password = record.get("password");
            data.add(new Object[]{username, password});
        }

        return data.toArray(new Object[0][0]);
    }
}
