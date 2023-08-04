package student.examples.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BNMService {
    private final String endpoint = "https://www.bnm.md/ro/official_exchange_rates";
    String currentDay = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    String endpointWithParams = endpoint + "?" + "get_xml=1" + "&" + "date=" + currentDay;

    public String getData() throws IOException {
        URL url = new URL(endpointWithParams);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        InputStream is = connection.getInputStream();
        byte[] data = is.readAllBytes();
        String xmlData = new String(data, "UTF-8");
        return xmlData;
    }

    
}
