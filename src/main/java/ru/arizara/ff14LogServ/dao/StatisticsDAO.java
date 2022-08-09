package ru.arizara.ff14LogServ.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.arizara.ff14LogServ.entities.Statistics;

public interface StatisticsDAO extends JpaRepository<Statistics, Integer> {

}
