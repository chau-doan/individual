package com.ltp.factory;

import com.ltp.cards.CreditCard;
import com.ltp.cards.DiscoverCC;

public class DiscoverCCFactory extends CreditCardCreator{
  public DiscoverCCFactory(String cardNumber, String cardHolderName, String expirationDate) {
    super(cardNumber, cardHolderName, expirationDate);
  }

  protected CreditCard createCreditCard(String cardNumber, String cardHolderName, String expirationDate) {
    return new DiscoverCC(cardNumber, cardHolderName, expirationDate);
  }
}