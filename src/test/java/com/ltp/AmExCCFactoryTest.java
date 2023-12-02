package com.ltp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.ltp.cards.AmExCC;
import com.ltp.cards.CreditCard;
import com.ltp.factory.AmExCCFactory;

public class AmExCCFactoryTest {

    @Test
  public void testCreateCreditCard() {
    // Arrange
    String cardNumber = "1234567890123456";
    String cardHolderName = "John Doe";
    String expirationDate = "12/24";

    // Act
    AmExCCFactory amExCCFactory = new AmExCCFactory(cardNumber, cardHolderName, expirationDate);
    CreditCard creditCard = amExCCFactory.createCreditCard(cardNumber, cardHolderName, expirationDate);

    // Assert
    assertEquals(AmExCC.class, creditCard.getClass());
    assertEquals(cardNumber, creditCard.getCardNumber());
    assertEquals(cardHolderName, creditCard.getCardHolderName());
    assertEquals(expirationDate, creditCard.getExpirationDate());
  }
  
}
