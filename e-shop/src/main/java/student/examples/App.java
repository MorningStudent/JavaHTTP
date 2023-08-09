package student.examples;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import student.examples.services.BNMService;
import student.examples.services.Currency;

public class App {
    public static void main( String[] args ) throws IOException, SAXException, ParserConfigurationException {

        BNMService bnms = new BNMService();
        Map<String, Currency> currencies = bnms.getData();

        for (String key : currencies.keySet()) {
            System.out.println(key + " " + currencies.get(key));
        }

    }
}
