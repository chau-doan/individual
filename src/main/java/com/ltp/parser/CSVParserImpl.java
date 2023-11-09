package com.ltp.parser;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class CSVParserImpl implements CreditCardParser{

  @Override
public List<Map<String, String>> read(String inputFileName) {
    List<Map<String, String>> records = new ArrayList<>();

    try (CSVParser csvParser = CSVParser.parse(new File(inputFileName), Charset.defaultCharset(), CSVFormat.DEFAULT.withHeader())) {
        for (CSVRecord csvRecord : csvParser) {
            Map<String, String> record = new HashMap<>();
            record.put("cardNumber", csvRecord.get("cardNumber"));
            record.put("cardHolder", csvRecord.get("cardHolderName"));
            record.put("expirationDate", csvRecord.get("expirationDate"));
            records.add(record);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return records;
}
//   @Override
//   public List<Map<String, String>>read(String inputFileName) {
//     List<Map<String, String>> records = new ArrayList<>();

//     try (CSVParser csvParser = new CSVParser(new FileReader(inputFileName), CSVFormat.DEFAULT)) {
//       List<CSVRecord> list = csvParser.getRecords();
//       for (int i = 1; i < list.size(); i++) {
//         Map<String, String> record = new HashMap<>();
        
//         for (int j = 0; j < list.get(0).size(); j++) {
//           record.put(list.get(0).get(j), list.get(i).get(j));
//         }
//         records.add(record);
//       }
    
//       for (CSVRecord csvRecord : csvParser) {
        
//         Map<String, String> record = new HashMap<>();
//         record.put("cardNumber", csvRecord.get(0));
//         record.put("cardHolder", csvRecord.get(2));
//         record.put("expirationDate", csvRecord.get(1));
//         records.add(record);
//       }
//     } catch (IOException e) {
//       e.printStackTrace();
//     }

//   return records;
// }

@Override
public void write(String outputFileName, List<Map<String, String>> data) {
    try (FileWriter fileWriter = new FileWriter(outputFileName);
         CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT
                 .withHeader("cardNumber", "cardType"))) {

        for (Map<String, String> record : data) {
            String cardNumber = record.get("cardNumber");
            String cardType = record.get("cardType");

            csvPrinter.printRecord(cardNumber, cardType);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
  // @Override
  // public void write(String outputFileName, List<Map<String, String>> data) {
  //   try (FileWriter fileWriter = new FileWriter(outputFileName); CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader(data.get(0).keySet().toArray(new String[0])))){
  //     for (Map<String, String> record : data) {
  //       csvPrinter.printRecord(record.values());
  //   }
  //     } catch (IOException e) {
  //       e.printStackTrace();
  //     }
  //   }
  
}
