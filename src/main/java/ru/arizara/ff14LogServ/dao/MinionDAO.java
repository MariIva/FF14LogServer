package ru.arizara.ff14LogServ.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arizara.ff14LogServ.entities.Minion;
import ru.arizara.ff14LogServ.entities.Race;

public interface MinionDAO extends JpaRepository<Minion, Integer> {

}
