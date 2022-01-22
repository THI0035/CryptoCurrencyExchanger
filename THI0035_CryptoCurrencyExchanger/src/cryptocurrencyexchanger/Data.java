

package cryptocurrencyexchanger;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

public class Data {
    public static String getData() {
        String data = "";

        try {
            URL url = new URL("https://api.pancakeswap.info/api/v2/tokens");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    data += scanner.nextLine();
                }
                scanner.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public static ArrayList < Kryptomena > parseJSON(ArrayList < Kryptomena > kryptomeny, String data) {
        JSONObject obj = new JSONObject(data);
        obj = obj.getJSONObject("data");
        Iterator < ? > keys = obj.keys();

        while (keys.hasNext()) {
            String key = (String) keys.next();

            Kryptomena k = new Kryptomena();
            k.setJmeno(obj.getJSONObject(key).getString("name"));
            k.setZkratka(obj.getJSONObject(key).getString("symbol"));
            k.setCena(Double.parseDouble(obj.getJSONObject(key).getString("price")));
            kryptomeny.add(k);
        }

        return kryptomeny;
    }

    public static Double tryParse(String text) {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}