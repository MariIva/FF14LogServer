package ru.arizara.ff14LogServ.service.interfaces;

import ru.arizara.ff14LogServ.entities.*;

import java.io.IOException;
import java.util.List;

public interface DBService {

    void setOrchestrion(List<Orchestration> list) throws IOException;
    void setMount(List<Mount> list) throws IOException;
    void setSource(List<Source> list) throws IOException;
    void setBlueMage(List<BlueMage> list) throws IOException;
    void setMinion(List<Minion> list) throws IOException;


    void setImagesCategoryLog() throws IOException;
    void setImagesMount(int id) throws IOException;
    void setImagesBLM(int id) throws IOException;
    void setImagesMinion(int id) throws IOException;
    void setImagesRace() throws IOException;

}
