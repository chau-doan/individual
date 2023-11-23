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
            Map<String, List<Map<String, String>>> jsonData = objectMapper.readValue(new File(inputFileName), new TypeReference<Map<String, List<Map<String, String>>>>() {});

            List<Map<String, String>> cards = jsonData.get("cards");
            for (Map<String, String> jsonRecord : cards) {
                Map<String, String> record = new HashMap<>();
                record.put("cardNumber", jsonRecord.get("cardNumber"));
                record.put("expirationDate", jsonRecord.get("expirationDate"));
                record.put("cardHolderName", jsonRecord.get("cardHolderName"));
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
            Map<String, List<Map<String, String>> > jsonData = new HashMap<>();
            jsonData.put("cards", data);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFileName), jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
