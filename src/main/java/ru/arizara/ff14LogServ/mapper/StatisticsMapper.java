package ru.arizara.ff14LogServ.mapper;



import org.json.JSONException;
import org.json.JSONObject;
import ru.arizara.ff14LogServ.entities.Skill;
import ru.arizara.ff14LogServ.entities.Statistics;

public class StatisticsMapper {
    public static Statistics StatisticsFromJSON(JSONObject jsonObject) {

        Statistics log = null;

        try {
            log = new Statistics(
                    jsonObject.getInt("cost"),
                    jsonObject.getInt("attack"),
                    jsonObject.getInt("defense"),
                    jsonObject.getInt("hp"),
                    jsonObject.getInt("speed"),
                    jsonObject.getBoolean("area_attack"),
                    jsonObject.getBoolean("eye"),
                    jsonObject.getBoolean("gate"),
                    jsonObject.getBoolean("shield")
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return log;
    }
}
