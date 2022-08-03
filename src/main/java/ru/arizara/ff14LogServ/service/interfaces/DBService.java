package ru.arizara.ff14LogServ.service.interfaces;

import ru.arizara.ff14LogServ.entities.Mount;
import ru.arizara.ff14LogServ.entities.Orchestration;
import ru.arizara.ff14LogServ.entities.Source;

import java.io.IOException;
import java.util.List;

public interface DBService {

    void setOrchestrion(List<Orchestration> list) throws IOException;
    void setMount(List<Mount> list) throws IOException;
    void setSource(List<Source> list) throws IOException;
    //void setImagesOrch() throws IOException;

}
