package com.ltp;


import com.ltp.parser.CSVParserImpl;
import com.ltp.parser.JSONParserImpl;
import com.ltp.parser.XMLParserImpl;

public class Main{
  public static void main(String[] args) throws Exception {
    String input = args[0];
    String fileExtension = input.substring(input.lastIndexOf(".") + 1).toLowerCase();
    String output = "output." + fileExtension;
    // String input = "input.xml";
    // String output = "output.xml";
    
    ParserProcessor processor = new ParserProcessor(input, output);
    switch (fileExtension) {
      case "csv":
        processor.setParser(new CSVParserImpl());
        break;
      case "json":
        processor.setParser(new JSONParserImpl());
        break;
      case "xml":
        processor.setParser(new XMLParserImpl());
        break;
      default:
        throw new Exception("Unsupported file format");
    }
    // if (input.endsWith(".csv")){
    //   processor.setParser(new CSVParserImpl());
    // } else if (input.endsWith(".json")){
    //   processor.setParser(new JSONParserImpl());
    // } else if (input.endsWith(".xml")){
    //   processor.setParser(new XMLParserImpl());
    // }
    // else {
    //   throw new Exception("Unsupported file format");
    // }

    processor.processData();
    // Example usage:
    // CreditCardCreator cardCreator = CreditCardProcessor.createCreditCard("341142424242424", "Chau", "8/23");
    // if (cardCreator != null) {
    //   System.out.println(cardCreator.generateOutput());
    // }
    // else {
    //   System.out.println("Error");
    // }
  }
}
