package ru.arizara.ff14LogServ.mapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.arizara.ff14LogServ.entities.Minion;
import ru.arizara.ff14LogServ.entities.Mount;
import ru.arizara.ff14LogServ.entities.Source;

import java.util.ArrayList;
import java.util.List;

public class MinionMapper {
    public static void SMinFromJSONArray(JSONArray jsonArray, List<Minion> jsonMinion, List<Source> sourseSet){

        for (int i=0; i<jsonArray.length(); i++) {
            Minion minion = null;
            List<Source> source = new ArrayList<>();
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                minion = minionFromJSON(jsonObject);

                try {
                    source = SourceMapper.sourceFromJSON(
                            jsonObject.getJSONArray("sources"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (minion != null)  {
                minion.setSources(source);
                jsonMinion.add(minion);
            }
            if (source.size()>0) sourseSet.addAll(source);
        }
    }

    public static Minion minionFromJSON(JSONObject jsonObject) {
        Minion minion = null;
        try {
            minion = new Minion(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name"),
                    jsonObject.getString("description"),
                    jsonObject.getString("enhanced_description"),
                    jsonObject.getBoolean("tradeable"),
                    jsonObject.getJSONObject("behavior").getString("name"),
                    jsonObject.getString("patch"),
                    RaceMapper.RaceFromJSON(jsonObject.getJSONObject("race")),
                    SkillMapper.SkillFromJSON( jsonObject.getJSONObject("verminion")),
                    StatisticsMapper.StatisticsFromJSON(jsonObject.getJSONObject("verminion"))
            );
        } catch (JSONException e) { // TODO id 67 and 71
            e.printStackTrace();
        }
        return minion;
    }

}
