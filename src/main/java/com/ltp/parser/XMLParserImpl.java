package com.ltp.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;


import com.fasterxml.jackson.core.type.TypeReference;

public class XMLParserImpl implements CreditCardParser{
  
  @Override
  public List<Map<String, String>> read(String inputFileName) {
    List<Map<String, String>> records = new ArrayList<>();

    try {
      XmlMapper xmlMapper = new XmlMapper();
      List<Map<String, Object>> xmlData = xmlMapper.readValue(new File(inputFileName), new TypeReference<List<Map<String, Object>>>() {
      });

      for (Map<String, Object> xmlRecord : xmlData) {
        Map<String, String> record = new HashMap<>();
        record.put("cardNumber", String.valueOf(xmlRecord.get("cardNumber")));
        record.put("cardHolder", String.valueOf(xmlRecord.get("cardHolder")));
        record.put("expirationDate", String.valueOf(xmlRecord.get("expirationDate")));
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
      XmlMapper xmlMapper = new XmlMapper();
      xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFileName), data);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

  


