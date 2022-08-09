package ru.arizara.ff14LogServ.service.classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.arizara.ff14LogServ.dao.StatisticsDAO;
import ru.arizara.ff14LogServ.entities.Statistics;
import ru.arizara.ff14LogServ.service.interfaces.StatisticsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsServiceIMPL implements StatisticsService {

    private final StatisticsDAO statisticsDAO;

    @Override
    public List<Statistics> getAll() {

        return statisticsDAO.findAll();
    }
}
