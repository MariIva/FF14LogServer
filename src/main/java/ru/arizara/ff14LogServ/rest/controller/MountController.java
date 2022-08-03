package ru.arizara.ff14LogServ.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.arizara.ff14LogServ.rest.dto.MountDTO;
import ru.arizara.ff14LogServ.rest.dto.OrchestrionDTO;
import ru.arizara.ff14LogServ.service.interfaces.MountService;
import ru.arizara.ff14LogServ.service.interfaces.OrchestrionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MountController {
    private final MountService mountService;

    @GetMapping("/mount")
    public List<MountDTO> getAllMount() {

        System.out.println("getAllMount");
        return mountService
                .getAll()
                .stream()
                .map(MountDTO::toDTO)
                .collect(Collectors.toList());
    }
}
