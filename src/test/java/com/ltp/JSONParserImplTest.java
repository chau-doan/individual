package com.ltp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltp.parser.JSONParserImpl;

public class JSONParserImplTest {
    
    @Test
    public void testRead() {
        // Test data
        String inputFilePath = "input_test.json";
        List<Map<String, String>> testData = List.of(
            Map.of("cardNumber", "123456789", "expirationDate", "12/25", "cardHolderName", "John Doe"),
            Map.of("cardNumber", "987654321", "expirationDate", "10/23", "cardHolderName", "Jane Smith")
        );

        // Create a test JSON file for input
        createTestJSONFile(inputFilePath, testData);

        try {
            // Create an instance of JSONParserImpl
            JSONParserImpl jsonParser = new JSONParserImpl();

            // Test read method
            List<Map<String, String>> parsedData = jsonParser.read(inputFilePath);

            // Adjust the expected format to match the parsed data
            List<Map<String, String>> expectedData = List.of(
                Map.of("cardNumber", "123456789", "expirationDate", "12/25", "cardHolderName", "John Doe"),
                Map.of("cardNumber", "987654321", "expirationDate", "10/23", "cardHolderName", "Jane Smith")
            );

            assertEquals(expectedData, parsedData);
        } finally {
            // Clean up: delete the test input file
            deleteTestFile(inputFilePath);
        }
    }

    @Test
    public void testWrite() {
        // Test data
        String outputFilePath = "output_test.json";
        List<Map<String, String>> testData = List.of(
            Map.of("cardNumber", "123456789", "expirationDate", "12/25", "cardHolderName", "John Doe"),
            Map.of("cardNumber", "987654321", "expirationDate", "10/23", "cardHolderName", "Jane Smith")
        );

        try {
            // Create an instance of JSONParserImpl
            JSONParserImpl jsonParser = new JSONParserImpl();

            // Test write method
            jsonParser.write(outputFilePath, testData);

            // Read the written file to verify the content
            String fileContent = Files.readString(Path.of(outputFilePath));

            // Adjust the expected format to match the actual content
            String expectedJsonForWrite = """
                {
                    "cards": [
                        {
                            "cardNumber": "123456789",
                            "expirationDate": "12/25",
                            "cardHolderName": "John Doe"
                        },
                        {
                            "cardNumber": "987654321",
                            "expirationDate": "10/23",
                            "cardHolderName": "Jane Smith"
                        }
                    ]
                }
                """.trim();
            
            // Use a JSON parsing library to compare JSON objects (unordered)
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode expectedJson = objectMapper.readTree(expectedJsonForWrite);
            JsonNode actualJson = objectMapper.readTree(fileContent);
            assertEquals(expectedJson, actualJson);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Clean up: delete the test output file
            deleteTestFile(outputFilePath);
        }
    }

    private void deleteTestFile(String filePath) {
        try {
            Files.deleteIfExists(Path.of(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createTestJSONFile(String filePath, List<Map<String, String>> testData) {
    try {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, List<Map<String, String>>> jsonData = new HashMap<>();
        jsonData.put("cards", testData);
        String jsonContent = objectMapper.writeValueAsString(jsonData);

        Files.write(Path.of(filePath), jsonContent.getBytes());
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
