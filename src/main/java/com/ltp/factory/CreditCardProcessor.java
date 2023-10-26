package com.ltp.factory;

public class CreditCardProcessor{
  public static CreditCardCreator createCreditCard(String cardNumber, String cardHolder, String expirationDate) {
    if (cardNumber.charAt(0) == '4' && (cardNumber.length() == 13 || cardNumber.length() == 16)) {
      return new VisaCCFactory(cardNumber, cardHolder, expirationDate);
    } else if (cardNumber.charAt(0) == '5' && cardNumber.charAt(1) >= '1' && cardNumber.charAt(1) <= '5' && cardNumber.length() == 16) {
        return new MasterCCFactory(cardNumber, cardHolder, expirationDate);
    } else if (cardNumber.startsWith("6011") && cardNumber.length() == 16) {
        return new DiscoverCCFactory(cardNumber, cardHolder, expirationDate);
    } else if (cardNumber.charAt(0) == '3' && (cardNumber.charAt(1) == '4' || cardNumber.charAt(1) == '7') && cardNumber.length() == 15) {
        return new AmExCCFactory(cardNumber, cardHolder, expirationDate);
    } else {
        return null;
    }
  };
}
