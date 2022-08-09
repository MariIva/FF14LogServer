package ru.arizara.ff14LogServ.service.classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.arizara.ff14LogServ.dao.RaceDAO;
import ru.arizara.ff14LogServ.entities.Race;
import ru.arizara.ff14LogServ.service.interfaces.RaceService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RaceServiceIMPL implements RaceService {

    private final RaceDAO raceDAO;

    @Override
    public List<Race> getAll() {

        return raceDAO.findAll();
    }
}
