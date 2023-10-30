package com.ltp;

import org.junit.Test;
import static org.junit.Assert.*;

import com.ltp.cards.AmExCC;
import com.ltp.cards.CreditCard;
import com.ltp.cards.DiscoverCC;
import com.ltp.cards.MasterCC;
import com.ltp.cards.VisaCC;

public class CreditCardTest {
  @Test
  public void testAmExCCIsValid() {
    CreditCard amExCC = new AmExCC("347123456789012", "John Doe", "12/24");
    assertTrue(amExCC.isValid());
  }

  @Test
  public void testAmExCCIsInvalid() {
    CreditCard amExCC = new AmExCC("4571234567890123", "John Doe", "12/24");
    assertFalse(amExCC.isValid());
  }

  @Test
  public void testDiscoverCCIsValid() {
    CreditCard discoverCC = new DiscoverCC("6011123456789012", "John Doe", "12/24");
    assertTrue(discoverCC.isValid());
  }

  @Test
  public void testDiscoverCCIsInvalid() {
    CreditCard discoverCC = new DiscoverCC("5111123456789012", "John Doe", "12/24");
    assertFalse(discoverCC.isValid());
  }

  @Test
    public void testMasterCCIsValid() {
        CreditCard masterCC = new MasterCC("5123456789012345", "John Doe", "12/24");
        assertTrue(masterCC.isValid());
    }

    @Test
    public void testMasterCCIsInvalid() {
        CreditCard masterCC = new MasterCC("6123456789012345", "John Doe", "12/24");
        assertFalse(masterCC.isValid());
    }

  @Test
    public void testVisaCCIsValid() {
        CreditCard visaCC = new VisaCC("4112345678901", "John Doe", "12/24");
        assertTrue(visaCC.isValid());
    }

    @Test
    public void testVisaCCIsInvalid() {
        CreditCard visaCC = new VisaCC("6012345678901234", "John Doe", "12/24");
        assertFalse(visaCC.isValid());
    }

  @Test
  public void testGetCardType() {
    CreditCard amExCC = new AmExCC("347123456789012", "John Doe", "12/24");
    assertEquals("American Express", amExCC.getCardType());
    
    CreditCard discoverCC = new DiscoverCC("6011123456789012", "John Doe", "12/24");
    assertEquals("Discover", discoverCC.getCardType());
    
    CreditCard masterCC = new MasterCC("5123456789012345", "John Doe", "12/24");
    assertEquals("MasterCard", masterCC.getCardType());
    
    CreditCard visaCC = new VisaCC("4112345678901", "John Doe", "12/24");
    assertEquals("Visa", visaCC.getCardType());
  }
}
