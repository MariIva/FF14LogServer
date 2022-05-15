package ru.arizara.ff14LogServ.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arizara.ff14LogServ.entities.CategoryLog;

public interface CategoryLogDAO extends JpaRepository<CategoryLog, Integer> {

}
