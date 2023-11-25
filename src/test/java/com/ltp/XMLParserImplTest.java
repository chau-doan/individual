package com.ltp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ltp.parser.XMLParserImpl;

public class XMLParserImplTest {

    private static final String INPUT_FILE_PATH = "input_test.xml";
    private static final String OUTPUT_FILE_PATH = "output_test.xml";

    @BeforeEach
    public void setUp() {
        // Create a test XML file for input
        List<Map<String, String>> testData = List.of(
                Map.of("CARD_NUMBER", "123456789", "CARD_TYPE", "VISA"),
                Map.of("CARD_NUMBER", "987654321", "CARD_TYPE", "MasterCard")
        );
        createTestXMLFile(INPUT_FILE_PATH, testData);
    }

    @AfterEach
    public void tearDown() {
        // Clean up: delete the test input and output files
        deleteTestFile(INPUT_FILE_PATH);
        deleteTestFile(OUTPUT_FILE_PATH);
    }

    @Test
    public void testRead() {
        // Test data
        XMLParserImpl xmlParser = new XMLParserImpl();

        // Test read method
        List<Map<String, String>> parsedData = xmlParser.read(INPUT_FILE_PATH);

        // Adjust the expected format to match the parsed data
        List<Map<String, String>> expectedData = List.of(
                Map.of("cardNumber", "123456789", "cardType", "VISA"),
                Map.of("cardNumber", "987654321", "cardType", "MasterCard")
        );

        assertEquals(expectedData, parsedData);
    }

    @Test
    public void testWrite() {
        // Test data
        List<Map<String, String>> testData = List.of(
                Map.of("cardNumber", "123456789", "cardType", "VISA"),
                Map.of("cardNumber", "987654321", "cardType", "MasterCard")
        );

        XMLParserImpl xmlParser = new XMLParserImpl();

        // Test write method
        xmlParser.write(OUTPUT_FILE_PATH, testData);

        // Read the written file to verify the content
        try {
            String fileContent = Files.readString(Path.of(OUTPUT_FILE_PATH));

            // Adjust the expected format to match the actual content
            String expectedXmlForWrite = "<CARDS>" +
                    "  <CARD>" +
                    "    <CARD_NUMBER>123456789</CARD_NUMBER>" +
                    "    <CARD_TYPE>VISA</CARD_TYPE>" +
                    "  </CARD>" +
                    "  <CARD>" +
                    "    <CARD_NUMBER>987654321</CARD_NUMBER>" +
                    "    <CARD_TYPE>MasterCard</CARD_TYPE>" +
                    "  </CARD>" +
                    "</CARDS>";

            // Normalize both expected and actual content
            String normalizedExpected = expectedXmlForWrite.replaceAll("\\s", "");
            String normalizedActual = fileContent.replaceAll("\\s", "");

            assertEquals(normalizedExpected, normalizedActual);
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

    private void createTestXMLFile(String filePath, List<Map<String, String>> testData) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            writer.println("<CARDS>");
            for (Map<String, String> record : testData) {
                writer.println("  <CARD>");
                writer.println("    <CARD_NUMBER>" + record.get("CARD_NUMBER") + "</CARD_NUMBER>");
                writer.println("    <CARD_TYPE>" + record.get("CARD_TYPE") + "</CARD_TYPE>");
                writer.println("  </CARD>");
            }
            writer.println("</CARDS>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
