package com.ltp.format;

import java.util.List;

public interface FormatStrategy {
  List<String> parseFile(String inputFilePath);
  void generateOutput(List<String> data, String outputFilePath);
}
