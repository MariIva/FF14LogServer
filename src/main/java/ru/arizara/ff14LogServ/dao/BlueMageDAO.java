package ru.arizara.ff14LogServ.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arizara.ff14LogServ.entities.BlueMage;

public interface BlueMageDAO  extends JpaRepository<BlueMage, Integer> {
}
