package ru.arizara.ff14LogServ.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.arizara.ff14LogServ.rest.dto.CategoryLogDTO;
import ru.arizara.ff14LogServ.rest.dto.SourceDTO;
import ru.arizara.ff14LogServ.service.interfaces.SourceService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SourceController {
    private final SourceService sourceService;

    @GetMapping("/source")
    public List<SourceDTO> getAllSource() {
        System.out.println("getAllSource");
        return sourceService
                .getAll()
                .stream()
                .map(SourceDTO::toDTO)
                .collect(Collectors.toList());
    }
}
