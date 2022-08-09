package ru.arizara.ff14LogServ.mapper;



import org.json.JSONException;
import org.json.JSONObject;
import ru.arizara.ff14LogServ.entities.Race;
import ru.arizara.ff14LogServ.entities.Skill;

public class SkillMapper {
    public static Skill SkillFromJSON(JSONObject jsonObject) {

        Skill log = null;

        try {
            log = new Skill(
                    jsonObject.getString("skill"),
                    jsonObject.getString("skill_description"),
                    jsonObject.getInt("skill_angle"),
                    jsonObject.getInt("skill_cost"),
                    jsonObject.getJSONObject("skill_type").getString("name")
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return log;
    }
}
