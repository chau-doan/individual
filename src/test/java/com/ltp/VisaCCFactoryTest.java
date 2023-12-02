package com.ltp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.ltp.cards.CreditCard;
import com.ltp.cards.VisaCC;
import com.ltp.factory.VisaCCFactory;

public class VisaCCFactoryTest {
    @Test
    public void testCreateCreditCard() {
    // Arrange
    String cardNumber = "4111111111111111";
    String cardHolderName = "Alice Wonderland";
    String expirationDate = "10/25";

    // Act
    VisaCCFactory visaCCFactory = new VisaCCFactory(cardNumber, cardHolderName, expirationDate);
    CreditCard creditCard = visaCCFactory.createCreditCard(cardNumber, cardHolderName, expirationDate);

    // Assert
    assertEquals(VisaCC.class, creditCard.getClass());
    assertEquals(cardNumber, creditCard.getCardNumber());
    assertEquals(cardHolderName, creditCard.getCardHolderName());
    assertEquals(expirationDate, creditCard.getExpirationDate());
  }

    @Test
    public void testGenerateOutput() {
    // Arrange
    String cardNumber = "4111111111111111";
    String cardHolderName = "Alice Wonderland";
    String expirationDate = "10/25";

    // Act
    VisaCCFactory visaCCFactory = new VisaCCFactory(cardNumber, cardHolderName, expirationDate);
    CreditCard creditCard = visaCCFactory.createCreditCard(cardNumber, cardHolderName, expirationDate);
    visaCCFactory.setCreditCard(creditCard);

    // Assert
    assertEquals("4111111111111111", visaCCFactory.generateOutput().get("cardNumber"));
    assertEquals("Visa", visaCCFactory.generateOutput().get("cardType"));
  }
  
}
