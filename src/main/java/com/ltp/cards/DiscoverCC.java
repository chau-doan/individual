package com.ltp.cards;

public class DiscoverCC extends CreditCard{
  
  public DiscoverCC(String cardNumber, String cardHolderName, String expirationDate) {
    super(cardNumber, cardHolderName, expirationDate);
  }

  @Override
  public boolean isValid() {

    return getCardNumber().startsWith("6011") && getCardNumber().length() == 16;
  }

  @Override
  public String getCardType() {
    return "Discover";
  }
}
