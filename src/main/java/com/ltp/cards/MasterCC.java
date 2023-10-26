package com.ltp.cards;

public class MasterCC extends CreditCard{

  public MasterCC(String cardNumber, String cardHolder, String expirationDate) {
    super(cardNumber, cardHolder, expirationDate);
  }

  public boolean isValid() {
    return getCardNumber().charAt(0) == '5' && getCardNumber().charAt(1) >= '1' && getCardNumber().charAt(1) <= '5' && getCardNumber().length() == 16;
  }

  public String getCardType() {
    return "MasterCard";
  }
  
}
