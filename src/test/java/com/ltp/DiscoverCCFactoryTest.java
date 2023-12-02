package com.ltp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.ltp.cards.CreditCard;
import com.ltp.cards.DiscoverCC;
import com.ltp.factory.DiscoverCCFactory;

public class DiscoverCCFactoryTest {
  @Test
  public void testCreateCreditCard() {
    // Arrange
    String cardNumber = "6011123456789012";
    String cardHolderName = "Jane Doe";
    String expirationDate = "12/25";

    // Act
    DiscoverCCFactory discoverCCFactory = new DiscoverCCFactory(cardNumber, cardHolderName, expirationDate);
    CreditCard creditCard = discoverCCFactory.createCreditCard(cardNumber, cardHolderName, expirationDate);

    // Assert
    assertEquals(DiscoverCC.class, creditCard.getClass());
    assertEquals(cardNumber, creditCard.getCardNumber());
    assertEquals(cardHolderName, creditCard.getCardHolderName());
    assertEquals(expirationDate, creditCard.getExpirationDate());
  }

  @Test
  public void testGenerateOutput() {
    // Arrange
    String cardNumber = "6011123456789012";
    String cardHolderName = "Jane Doe";
    String expirationDate = "12/25";

    // Act
    DiscoverCCFactory discoverCCFactory = new DiscoverCCFactory(cardNumber, cardHolderName, expirationDate);
    CreditCard creditCard = discoverCCFactory.createCreditCard(cardNumber, cardHolderName, expirationDate);
    discoverCCFactory.setCreditCard(creditCard);

    // Assert
    assertEquals("6011123456789012", discoverCCFactory.generateOutput().get("cardNumber"));
    assertEquals("Discover", discoverCCFactory.generateOutput().get("cardType"));
  }
}
