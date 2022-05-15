package ru.arizara.ff14LogServ.service;

import ru.arizara.ff14LogServ.entities.Orchestrion;

import java.util.List;

public interface OrchestrionService {

    Orchestrion insert(Orchestrion orchestrion);

    public List<Orchestrion> getAll();

    public List<Orchestrion> getByPatch(String patch);

}
