import org.json.*;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class HyCon {
    static String key = "53c64cdd-e70f-47b7-94f7-9b2bb2328ae3";
    static String baseURL = "https://hyproxy.herokuapp.com";
    static HashMap<String, String> item;

    public static HashMap<String, String> request(String query) throws Exception {
        String url = baseURL + query + "key=" + key;
        URLConnection con = new URL(url).openConnection(); //Creates the Connection's Object

        InputStream response = con.getInputStream();
        String data;
        try (Scanner scanner = new Scanner(response)) {
            data = scanner.useDelimiter("\\A").next();
        }

        return toHashmap(data);
    }

    public static HashMap<String, String> toHashmap(String imp){
        HashMap<String, String> map = new HashMap<String, String>();
        JSONObject jObject = new JSONObject(imp); //creates a JSON object from the string
        Iterator<?> keys = jObject.keys(); //no clue what this is

        // Creates the hashmap from the JSON object
        while( keys.hasNext() ){
            String key = (String)keys.next();
            String value = jObject.get(key).toString();
            map.put(key, value);
        }

        return map;
    }

    public static HashMap<String, String> items() throws Exception {
        String url = "https://api.slothpixel.me/api/skyblock/items";
        URLConnection con = new URL(url).openConnection(); //Creates the Connection's Object

        InputStream response = con.getInputStream();
        String data;
        try (Scanner scanner = new Scanner(response)) {
            data = scanner.useDelimiter("\\A").next();
        }

        return toHashmap(data);
    }
}
