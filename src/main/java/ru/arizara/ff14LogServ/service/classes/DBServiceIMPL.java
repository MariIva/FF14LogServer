package ru.arizara.ff14LogServ.service.classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.arizara.ff14LogServ.entities.*;
import ru.arizara.ff14LogServ.rest.controller.ImageController;
import ru.arizara.ff14LogServ.service.interfaces.*;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DBServiceIMPL implements DBService {

    private final OrchestrionService orchestrionService;
    private final MountService mountService;
    private final SourceService sourceService;
    private final ImageController imageController;
    private final BlueMageService blueMageService;
    private final MinionService minionService;

    @Override
    public void setOrchestrion(List<Orchestration> list) throws IOException  {
        for (Orchestration orchestrion : list) {
            orchestrionService.insert(orchestrion);
        }
        setImagesCategoryLog();
    }

    @Override
    public void setMount(List<Mount> list) throws IOException {
        for (Mount mount : list) {
            mountService.insert(mount);
            setImagesMount(mount.getId());
        }
    }

    @Override
    public void setSource(List<Source> list) {
        for (Source source : list) {
            sourceService.insert(source);
        }
        //TODO load source icons
    }

    @Override
    public void setBlueMage(List<BlueMage> list) throws IOException {
        for (BlueMage blueMage : list) {
            blueMageService.insert(blueMage);
            setImagesBLM(blueMage.getId());
        }
    }

    @Override
    public void setMinion(List<Minion> list) throws IOException {
        for (Minion minion : list) {
            minionService.insert(minion);
            setImagesMinion(minion.getId());
        }
        setImagesRace();
    }

    public void setImagesCategoryLog() throws IOException {
        imageController.setImageOneDir("orchestrion", "ambient");
        imageController.setImageOneDir("orchestrion", "dangeons");
        imageController.setImageOneDir("orchestrion", "locales1");
        imageController.setImageOneDir("orchestrion", "locales2");
        imageController.setImageOneDir("orchestrion", "locales2");
        imageController.setImageOneDir("orchestrion", "others");
        imageController.setImageOneDir("orchestrion", "raids1");
        imageController.setImageOneDir("orchestrion", "raids2");
        imageController.setImageOneDir("orchestrion", "seasonal");
        imageController.setImageOneDir("orchestrion", "trials");
        imageController.setImageOneDir("orchestrion", "orchestration");
    }
    public void setImagesMount(int id) throws IOException {
        imageController.setImageTwoDir("mount", "large", ""+id);
        imageController.setImageTwoDir("mount","small", ""+id);
    }
    public void setImagesBLM(int id) throws IOException {
        imageController.setImageOneDir("blue_mage",  ""+id);
    }
    public void setImagesMinion(int id) throws IOException {
        imageController.setImageTwoDir("minion", "large", ""+id);
        imageController.setImageTwoDir("minion","small", ""+id);
    }

    @Override
    public void setImagesRace() throws IOException { //TODO
        //imageController.setImageOneDir("minion/race", "");

    }

}
