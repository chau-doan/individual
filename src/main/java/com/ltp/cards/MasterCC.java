package com.ltp.cards;

public class MasterCC extends CreditCard{

  public MasterCC(String cardNumber, String cardHolderName, String expirationDate) {
    super(cardNumber, cardHolderName, expirationDate);
  }

  public boolean isValid() {
    return getCardNumber().charAt(0) == '5' && getCardNumber().charAt(1) >= '1' && getCardNumber().charAt(1) <= '5' && getCardNumber().length() == 16;
  }

  public String getCardType() {
    return "MasterCard";
  }
  
}
