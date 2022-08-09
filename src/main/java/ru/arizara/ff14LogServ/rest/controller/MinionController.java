package ru.arizara.ff14LogServ.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.arizara.ff14LogServ.rest.dto.MinionDTO;
import ru.arizara.ff14LogServ.service.interfaces.MinionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MinionController {
    private final MinionService minionService;

    @GetMapping("/minion")
    public List<MinionDTO> getAllMount() {

        System.out.println("getAllMinion");
        return minionService
                .getAll()
                .stream()
                .map(MinionDTO::toDTO)
                .collect(Collectors.toList());
    }
}
