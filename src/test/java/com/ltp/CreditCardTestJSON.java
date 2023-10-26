package com.ltp;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.junit.runner.RunWith;



import static org.junit.Assert.assertEquals;

import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.ltp.factory.CreditCardFactory;
import com.ltp.format.JSONFormatStrategy;

public class CreditCardTestJSON {
  
  private JSONFormatStrategy formatStrategy;

  @Before
  public void setUp() {
      formatStrategy = new JSONFormatStrategy();
  }

  @Test
    public void testGenerateOutput() {
        // Mock the FileWriter to capture the written content
        FileWriter fileWriter = mock(FileWriter.class);

        try {
            whenNew(FileWriter.class).withAnyArguments().thenReturn(fileWriter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create a sample JSON data for testing
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("cardNumber", "1234567890123456");
        jsonObject1.put("cardHolder", "John Doe");
        jsonObject1.put("expirationDate", "12/24");
        jsonObject1.put("cardType", "MockCard");
        jsonObject1.put("isValid", true);
        jsonArray.put(jsonObject1);

        // Call the generateOutput method and verify that the FileWriter is called with the expected content
        formatStrategy.generateOutput(jsonArray.toString(), "outputFilePath", mock(CreditCardFactory.class));

        // Verify that the FileWriter is called with the expected content
        verify(fileWriter).write(jsonArray.toString(4));
    }
}
