package com.ltp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.ltp.cards.CreditCard;
import com.ltp.cards.MasterCC;
import com.ltp.factory.MasterCCFactory;

public class MasterCCFactoryTest {

    @Test
    public void testCreateCreditCard() {
    // Arrange
    String cardNumber = "5123456789012346";
    String cardHolderName = "John Smith";
    String expirationDate = "11/23";

    // Act
    MasterCCFactory masterCCFactory = new MasterCCFactory(cardNumber, cardHolderName, expirationDate);
    CreditCard creditCard = masterCCFactory.createCreditCard(cardNumber, cardHolderName, expirationDate);

    // Assert
    assertEquals(MasterCC.class, creditCard.getClass());
    assertEquals(cardNumber, creditCard.getCardNumber());
    assertEquals(cardHolderName, creditCard.getCardHolderName());
    assertEquals(expirationDate, creditCard.getExpirationDate());
  }

    @Test
    public void testGenerateOutput() {
    // Arrange
    String cardNumber = "5123456789012346";
    String cardHolderName = "John Smith";
    String expirationDate = "11/23";

    // Act
    MasterCCFactory masterCCFactory = new MasterCCFactory(cardNumber, cardHolderName, expirationDate);
    CreditCard creditCard = masterCCFactory.createCreditCard(cardNumber, cardHolderName, expirationDate);
    masterCCFactory.setCreditCard(creditCard);

    // Assert
    assertEquals("5123456789012346", masterCCFactory.generateOutput().get("cardNumber"));
    assertEquals("MasterCard", masterCCFactory.generateOutput().get("cardType"));
  }
  
}
