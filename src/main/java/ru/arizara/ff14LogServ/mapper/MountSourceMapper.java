package ru.arizara.ff14LogServ.mapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.arizara.ff14LogServ.entities.Mount;
import ru.arizara.ff14LogServ.entities.Source;

import java.util.ArrayList;
import java.util.List;

public class MountSourceMapper
{
    public static void SMFromJSONArray(JSONArray jsonArray, List<Mount> jsonMount, List<Source> sourseSet){

        for (int i=0; i<jsonArray.length(); i++) {
            Mount mount = null;
            List<Source> source = new ArrayList<>();
            //List<Source> source = null;
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                mount = mountFromJSON(jsonObject);

                try {
                    source = sourceFromJSON(
                            jsonObject.getJSONArray("sources"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (mount != null)  {
                mount.setSources(source);
                jsonMount.add(mount);
            }
            if (source.size()>0) sourseSet.addAll(source);
        }
    }

    public static Mount mountFromJSON(JSONObject jsonObject) {
        Mount mount = null;
        String str = null;
        try {

            String s[] = jsonObject.getString("bgm").split("/");
            str = s[s.length-1];
        }catch (JSONException e) {
        }
        try {
            mount = new Mount(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name"),
                    jsonObject.getString("description"),
                    jsonObject.getString("enhanced_description"),
                    jsonObject.getString("tooltip"),
                    jsonObject.getInt("seats"),
                    jsonObject.getString("movement"),
                    jsonObject.getString("patch"),
                    str
            );
            /*ImageLoad.imageLoad(
                    jsonObject.getString("image"),
                    "mounts\\large",
                    jsonObject.getInt("id"));
            ImageLoad.imageLoad(
                    jsonObject.getString("icon"),
                    "mounts\\small",
                    jsonObject.getInt("id"));*/
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mount;
    }

    public static List<Source> sourceFromJSON(JSONArray jsonArray/*,int id*/){
        List<Source> sources = new ArrayList<>();

        int len = jsonArray.length();
        for (int i=0;i<len;i++){
            try {
                Source source = new Source(
                        jsonArray.getJSONObject(i).getString("type"),
                        jsonArray.getJSONObject(i).getString("text")
                );
                sources.add(source);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return sources;
    }
}
