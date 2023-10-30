package com.ltp.parser;

import java.util.List;
import java.util.Map;

public interface CreditCardParser {
  List<Map<String, String>> read(String inputFileName);
  void write(String outputFileName, List<Map<String, String>> data);
}
