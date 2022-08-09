package ru.arizara.ff14LogServ.service.classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.arizara.ff14LogServ.dao.SkillDAO;
import ru.arizara.ff14LogServ.entities.Race;
import ru.arizara.ff14LogServ.entities.Skill;
import ru.arizara.ff14LogServ.service.interfaces.SkillService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillServiceIMPL implements SkillService {

    private final SkillDAO skillDAO;

    @Override
    public List<Skill> getAll() {

        return skillDAO.findAll();
    }
}
