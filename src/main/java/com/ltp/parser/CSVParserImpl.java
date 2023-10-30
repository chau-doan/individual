package com.ltp.parser;

import java.io.*;
import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class CSVParserImpl implements CreditCardParser{
  @Override
  public List<Map<String, String>>read(String inputFileName) {
    List<Map<String, String>> records = new ArrayList<>();

    try (CSVParser csvParser = new CSVParser(new FileReader(inputFileName), CSVFormat.DEFAULT)) {
      for (CSVRecord csvRecord : csvParser) {
        
        Map<String, String> record = new HashMap<>();
        record.put("cardNumber", csvRecord.get(0));
        record.put("cardHolder", csvRecord.get(1));
        record.put("expirationDate", csvRecord.get(2));
        records.add(record);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  return records;
}

@Override
public void write(String outputFileName, List<Map<String, String>> data) {
  try (FileWriter fileWriter = new FileWriter(outputFileName); CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader(data.get(0).keySet().toArray(new String[0])))){
    for (Map<String, String> record : data) {
      csvPrinter.printRecord(record.values());
  }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
}
