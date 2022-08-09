package ru.arizara.ff14LogServ.service.interfaces;


import ru.arizara.ff14LogServ.entities.Race;
import ru.arizara.ff14LogServ.entities.Skill;

import java.util.List;

public interface SkillService {
    List<Skill> getAll();
}
