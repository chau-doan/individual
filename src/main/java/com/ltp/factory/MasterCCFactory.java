package com.ltp.factory;

import com.ltp.cards.CreditCard;
import com.ltp.cards.MasterCC;

public class MasterCCFactory extends CreditCardCreator{
  public MasterCCFactory(String cardNumber, String cardHolder, String expirationDate) {
    super(cardNumber, cardHolder, expirationDate);
  }

  protected CreditCard createCreditCard(String cardNumber, String cardHolder, String expirationDate) {
    return new MasterCC(cardNumber, cardHolder, expirationDate);
  }
}