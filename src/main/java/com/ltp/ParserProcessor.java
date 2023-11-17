package com.ltp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ltp.factory.CreditCardCreator;
import com.ltp.factory.CreditCardProcessor;
import com.ltp.parser.CreditCardParser;

public class ParserProcessor {
  private final CreditCardProcessor cardProcessor = new CreditCardProcessor();
  private CreditCardParser parser;
  private String inputFileName;
  private String outputFileName;


  public ParserProcessor(String inputFileName, String outputFileName){
    this.inputFileName = inputFileName;
    this.outputFileName = outputFileName;
  }

  public void setParser(CreditCardParser parser){
    this.parser = parser;
  }

  public void processData(){
    List<Map<String, String>> outputRecords = new ArrayList<>();

    try {
      List<Map<String, String>> inputData = parser.read(inputFileName);

      for (Map<String, String> entry : inputData){
        CreditCardCreator creditCard = cardProcessor.createCreditCard(entry.get("cardNumber"), entry.get("cardHolderName"), entry.get("expirationDate"));

        if (creditCard != null){
          outputRecords.add(creditCard.generateOutput());
        } else {
          Map<String, String> error = new HashMap<>();
          error.put("cardNumber", entry.get("cardNumber"));
          error.put("cardType", "error");
          outputRecords.add(error);

          // throw new Exception("Invalid credit card: " + entry.get("cardNumber"));
        }
      }

      parser.write(outputFileName, outputRecords);
    } catch (Exception e){
      e.printStackTrace();
    }
  }
}

