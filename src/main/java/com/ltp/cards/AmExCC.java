package com.ltp.cards;

public class AmExCC extends CreditCard{
  
  public AmExCC(String cardNumber, String cardHolderName, String expirationDate) {
    super(cardNumber, cardHolderName, expirationDate);
  }

  public boolean isValid() {
    return getCardNumber().charAt(0) == '3' && (getCardNumber().charAt(1) == '4' || getCardNumber().charAt(1) == '7') && getCardNumber().length() == 15;
  }

  public String getCardType() {
    return "American Express";
  }
  
}
