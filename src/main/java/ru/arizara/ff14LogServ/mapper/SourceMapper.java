package ru.arizara.ff14LogServ.mapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.arizara.ff14LogServ.entities.CategoryLog;
import ru.arizara.ff14LogServ.entities.Mount;
import ru.arizara.ff14LogServ.entities.Source;

import java.util.ArrayList;
import java.util.List;

public class SourceMapper {
    public static List<Source> sourceFromJSON(JSONArray jsonArray/*,int id*/){
        List<Source> sources = new ArrayList<>();

        int len = jsonArray.length();
        for (int i=0;i<len;i++){
            try {
                Source source = new Source(
                    jsonArray.getJSONObject(i).getString("type"),
                    jsonArray.getJSONObject(i).getString("text")/*,
                    id*/
                );
                sources.add(source);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return sources;
    }
    public static List<Source> sourseFromJSONArray(JSONArray array) {
        List<Source> list = new ArrayList<>();
        for (int i=0; i<array.length(); i++) {
            List<Source> source = new ArrayList<>();
            try {
                JSONObject jsonObject = array.getJSONObject(i);
                source = SourceMapper.sourceFromJSON(
                        jsonObject.getJSONArray("sources")/*,
                        jsonObject.getInt("id")*/);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (source.size()>0) list.addAll(source);
        }
        return list;
    }
}
