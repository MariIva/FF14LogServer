package ru.arizara.ff14LogServ.service;

import ru.arizara.ff14LogServ.entities.Orchestration;

import java.io.IOException;
import java.util.List;

public interface DBService {

    void setOrchestrion(List<Orchestration> list);

    void setImages() throws IOException;

}
