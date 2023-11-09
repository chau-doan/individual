package com.ltp.parser;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
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
      List<Map<String, String>> xmlData = xmlMapper.readValue(new File(inputFileName), new TypeReference<List<Map<String, String>>>() {});

      for (Map<String, String> xmlRecord : xmlData) {
        Map<String, String> record = new HashMap<>();
        record.put("cardNumber", xmlRecord.get("CARD_NUMBER"));
        record.put("cardType", xmlRecord.get("CARD_TYPE"));
        records.add(record);
      }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return records;
  }
  @Override
  public void write(String outputFileName, List<Map<String, String>> data) {
    try (PrintWriter writer = new PrintWriter(outputFileName)) {
        writer.println("<CARDS>");
        for (Map<String, String> record : data) {
            writer.println("  <CARD>");
            writer.println("    <CARD_NUMBER>" + record.get("cardNumber") + "</CARD_NUMBER>");
            writer.println("    <CARD_TYPE>" + record.get("cardType") + "</CARD_TYPE>");
            writer.println("  </CARD>");
        }
        writer.println("</CARDS>");
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
  
}


