package ru.arizara.ff14LogServ;

import org.h2.tools.Console;
import org.json.JSONArray;
import org.json.JSONTokener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.arizara.ff14LogServ.entities.*;
import ru.arizara.ff14LogServ.mapper.BlueMageMapper;
import ru.arizara.ff14LogServ.mapper.MinionMapper;
import ru.arizara.ff14LogServ.mapper.MountMapper;
import ru.arizara.ff14LogServ.mapper.OrchestrionMapper;
import ru.arizara.ff14LogServ.service.classes.DBServiceIMPL;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.*;

@SpringBootApplication
public class App {

    public static final String RATH_JSON = "E:\\JavaProject\\IJSpring\\FF14LogServer\\src\\main\\resources\\db.changelog\\data\\json";
    public static final String RATH_IMAGE ="E:\\JavaProject\\IJSpring\\FF14LogServer\\src\\main\\resources\\image";
    public static final String DATA = "2022_08_14";
    public static final String ORCH_CAT = "Orchestrion_CategoryLog";
    public static final String MOUNT = "Mount";
    public static final String MINION = "Minion";
    public static final String BLUE_MAGE = "Blue_mag";


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        JSONArray jsonOrchestrion = getJsonFromResource(RATH_JSON +"\\"+DATA+"\\"+ORCH_CAT+".json");
        List<Orchestration> orchestrationList = OrchestrionMapper.orchestrionFromJSONArray(jsonOrchestrion);

        JSONArray jsonMount = getJsonFromResource(RATH_JSON +"\\"+DATA+"\\"+ MOUNT +".json");
        List<Mount> mountList = new ArrayList<>();
        List<Source> sourseList = new ArrayList<>();
        MountMapper.SMFromJSONArray(jsonMount, mountList, sourseList);


        JSONArray jsonBLM = getJsonFromResource(RATH_JSON +"\\"+DATA+"\\"+ BLUE_MAGE +".json");
        List<BlueMage> blueMages = new ArrayList<>();
        BlueMageMapper.SBMFromJSONArray(jsonBLM, blueMages, sourseList);


        JSONArray jsonMinion = getJsonFromResource(RATH_JSON +"\\"+DATA+"\\"+ MINION +".json");
        List<Minion> minionList = new ArrayList<>();
        MinionMapper.SMinFromJSONArray(jsonMinion, minionList, sourseList);



        DBServiceIMPL dbServiceIMPL = context.getBean(DBServiceIMPL.class);
        try {
            dbServiceIMPL.setOrchestrion(orchestrationList);
            dbServiceIMPL.setMount(mountList);
            dbServiceIMPL.setBlueMage(blueMages);
            dbServiceIMPL.setMinion(minionList);
        } catch (IOException e) {
            System.out.println(e.toString());
        }



       try {
           Console.main(args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // чтение json из файла
    private static JSONArray getJsonFromResource(String fileName) {
        //Resource resource = context.getResource(FILE_NAME);
        InputStream is = null;
        try {
            //File initialFile = resource.getFile();//todo

            File initialFile = new File(fileName);
            is = Files.newInputStream(initialFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONTokener tokener = new JSONTokener(is);
        JSONArray object = new JSONArray(tokener);
        return object;
    }
}
