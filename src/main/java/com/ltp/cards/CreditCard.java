package com.ltp.cards;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class CreditCard {
  private String cardNumber;
  private String cardHolderName;
  private String expirationDate;

  public abstract boolean isValid();

  public abstract String getCardType();
}
