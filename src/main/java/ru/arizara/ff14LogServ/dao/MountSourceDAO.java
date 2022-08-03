package ru.arizara.ff14LogServ.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arizara.ff14LogServ.entities.MountSource;
import ru.arizara.ff14LogServ.entities.Orchestration;

public interface MountSourceDAO   extends JpaRepository<MountSource, Integer> {
}
