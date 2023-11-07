package com.ltp.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParserImpl implements CreditCardParser{
  @Override
  public List<Map<String, String>> read(String inputFileName) {
    List<Map<String, String>> records = new ArrayList<>();

    try {
      ObjectMapper objectMapper = new ObjectMapper();
      List<Map<String, Object>> jsonData = objectMapper.readValue(new File(inputFileName), new TypeReference<List<Map<String, Object>>>() {});

      System.out.println(jsonData);
      for (Map<String, Object> jsonRecord : jsonData) {
              System.out.println(jsonRecord);

        Map<String, String> record = new HashMap<>();
        record.put("cardNumber", String.valueOf(jsonRecord.get("cardNumber")));
        record.put("cardHolder", String.valueOf(jsonRecord.get("cardHolder")));
        record.put("expirationDate", String.valueOf(jsonRecord.get("expirationDate")));
        records.add(record);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return records;
  }
  

  @Override
  public void write(String outputFileName, List<Map<String, String>> data) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFileName), data);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
