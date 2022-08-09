package ru.arizara.ff14LogServ.download;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.arizara.ff14LogServ.App;
import ru.arizara.ff14LogServ.entities.Mount;
import ru.arizara.ff14LogServ.entities.Source;

import java.io.*;
import java.net.URL;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


public class ImageLoad {
    public static void imageLoad(String url1, String dir,  int id) {
        URL url = null;
        URLConnection openConnection = null;
        String path = App.RATH_IMAGE+"\\"+dir+ "\\" + id + ".png";
        try {
            url = new URL(url1);
            openConnection = url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        boolean check = true;

        try {

            openConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            openConnection.connect();

            if (openConnection.getContentLength() > 8000000) {
                System.out.println(" file size is too big.");
                check = false;
            }
        } catch (Exception e) {
            System.out.println("Couldn't create a connection to the link, please recheck the link.");
            check = false;
            e.printStackTrace();
        }
        if (check) {
            try {
                InputStream in = new BufferedInputStream(openConnection.getInputStream());
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int n = 0;
                while (-1 != (n = in.read(buf))) {
                    out.write(buf, 0, n);
                }
                out.close();
                in.close();
                byte[] response = out.toByteArray();

                FileOutputStream fos = new FileOutputStream(path);
                fos.write(response);
                fos.close();

            } catch (Exception e) {
                System.out.println(" couldn't read an image from this link.");
                e.printStackTrace();
            }
        }
    }

    public static void mountImage(JSONArray objects){
        for (int i=0; i<objects.length(); i++) {
            try {
                JSONObject jsonObject = objects.getJSONObject(i);
                ImageLoad.imageLoad(
                    jsonObject.getString("image"),
                    "mount\\large",
                    jsonObject.getInt("id"));
                ImageLoad.imageLoad(
                    jsonObject.getString("icon"),
                    "mount\\small",
                    jsonObject.getInt("id"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    public static void minionImage(JSONArray objects){
        for (int i=0; i<objects.length(); i++) {
            try {
                JSONObject jsonObject = objects.getJSONObject(i);
                ImageLoad.imageLoad(
                        jsonObject.getString("image"),
                        "minion\\large",
                        jsonObject.getInt("id"));
                ImageLoad.imageLoad(
                        jsonObject.getString("icon"),
                        "minion\\small",
                        jsonObject.getInt("id"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    public static void blmImage(JSONArray objects){
        for (int i=0; i<objects.length(); i++) {
            try {
                JSONObject jsonObject = objects.getJSONObject(i);
                ImageLoad.imageLoad(
                        jsonObject.getString("icon"),
                        "blue_mage",
                        jsonObject.getInt("id"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
