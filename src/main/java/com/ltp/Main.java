package com.ltp;

import com.ltp.factory.CreditCardCreator;
import com.ltp.factory.CreditCardProcessor;

public class Main{
  public static void main(String[] args) {
    // Example usage:
    CreditCardCreator cardCreator = CreditCardProcessor.createCreditCard("341142424242424", "Chau", "8/23");
    if (cardCreator != null) {
      System.out.println(cardCreator.generateOutput());
    }
    else {
      System.out.println("Error");
    }
  }
}
