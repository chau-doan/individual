package com.ltp.factory;

import com.ltp.cards.AmExCC;
import com.ltp.cards.CreditCard;

public class AmExCCFactory extends CreditCardCreator{
  public AmExCCFactory(String cardNumber, String cardHolder, String expirationDate) {
    super(cardNumber, cardHolder, expirationDate);
  }

  protected CreditCard createCreditCard(String cardNumber, String cardHolder, String expirationDate) {
    return new AmExCC(cardNumber, cardHolder, expirationDate);
  }
}
