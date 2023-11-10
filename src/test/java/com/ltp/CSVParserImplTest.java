package com.ltp;

import static org.junit.Assert.assertEquals;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;

import com.ltp.parser.CSVParserImpl;

public class CSVParserImplTest {
    @Test
    public void testRead() {
        // Test data
        String inputFilePath = "input.csv";
        List<Map<String, String>> testData = List.of(
                Map.of("cardNumber", "123456789", "cardHolderName", "John Doe", "expirationDate", "12/25"),
                Map.of("cardNumber", "987654321", "cardHolderName", "Jane Smith", "expirationDate", "10/23")
        );

        // Create a test CSV file for input
        createTestCSVFile(inputFilePath, testData);

        try {
            // Create an instance of CSVParserImpl
            CSVParserImpl csvParser = new CSVParserImpl();

            // Test read method
            List<Map<String, String>> parsedData = csvParser.read(inputFilePath);
        } finally {
            // Clean up: delete the test input file
            deleteTestFile(inputFilePath);
        }
    }
    @Test
    public void testWrite() {
        // Test data
        String outputFilePath = "output.csv";
        List<Map<String, String>> testData = List.of(
                Map.of("cardNumber", "123456789", "cardType", "VISA"),
                Map.of("cardNumber", "987654321", "cardType", "MasterCard")
        );

        try {
            // Create an instance of CSVParserImpl
            CSVParserImpl csvParser = new CSVParserImpl();

            // Test write method
            csvParser.write(outputFilePath, testData);

            // Read the written file to verify the content
            List<String> lines = Files.readAllLines(Path.of(outputFilePath));
            assertEquals("cardNumber,cardType", lines.get(0));
            assertEquals("123456789,VISA", lines.get(1));
            assertEquals("987654321,MasterCard", lines.get(2));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Clean up: delete the test output file
            deleteTestFile(outputFilePath);
        }
    }

    private void createTestCSVFile(String filePath, List<Map<String, String>> testData) {
        try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(filePath), CSVFormat.DEFAULT
                .withHeader("cardNumber", "cardHolderName", "expirationDate"))) {
            for (Map<String, String> record : testData) {
                csvPrinter.printRecord(record.get("cardNumber"), record.get("cardHolderName"), record.get("expirationDate"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteTestFile(String filePath) {
        try {
            Files.deleteIfExists(Path.of(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


