package ru.arizara.ff14LogServ.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.arizara.ff14LogServ.entities.Orchestration;
import ru.arizara.ff14LogServ.rest.controller.ImageController;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DBServiceIMPL implements  DBService{

    private final OrchestrionService orchestrionService;
    private final ImageController imageController;

    @Override
    public void setOrchestrion(List<Orchestration> list) {
        for (Orchestration orchestrion : list) {
            orchestrionService.insert(orchestrion);
        }

    }

    @Override
    public void setImages() throws IOException {
        imageController.setImageAmbient();
        imageController.setImageDangeons();
        imageController.setImageLocales1();
        imageController.setImageLocales2();
        imageController.setImageOrch();
        imageController.setImageOthers();
        imageController.setImageRaids1();
        imageController.setImageRaids2();
        imageController.setImageSeasonal();
        imageController.setImageTrials();
    }


}
