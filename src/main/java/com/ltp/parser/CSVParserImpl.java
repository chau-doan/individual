package com.ltp.parser;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class CSVParserImpl implements CreditCardParser{

  @Override
public List<Map<String, String>> read(String inputFileName) {
    List<Map<String, String>> records = new ArrayList<>();

    try (CSVParser csvParser = CSVParser.parse(new File(inputFileName), Charset.defaultCharset(), CSVFormat.DEFAULT.withHeader())) {
        for (CSVRecord csvRecord : csvParser) {
            Map<String, String> record = new HashMap<>();
            record.put("cardNumber", csvRecord.get("cardNumber"));
            record.put("cardHolderName", csvRecord.get("cardHolderName"));
            record.put("expirationDate", csvRecord.get("expirationDate"));
            records.add(record);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return records;
}

@Override
public void write(String outputFileName, List<Map<String, String>> data) {
    try (FileWriter fileWriter = new FileWriter(outputFileName);
         CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT
                 .withHeader("cardNumber", "cardType"))) {

        for (Map<String, String> record : data) {
            String cardNumber = record.get("cardNumber");
            String cardType = record.get("cardType");

            csvPrinter.printRecord(cardNumber, cardType);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

  
}
