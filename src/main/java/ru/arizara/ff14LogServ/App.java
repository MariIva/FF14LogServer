package ru.arizara.ff14LogServ;

import org.h2.tools.Console;
import org.json.JSONArray;
import org.json.JSONTokener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.arizara.ff14LogServ.entities.Mount;
import ru.arizara.ff14LogServ.entities.Orchestration;
import ru.arizara.ff14LogServ.entities.Source;
import ru.arizara.ff14LogServ.mapper.MountMapper;
import ru.arizara.ff14LogServ.mapper.OrchestrionMapper;
import ru.arizara.ff14LogServ.mapper.SourceMapper;
import ru.arizara.ff14LogServ.service.classes.DBServiceIMPL;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class App {

    //public static final String FILE_NAME = "src/main/resources/db.changelog/data/json/2022_05_05-0002-Orchestrion_CategoryLog.json";

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        JSONArray jsonOrchestrion = getJsonFromResource("E:\\FF14\\FF14LogServer-master\\src\\main\\resources\\db.changelog\\data\\json\\2022_05_05-0002-Orchestrion_CategoryLog.json");
        List<Orchestration> orchestrationList = OrchestrionMapper.orchestrionFromJSONArray(jsonOrchestrion);

        JSONArray jsonMount = getJsonFromResource("E:\\FF14\\FF14LogServer-master\\src\\main\\resources\\db.changelog\\data\\json\\2022_08_06-0004-Mounts.json");
        List<Mount> mountList = MountMapper.mountFromJSONArray(jsonMount);
        List<Source> sourseList = SourceMapper.sourseFromJSONArray(jsonMount);

        System.out.println(mountList);

        DBServiceIMPL dbServiceIMPL = context.getBean(DBServiceIMPL.class);

        try {
            dbServiceIMPL.setOrchestrion(orchestrationList);
            dbServiceIMPL.setMount(mountList);
            dbServiceIMPL.setSource(sourseList);
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
            //String str = "E:\\FF14\\FF14LogServer-master\\src\\main\\resources\\db.changelog\\data\\json\\2022_05_05-0002-Orchestrion_CategoryLog.json";
            //String str = "db.changelog/data/json/2022_05_05-0002-Orchestrion_CategoryLog.json";
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
