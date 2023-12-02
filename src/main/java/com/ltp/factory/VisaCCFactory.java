package com.ltp.factory;

import com.ltp.cards.CreditCard;
import com.ltp.cards.VisaCC;

public class VisaCCFactory extends CreditCardCreator{
  public VisaCCFactory(String cardNumber, String cardHolderName, String expirationDate) {
    super(cardNumber, cardHolderName, expirationDate);
  }

  public CreditCard createCreditCard(String cardNumber, String cardHolderName, String expirationDate) {
    return new VisaCC(cardNumber, cardHolderName, expirationDate);
  }
}