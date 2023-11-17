package com.ltp.factory;

import com.ltp.cards.AmExCC;
import com.ltp.cards.CreditCard;

public class AmExCCFactory extends CreditCardCreator{
  public AmExCCFactory(String cardNumber, String cardHolderName, String expirationDate) {
    super(cardNumber, cardHolderName, expirationDate);
  }

  protected CreditCard createCreditCard(String cardNumber, String cardHolderName, String expirationDate) {
    return new AmExCC(cardNumber, cardHolderName, expirationDate);
  }
}
