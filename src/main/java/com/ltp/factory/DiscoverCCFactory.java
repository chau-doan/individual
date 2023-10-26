package com.ltp.factory;

import com.ltp.cards.CreditCard;
import com.ltp.cards.DiscoverCC;

public class DiscoverCCFactory extends CreditCardCreator{
  public DiscoverCCFactory(String cardNumber, String cardHolder, String expirationDate) {
    super(cardNumber, cardHolder, expirationDate);
  }

  protected CreditCard createCreditCard(String cardNumber, String cardHolder, String expirationDate) {
    return new DiscoverCC(cardNumber, cardHolder, expirationDate);
  }
}