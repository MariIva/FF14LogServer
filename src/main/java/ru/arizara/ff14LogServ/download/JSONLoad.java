package ru.arizara.ff14LogServ.download;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.arizara.ff14LogServ.App;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class JSONLoad {

    public static JSONArray getJSON(String url1, String name) {

        JSONArray objects = load(url1);
        save(name,objects);
        return objects;
}
    private static JSONArray load(String url1) {
        try {
            InputStream input = new URL(url1).openStream();
            JSONObject json=null;
            // Input Stream Object To Start Streaming.
            // try catch for checked exception
            BufferedReader re = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
            // Buffer Reading In UTF-8
            String Text = Read(re);         // Handy Method To Read Data From BufferReader
            json = new JSONObject(Text);    //Creating A JSON
            JSONArray objects = json.getJSONArray("results");
            return objects;
        } catch (Exception e) {
             return null;
        }
    }

    private static String Read(Reader re) throws IOException {     // class Declaration
        StringBuilder str = new StringBuilder();     // To Store Url Data In String.
        int temp;
        do {

            temp = re.read();       //reading Charcter By Chracter.
            str.append((char) temp);

        } while (temp != -1);
        //  re.read() return -1 when there is end of buffer , data or end of file.

        return str.toString();

    }

    private static void save( String name, JSONArray objects) {

        String path = App.RATH_JSON + "\\" +  App.DATA ;//+ "\\" + name +".json";
        try {
            File file = new File(path);
            if(!file.exists()) {
                file.mkdirs();
            }
            path = App.RATH_JSON + "\\" +  App.DATA + "\\" + name +".json";
            FileOutputStream fos = new FileOutputStream(path);
            String str = objects.toString();
            fos.write(str.getBytes());
            fos.close();
        } catch (Exception e) {
            System.out.println(" couldn't read an image from this link.");
            e.printStackTrace();
        }
    }

}
