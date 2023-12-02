package com.ltp.factory;

import com.ltp.cards.CreditCard;
import com.ltp.cards.MasterCC;

public class MasterCCFactory extends CreditCardCreator{
  public MasterCCFactory(String cardNumber, String cardHolderName, String expirationDate) {
    super(cardNumber, cardHolderName, expirationDate);
  }

  public CreditCard createCreditCard(String cardNumber, String cardHolderName, String expirationDate) {
    return new MasterCC(cardNumber, cardHolderName, expirationDate);
  }
}