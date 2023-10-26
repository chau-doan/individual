package com.ltp.factory;

import com.ltp.cards.CreditCard;
import com.ltp.cards.VisaCC;

public class VisaCCFactory extends CreditCardCreator{
  public VisaCCFactory(String cardNumber, String cardHolder, String expirationDate) {
    super(cardNumber, cardHolder, expirationDate);
  }

  protected CreditCard createCreditCard(String cardNumber, String cardHolder, String expirationDate) {
    return new VisaCC(cardNumber, cardHolder, expirationDate);
  }
}