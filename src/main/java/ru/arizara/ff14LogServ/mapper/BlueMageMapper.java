package ru.arizara.ff14LogServ.mapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.arizara.ff14LogServ.entities.BlueMage;
import ru.arizara.ff14LogServ.entities.Mount;
import ru.arizara.ff14LogServ.entities.Source;

import java.util.ArrayList;
import java.util.List;

public class BlueMageMapper {

    public static void SBMFromJSONArray(JSONArray jsonArray, List<BlueMage> jsonBLM, List<Source> sourseSet){

        for (int i=0; i<jsonArray.length(); i++) {
            BlueMage blueMage = null;
            List<Source> source = new ArrayList<>();
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                blueMage = BLMFromJSON(jsonObject);

                try {
                    source = SourceMapper.sourceFromJSON(
                            jsonObject.getJSONArray("sources"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (blueMage != null)  {
                blueMage.setSources(source);
                jsonBLM.add(blueMage);
            }
            if (source.size()>0) sourseSet.addAll(source);
        }
    }

    public static BlueMage BLMFromJSON(JSONObject jsonObject) {
        BlueMage blueMage = null;
        try {
            blueMage = new BlueMage(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name"),
                    jsonObject.getString("description"),
                    jsonObject.getInt("rank"),
                    jsonObject.getJSONObject("type").getString("name"),
                    jsonObject.getJSONObject("aspect").getString("name"),
                    jsonObject.getString("patch")
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return blueMage;
    }
}
