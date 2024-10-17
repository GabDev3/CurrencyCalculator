package DataProvidingAndDecoder;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class RestDataProvider implements iDataProvider {
    @Override
    public byte[] fetchData(String urlAdress) throws Exception{
        URL url = new URL(urlAdress);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (InputStream in = connection.getInputStream()) {
            return in.readAllBytes();
        }
        finally {
            connection.disconnect();
        }
    }
}
