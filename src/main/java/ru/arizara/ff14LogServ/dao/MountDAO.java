package ru.arizara.ff14LogServ.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.arizara.ff14LogServ.entities.Mount;

import java.util.List;

public interface MountDAO extends JpaRepository<Mount, Integer> {



}
