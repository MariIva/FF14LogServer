package ru.arizara.ff14LogServ.mapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.arizara.ff14LogServ.entities.Mount;
import ru.arizara.ff14LogServ.entities.Source;

import java.util.ArrayList;
import java.util.List;

public class MountMapper {
    public static void SMFromJSONArray(JSONArray jsonArray, List<Mount> jsonMount, List<Source> sourseSet){

        for (int i=0; i<jsonArray.length(); i++) {
            Mount mount = null;
            List<Source> source = new ArrayList<>();
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                mount = mountFromJSON(jsonObject);

                try {
                    source = SourceMapper.sourceFromJSON(
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mount;
    }

}
