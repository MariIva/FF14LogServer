package ru.arizara.ff14LogServ.mapper;

import org.json.JSONArray;
import org.json.JSONException;
import ru.arizara.ff14LogServ.entities.Source;

import java.util.ArrayList;
import java.util.List;

public class SourceMapper {

    public static List<Source> sourceFromJSON(JSONArray jsonArray){
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
