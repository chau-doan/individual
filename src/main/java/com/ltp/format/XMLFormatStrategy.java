// package com.ltp.format;

// import java.io.*;
// import java.util.*;

// import org.w3c.dom.*;

// import javax.xml.parsers.*;
// import javax.xml.transform.Transformer;
// import javax.xml.transform.TransformerFactory;
// import javax.xml.transform.dom.DOMSource;
// import javax.xml.transform.stream.StreamResult;

// import org.w3c.dom.Text;

// import com.ltp.cards.CreditCard;
// import com.ltp.factory.CreditCardFactory;

// public class XMLFormatStrategy {
//   public static List<String> parseFile(String inputFilePath) {
//     List<String> data = new ArrayList<>();
//     try {
//       BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
//       String line;
//       while ((line = reader.readLine()) != null) {
//           data.add(line);
//       }
//       reader.close();
//     } catch (IOException e) {
//       e.printStackTrace();
//     }
//     return data;
//   }

//   public static void generateOutput(List<String> data, String outputFilePath, CreditCardFactory factory) {
//     try {
//       DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//       DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//       Document doc = docBuilder.newDocument();

//       Element rootElement = doc.createElement("CreditCardData");
//       doc.appendChild(rootElement);

//       for (String line : data) {
//         String[] record = line.split(","); // Adjust the delimiter based on your data format

//         if (record.length >= 3) {
//           String cardNumber = record[0];
//           String cardHolder = record[1];
//           String expirationDate = record[2];

//           CreditCard creditCard = factory.createCreditCard(cardNumber, cardHolder, expirationDate);

//           Element cardElement = doc.createElement("CreditCard");
//           rootElement.appendChild(cardElement);

//           addXmlElement(doc, cardElement, "CardNumber", cardNumber);
//           addXmlElement(doc, cardElement, "CardHolder", cardHolder);
//           addXmlElement(doc, cardElement, "ExpirationDate", expirationDate);

//           if (creditCard != null) {
//             addXmlElement(doc, cardElement, "CardType", creditCard.getCardType());
//             addXmlElement(doc, cardElement, "IsValid", String.valueOf(creditCard.isValid()));
//           } else {
//             addXmlElement(doc, cardElement, "CardType", "Unknown");
//             addXmlElement(doc, cardElement, "IsValid", "Invalid");
//           }
//         }
//       }

//       TransformerFactory transformerFactory = TransformerFactory.newInstance();
//       Transformer transformer = transformerFactory.newTransformer();
//       DOMSource source = new DOMSource(doc);

//       try (FileWriter fileWriter = new FileWriter(outputFilePath)) {
//         StreamResult result = new StreamResult(fileWriter);
//         transformer.transform(source, result);
//       }
//     } catch (Exception e) {
//       e.printStackTrace();
//     }
//   }

//   private static void addXmlElement(Document doc, Element parent, String elementName, String textContent) {
//     Element element = doc.createElement(elementName);
//     Text text = doc.createTextNode(textContent);
//     element.appendChild(text);
//     parent.appendChild(element);
//   }
// }
