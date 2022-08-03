package ru.arizara.ff14LogServ.service.interfaces;

import ru.arizara.ff14LogServ.entities.Orchestration;

import java.util.List;

public interface OrchestrionService {

    Orchestration insert(Orchestration orchestrion);

    public List<Orchestration> getAll();

   // public List<Orchestration> getByPatch(String patch);

}
