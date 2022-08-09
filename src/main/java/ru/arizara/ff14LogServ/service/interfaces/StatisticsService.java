package ru.arizara.ff14LogServ.service.interfaces;


import ru.arizara.ff14LogServ.entities.Skill;
import ru.arizara.ff14LogServ.entities.Statistics;

import java.util.List;

public interface StatisticsService {
    List<Statistics> getAll();
}
