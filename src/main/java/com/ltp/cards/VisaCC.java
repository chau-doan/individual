package com.ltp.cards;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class VisaCC extends CreditCard{
  public VisaCC(String cardNumber, String cardHolder, String expirationDate) {
    super(cardNumber, cardHolder, expirationDate);
  }

  public boolean isValid() {
    return getCardNumber().startsWith("4") && (getCardNumber().length() == 13 || getCardNumber().length() == 16);
  }

  public String getCardType() {
    return "Visa";
  }
}
