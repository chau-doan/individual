package com.ltp.factory;

import java.util.HashMap;
import java.util.Map;

import com.ltp.cards.CreditCard;

public class ErrorCCFactory extends CreditCardCreator {
  String cardNumber;
  
  public ErrorCCFactory(String cardNumber, String cardHolder, String expirationDate) {
    super(cardNumber, cardHolder, expirationDate);
    this.cardNumber = cardNumber;
  }

  protected CreditCard createCreditCard(String cardNumber, String cardHolder, String expirationDate) {
    return null;
  }

  @Override
  public Map<String, String> generateOutput() {
    Map<String, String> output = new HashMap<String, String>();
    output.put("cardNumber", cardNumber);
    output.put("cardType", checkError());
    return output;
  }

  private String checkError() {
    if (cardNumber == null || cardNumber.isEmpty()) return "Invalid: empty/null card number";
    if (cardNumber.matches(".*\\D.*")) return "Invalid: non numeric characters";
    if (cardNumber.length() >= 19) return "Invalid: more than 19 digits";
    return "Invalid: not a possible card number";
  } 
}
