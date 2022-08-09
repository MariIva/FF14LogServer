package ru.arizara.ff14LogServ.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.arizara.ff14LogServ.rest.dto.BlueMageDTO;
import ru.arizara.ff14LogServ.rest.dto.MountDTO;
import ru.arizara.ff14LogServ.service.interfaces.BlueMageService;
import ru.arizara.ff14LogServ.service.interfaces.MountService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BlueMageController {
    private final BlueMageService blueMageService;

    @GetMapping("/bluemage")
    public List<BlueMageDTO> getAllBlueMage() {

        System.out.println("getAllBlueMage");
        return blueMageService
                .getAll()
                .stream()
                .map(BlueMageDTO::toDTO)
                .collect(Collectors.toList());
    }
}
