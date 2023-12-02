package com.ltp;


import com.ltp.parser.CSVParserImpl;
import com.ltp.parser.JSONParserImpl;
import com.ltp.parser.XMLParserImpl;

public class Main{
  public static void main(String[] args) throws Exception {
    String input = args[0];
    String output = args[1];
    
    
    ParserProcessor processor = new ParserProcessor(input, output);
    
  

    if (input.endsWith(".csv")){
      processor.setParser(new CSVParserImpl());
    } else if (input.endsWith(".json")){
      processor.setParser(new JSONParserImpl());
    } else if (input.endsWith(".xml")){
      processor.setParser(new XMLParserImpl());
    }
    else {
      throw new Exception("Unsupported file format");
    }

    processor.processData();
    
  }
}
