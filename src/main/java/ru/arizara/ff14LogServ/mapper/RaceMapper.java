package ru.arizara.ff14LogServ.mapper;



import org.json.JSONException;
import org.json.JSONObject;
import ru.arizara.ff14LogServ.entities.CategoryLog;
import ru.arizara.ff14LogServ.entities.Race;

public class RaceMapper {
    public static Race RaceFromJSON(JSONObject jsonObject) {

        Race log = null;

        try {
            log = new Race(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name")
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return log;
    }
}
