package ru.arizara.ff14LogServ.mapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.arizara.ff14LogServ.entities.Mount;
import ru.arizara.ff14LogServ.entities.Orchestration;

import java.util.ArrayList;
import java.util.List;

public class MountMapper {
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
                    str,
                    SourceMapper.sourceFromJSON(jsonObject.getJSONArray("sources"))
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mount;
    }

    public static List<Mount> mountFromJSONArray(JSONArray array) {
        List<Mount> list = new ArrayList<>();
        for (int i=0; i<array.length(); i++) {
            Mount mount = null;
            try {
                JSONObject jsonObject = array.getJSONObject(i);
                mount = MountMapper.mountFromJSON(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (mount != null) list.add(mount);
        }
        return list;
    }
}
