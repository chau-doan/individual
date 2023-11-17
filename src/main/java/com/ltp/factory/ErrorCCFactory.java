package com.ltp.factory;

import java.util.HashMap;
import java.util.Map;

import com.ltp.cards.CreditCard;

public class ErrorCCFactory extends CreditCardCreator {
  String cardNumber;
  
  public ErrorCCFactory(String cardNumber, String cardHolderName, String expirationDate) {
    super(cardNumber, cardHolderName, expirationDate);
    this.cardNumber = cardNumber;
  }

  protected CreditCard createCreditCard(String cardNumber, String cardHolderName, String expirationDate) {
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
    if (cardNumber.matches(".*\\D.*")) return "invalid: non numeric characters";
    if (cardNumber.length() >= 19) return "invalid: more than 19 digits";
    return "invalid: not a possible card number";
  } 
}
