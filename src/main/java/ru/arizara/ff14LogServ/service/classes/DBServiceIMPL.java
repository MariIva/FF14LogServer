package ru.arizara.ff14LogServ.service.classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.arizara.ff14LogServ.entities.Mount;
import ru.arizara.ff14LogServ.entities.Orchestration;
import ru.arizara.ff14LogServ.entities.Source;
import ru.arizara.ff14LogServ.mapper.SourceMapper;
import ru.arizara.ff14LogServ.rest.controller.ImageController;
import ru.arizara.ff14LogServ.service.interfaces.DBService;
import ru.arizara.ff14LogServ.service.interfaces.MountService;
import ru.arizara.ff14LogServ.service.interfaces.OrchestrionService;
import ru.arizara.ff14LogServ.service.interfaces.SourceService;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DBServiceIMPL implements DBService {

    private final OrchestrionService orchestrionService;
    private final MountService mountService;
    private final SourceService sourceService;
    private final ImageController imageController;

    @Override
    public void setOrchestrion(List<Orchestration> list) throws IOException  {
        for (Orchestration orchestrion : list) {
            orchestrionService.insert(orchestrion);
        }
        setImagesOrch();
    }

    @Override
    public void setMount(List<Mount> list) throws IOException {
        for (Mount mount : list) {
            mountService.insert(mount);
        }
    }

    @Override
    public void setSource(List<Source> list) throws IOException {
        for (Source source : list) {
            sourceService.insert(source);
        }
    }

    public void setImagesOrch() throws IOException {
        imageController.setImageOrchestrion("ambient");
        imageController.setImageOrchestrion("dangeons");
        imageController.setImageOrchestrion("locales1");
        imageController.setImageOrchestrion("locales2");
        imageController.setImageOrchestrion("locales2");
        imageController.setImageOrchestrion("others");
        imageController.setImageOrchestrion("raids1");
        imageController.setImageOrchestrion("raids2");
        imageController.setImageOrchestrion("seasonal");
        imageController.setImageOrchestrion("trials");
        imageController.setImageOrchestrion("orchestration");
    }


}
