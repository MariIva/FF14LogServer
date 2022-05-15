package ru.arizara.ff14LogServ;

import org.h2.tools.Console;
import org.json.JSONArray;
import org.json.JSONTokener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import ru.arizara.ff14LogServ.entities.Orchestrion;
import ru.arizara.ff14LogServ.mapper.OrchestrionMapper;
import ru.arizara.ff14LogServ.service.DBServiceIMPL;

import java.io.*;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class App {

    public static final String FILE_NAME = "db.changelog/data/json/2022_05_05-0002-Orchestrion_CategoryLog.json";

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        JSONArray json = getJsonFromResource(context);
        List<Orchestrion> list = OrchestrionMapper.orchestrionFromJSONArray(json);

        DBServiceIMPL dbServiceIMPL = context.getBean(DBServiceIMPL.class);
        dbServiceIMPL.setOrchestrion(list);


       /* try {
            Console.main(args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }

    // чтение json из файла
    private static JSONArray getJsonFromResource(ConfigurableApplicationContext context) {
        Resource resource = context.getResource(FILE_NAME);
        InputStream is = null;
        try {
            File file  =resource.getFile();//todo
            String str = "E:/JavaProject/IJSpring/FF14LogServer/src/main/resources/db.changelog/data/json/2022_05_05-0002-Orchestrion_CategoryLog.json";
            File initialFile = new File(str);
            is = Files.newInputStream(initialFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONTokener tokener = new JSONTokener(is);
        JSONArray object = new JSONArray(tokener);
        return object;
    }
}
