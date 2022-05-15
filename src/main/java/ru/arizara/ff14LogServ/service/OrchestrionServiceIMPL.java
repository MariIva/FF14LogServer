package ru.arizara.ff14LogServ.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.arizara.ff14LogServ.dao.CategoryLogDAO;
import ru.arizara.ff14LogServ.dao.OrchestrionDAO;
import ru.arizara.ff14LogServ.entities.CategoryLog;
import ru.arizara.ff14LogServ.entities.Orchestrion;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrchestrionServiceIMPL implements OrchestrionService{

    private final CategoryLogDAO categoryLogDAO;
    private final OrchestrionDAO orchestrionDAO;

    @Override
    //@Transactional
    public Orchestrion insert(Orchestrion orchestrion) {

        try {
            categoryLogDAO.findById(orchestrion.getCategory().getId()).get();
        }
        catch (NoSuchElementException e){
            categoryLogDAO.save(orchestrion.getCategory());
        }
        return orchestrionDAO.save(orchestrion);
    }

    @Override
    public List<Orchestrion> getAll() {

        return orchestrionDAO.findAll();
    }

    @Override
    public List<Orchestrion> getByPatch(String patch) {
        return orchestrionDAO.findByPatch(patch);
    }

}
