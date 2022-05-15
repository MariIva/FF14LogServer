package ru.arizara.ff14LogServ.mapper;



import org.json.JSONException;
import org.json.JSONObject;
import ru.arizara.ff14LogServ.entities.CategoryLog;

public class CategoryLogMapper {
    public static CategoryLog CategoryLogFromJSON(JSONObject jsonObject) {

        CategoryLog log = null;

        try {
            log = new CategoryLog(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name")
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return log;
    }
}
