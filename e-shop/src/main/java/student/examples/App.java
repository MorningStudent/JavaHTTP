package student.examples;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import student.examples.services.BNMService;
public class App {
    public static void main( String[] args ) throws IOException, SAXException, ParserConfigurationException {

        BNMService bnms = new BNMService();
        String bnmDataXml = bnms.getData();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(bnmDataXml)));

        NodeList valuteObjects = doc.getDocumentElement().getElementsByTagName("Valute");
        for (int i = 0; i < valuteObjects.getLength(); i++) {
            Element valuteElement = (Element) valuteObjects.item(i);
            String valuteCharCode = valuteElement.getElementsByTagName("CharCode").item(0).getTextContent().trim();
            String valuteValue    = valuteElement.getElementsByTagName("Value").item(0).getTextContent().trim();
            if (valuteCharCode.equals("EUR") || valuteCharCode.equals("USD") || valuteCharCode.equals("AUD")) {
                System.out.println(valuteCharCode + " " + valuteValue);
            }
        }
    }
}
