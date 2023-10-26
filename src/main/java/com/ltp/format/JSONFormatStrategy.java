// package com.ltp.format;

// import java.io.*;
// import java.util.*;

// import org.json.JSONArray;
// import org.json.JSONObject;

// import com.ltp.cards.CreditCard;
// import com.ltp.factory.CreditCardFactory;

// public class JSONFormatStrategy {
//   public static List<String> parseFile(String inputFilePath) {
//     List<String> data = new ArrayList<>();
//     try {
//       BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
//       String line;
//       while ((line = reader.readLine()) != null) {
//           data.add(line);
//       }
//       reader.close();
//     } catch (IOException e) {
//       e.printStackTrace();
//     }
//     return data;
//     }

//     public static void generateOutput(List<String> data, String outputFilePath, CreditCardFactory factory) {
//         JSONArray jsonArray = new JSONArray();

//         for (String line : data) {
//           String[] record = line.split(","); // Adjust the delimiter based on your JSON format

//           if (record.length >= 3) {
//             String cardNumber = record[0];
//             String cardHolder = record[1];
//             String expirationDate = record[2];

//             CreditCard creditCard = factory.createCreditCard(cardNumber, cardHolder, expirationDate);

//             JSONObject jsonObject = new JSONObject();
//             jsonObject.put("cardNumber", cardNumber);
//             jsonObject.put("cardHolder", cardHolder);
//             jsonObject.put("expirationDate", expirationDate);

//             if (creditCard != null) {
//               jsonObject.put("cardType", creditCard.getCardType());
//               jsonObject.put("isValid", creditCard.isValid());
//             } else {
//               jsonObject.put("cardType", "Unknown");
//               jsonObject.put("isValid", "Invalid");
//             }

//             jsonArray.put(jsonObject);    
//           }
//         }

//       try (FileWriter fileWriter = new FileWriter(outputFilePath)) {
//         fileWriter.write(jsonArray.toString(4));
//       } catch (IOException e) {
//         e.printStackTrace();
//     }
//   }
// }
