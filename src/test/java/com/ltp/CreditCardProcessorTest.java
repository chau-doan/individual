package com.ltp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.ltp.factory.AmExCCFactory;
import com.ltp.factory.CreditCardCreator;
import com.ltp.factory.CreditCardProcessor;
import com.ltp.factory.DiscoverCCFactory;
import com.ltp.factory.ErrorCCFactory;
import com.ltp.factory.MasterCCFactory;
import com.ltp.factory.VisaCCFactory;

public class CreditCardProcessorTest {
    
    @Test
    public void testCreateCreditCardWithVisa() {
        // Arrange
        CreditCardProcessor creditCardProcessor = new CreditCardProcessor();
        String visaCardNumber = "4111111111111111";
        String cardHolderName = "John Doe";
        String expirationDate = "12/24";

        // Act
        CreditCardCreator creditCardCreator = creditCardProcessor.createCreditCard(visaCardNumber, cardHolderName, expirationDate);

        // Assert
        assertEquals(VisaCCFactory.class, creditCardCreator.getClass());
    }

    @Test
    public void testCreateCreditCardWithMasterCard() {
        // Arrange
        CreditCardProcessor creditCardProcessor = new CreditCardProcessor();
        String masterCardNumber = "5123456789012346";
        String cardHolderName = "John Doe";
        String expirationDate = "12/24";

        // Act
        CreditCardCreator creditCardCreator = creditCardProcessor.createCreditCard(masterCardNumber, cardHolderName, expirationDate);

        // Assert
        assertEquals(MasterCCFactory.class, creditCardCreator.getClass());
    }

    @Test
    public void testCreateCreditCardWithDiscover() {
        // Arrange
        CreditCardProcessor creditCardProcessor = new CreditCardProcessor();
        String discoverCardNumber = "6011123456789012";
        String cardHolderName = "John Doe";
        String expirationDate = "12/24";

        // Act
        CreditCardCreator creditCardCreator = creditCardProcessor.createCreditCard(discoverCardNumber, cardHolderName, expirationDate);

        // Assert
        assertEquals(DiscoverCCFactory.class, creditCardCreator.getClass());
    }

    @Test
    public void testCreateCreditCardWithAmEx() {
        // Arrange
        CreditCardProcessor creditCardProcessor = new CreditCardProcessor();
        String amExCardNumber = "378282246310005";
        String cardHolderName = "John Doe";
        String expirationDate = "12/24";

        // Act
        CreditCardCreator creditCardCreator = creditCardProcessor.createCreditCard(amExCardNumber, cardHolderName, expirationDate);

        // Assert
        assertEquals(AmExCCFactory.class, creditCardCreator.getClass());
    }

    @Test
    public void testCreateCreditCardWithInvalidCard() {
        // Arrange
        CreditCardProcessor creditCardProcessor = new CreditCardProcessor();
        String invalidCardNumber = "1234567890123456";
        String cardHolderName = "John Doe";
        String expirationDate = "12/24";

        // Act
        CreditCardCreator creditCardCreator = creditCardProcessor.createCreditCard(invalidCardNumber, cardHolderName, expirationDate);

        // Assert
        assertEquals(ErrorCCFactory.class, creditCardCreator.getClass());
    }

}
