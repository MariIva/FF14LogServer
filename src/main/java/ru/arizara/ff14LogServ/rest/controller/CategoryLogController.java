package ru.arizara.ff14LogServ.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.arizara.ff14LogServ.rest.dto.CategoryLogDTO;
import ru.arizara.ff14LogServ.service.CategoryLogService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class CategoryLogController {

    private final CategoryLogService categoryLogService;

    @GetMapping("/categorylog")
    public List<CategoryLogDTO> getAllCategoryLog() {

        System.out.println("getAllCategoryLog");
        return categoryLogService
                .getAll()
                .stream()
                .map(CategoryLogDTO::toDTO)
                .collect(Collectors.toList());
    }

}
