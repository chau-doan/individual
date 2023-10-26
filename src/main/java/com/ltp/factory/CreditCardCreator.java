package com.ltp.factory;

import java.util.HashMap;
import java.util.Map;

import com.ltp.cards.CreditCard;

import lombok.Setter;

@Setter
public abstract class CreditCardCreator {
  private CreditCard creditCard;

  public CreditCardCreator(String cardNumber, String cardHolder, String expirationDate) {
    creditCard = createCreditCard(cardNumber, cardHolder, expirationDate);
  }

  protected abstract CreditCard createCreditCard(String cardNumber, String cardHolder, String expirationDate);
  
  
  public Map<String, String> generateOutput() {
    Map<String, String> output = new HashMap<>();
    output.put("cardNumber", creditCard.getCardNumber());
    output.put("cardType", creditCard.getCardType());
    return output;
  }
}
