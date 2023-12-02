package com.ltp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.ltp.factory.ErrorCCFactory;

public class ErrorCCFactoryTest {
    
    @Test
    public void testGenerateOutputWithNullCardNumber() {
        
        ErrorCCFactory errorCCFactory = new ErrorCCFactory(null, "John Doe", "12/24");
        Map<String, String> output = errorCCFactory.generateOutput();
        assertEquals("Invalid: empty/null card number", output.get("cardType"));
    }

    @Test
    public void testGenerateOutputWithNonNumericCardNumber() {
        ErrorCCFactory errorCCFactory = new ErrorCCFactory("1234abc567890123", "John Doe", "12/24");

        Map<String, String> output = errorCCFactory.generateOutput();

        assertEquals("invalid: non numeric characters", output.get("cardType"));
    }

    @Test
    public void testGenerateOutputWithInvalidLengthCardNumber() {
        
        ErrorCCFactory errorCCFactory = new ErrorCCFactory("12345678901234567890", "John Doe", "12/24");

        Map<String, String> output = errorCCFactory.generateOutput();

        assertEquals("invalid: more than 19 digits", output.get("cardType"));
    }

    @Test
    public void testGenerateOutputWithInvalidCardNumber() {
        
        ErrorCCFactory errorCCFactory = new ErrorCCFactory("12345", "John Doe", "12/24");

        Map<String, String> output = errorCCFactory.generateOutput();

        assertEquals("invalid: not a possible card number", output.get("cardType"));
    }

    @Test
    public void testGenerateOutputWithValidCardNumber() {
        
        ErrorCCFactory errorCCFactory = new ErrorCCFactory("1234567890123456", "John Doe", "12/24");

        Map<String, String> output = errorCCFactory.generateOutput();

        assertEquals("1234567890123456", output.get("cardNumber"));
        
    }
}
