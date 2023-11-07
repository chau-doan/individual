package com.ltp.factory;

public class CreditCardProcessor{
  public CreditCardCreator createCreditCard(String cardNumber, String cardHolder, String expirationDate) {
    if (cardNumber == null) 
      return new ErrorCCFactory(cardNumber, cardHolder, expirationDate);
      
    if (cardNumber.matches("^4[0-9]{12}(?:[0-9]{3})?$")) {
      return new VisaCCFactory(cardNumber, cardHolder, expirationDate);
    } else if (cardNumber.matches("^5[1-5][0-9]{14}$")) {
        return new MasterCCFactory(cardNumber, cardHolder, expirationDate);
    } else if (cardNumber.matches("^6011[0-9]{12}$")) {
        return new DiscoverCCFactory(cardNumber, cardHolder, expirationDate);
    } else if (cardNumber.matches("^3[47][0-9]{13}$")) {
        return new AmExCCFactory(cardNumber, cardHolder, expirationDate);
    } else {
        return new ErrorCCFactory(cardNumber, cardHolder, expirationDate);
    }
  };
}
