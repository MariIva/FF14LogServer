package ru.arizara.ff14LogServ.mapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.arizara.ff14LogServ.entities.Orchestration;

import java.util.ArrayList;
import java.util.List;

public class OrchestrionMapper {
    public static Orchestration orchestrionFromJSON(JSONObject jsonObject) {

        Orchestration orchestrion = null;
        Integer item_id = null;
        try {
            item_id = jsonObject.getInt("item_id");
        }catch (JSONException e) {
        }

        try {
            orchestrion = new Orchestration(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name"),
                    jsonObject.getString("description"),
                    jsonObject.getString("patch"),
                    CategoryLogMapper.CategoryLogFromJSON(jsonObject.getJSONObject("category")),
                    jsonObject.getString("icon")
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return orchestrion;
    }

    public static List<Orchestration> orchestrionFromJSONArray(JSONArray array) {
        List<Orchestration> list = new ArrayList<>();
        for (int i=0; i<array.length(); i++) {
            Orchestration orchestrion = null;
            try {
                JSONObject jsonObject = array.getJSONObject(i);
                orchestrion = OrchestrionMapper.orchestrionFromJSON(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (orchestrion != null) list.add(orchestrion);
        }
        return list;
    }


}
