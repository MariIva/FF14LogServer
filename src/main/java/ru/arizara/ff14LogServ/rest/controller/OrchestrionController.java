package ru.arizara.ff14LogServ.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.arizara.ff14LogServ.rest.dto.OrchestrionDTO;
import ru.arizara.ff14LogServ.service.interfaces.OrchestrionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrchestrionController {
    private final OrchestrionService orchestrionService;

    @GetMapping("/orchestrion")
    public List<OrchestrionDTO> getAllOrchestrion() {

        System.out.println("getAllOrchestrion");
        return orchestrionService
                .getAll()
                .stream()
                .map(OrchestrionDTO::toDTO)
                .collect(Collectors.toList());
    }


   /*@RequestMapping(value = "orchestrion", params = {"patch"})
    public List<OrchestrionDTO> getOrchestrionByAddon(@RequestParam String patch) {

       System.out.println("getOrchestrionByAddon");
        return orchestrionService
                .getByPatch(patch +".%")
                .stream()
                .map(OrchestrionDTO::toDTO)
                .collect(Collectors.toList());
    }*/
}
