package ru.arizara.ff14LogServ.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arizara.ff14LogServ.entities.CategoryLog;
import ru.arizara.ff14LogServ.entities.Race;

public interface RaceDAO extends JpaRepository<Race, Integer> {

}
