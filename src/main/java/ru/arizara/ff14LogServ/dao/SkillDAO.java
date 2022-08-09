package ru.arizara.ff14LogServ.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arizara.ff14LogServ.entities.Race;
import ru.arizara.ff14LogServ.entities.Skill;

public interface SkillDAO extends JpaRepository<Skill, Integer> {

}
