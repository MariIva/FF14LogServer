package ru.arizara.ff14LogServ.service;

import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.arizara.ff14LogServ.dao.OrchestrionDAO;
import ru.arizara.ff14LogServ.entities.CategoryLog;
import ru.arizara.ff14LogServ.entities.Orchestrion;
import ru.arizara.ff14LogServ.mapper.OrchestrionMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DBServiceIMPL implements  DBService{

    private final OrchestrionService orchestrionService;

    @Override
    public void setOrchestrion(List<Orchestrion> list) {
        for (Orchestrion orchestrion : list) {
            orchestrionService.insert(orchestrion);
        }

    }



}
