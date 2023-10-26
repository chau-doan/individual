package com.ltp.format;

import java.io.*;
import java.util.*;

import com.ltp.cards.CreditCard;
import com.ltp.factory.CreditCardCreator;

public class CVSFormatStrategy {
  public static List<String> parseFile(String inputFilePath) {
    List<String> data = new ArrayList<>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
      String line;
      while ((line = reader.readLine()) != null) {
          data.add(line);
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return data;
  }

    public static void generateOutput(List<String> data, String outputFilePath, CreditCardCreator creator) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

            for (String line : data) {
                String[] record = line.split(","); // Assuming CSV format with comma as delimiter

                if (record.length >= 3) {
                    String cardNumber = record[0];
                    String cardHolder = record[1];
                    String expirationDate = record[2];

                    CreditCard creditCard = factory.createCreditCard(cardNumber, cardHolder, expirationDate);

                    if (creditCard != null) {
                        String cardType = creditCard.getCardType();
                        boolean isValid = creditCard.isValid();
                        writer.write(String.format("%s,%s,%s,%s%n", cardNumber, cardType, cardHolder, isValid));
                    } else {
                        // Handle invalid credit card data appropriately
                        writer.write(String.format("%s,Unknown,%s,Invalid%n", cardNumber, cardHolder));
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
