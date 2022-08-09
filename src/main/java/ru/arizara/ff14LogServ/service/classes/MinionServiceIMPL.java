package ru.arizara.ff14LogServ.service.classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.arizara.ff14LogServ.dao.*;
import ru.arizara.ff14LogServ.entities.Minion;
import ru.arizara.ff14LogServ.entities.Source;
import ru.arizara.ff14LogServ.service.interfaces.MinionService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MinionServiceIMPL implements MinionService {

    private final MinionDAO minionDAO;
    private final SourceDAO sourceDAO;
    private final RaceDAO raceDAO;
    private final SkillDAO skillDAO;
    private final StatisticsDAO statisticsDAO;

    @Override
    public Minion insert(Minion minion) {

        for (Source source : minion.getSources()) {
            try {
               List<Source> s = sourceDAO.findByTypeAndText(source.getType(), source.getText());
               if(s.size()>0)
                   source.setId(s.get(0).getId());
               else
                   sourceDAO.save(source);
            } catch (NoSuchElementException e) {
            }
        }

        try {
            raceDAO.findById(minion.getRace().getId()).get();
        }
        catch (NoSuchElementException e){
            raceDAO.save(minion.getRace());
        }

        try {
            //skillDAO.findById(minion.getSkill()).get();
            skillDAO.save(minion.getSkill());
        }
        catch (NoSuchElementException e){
        }

        try {
            statisticsDAO.save(minion.getStats());
        }
        catch (NoSuchElementException e){
        }

        Minion m = null;
        m = minionDAO.save(minion);
        return m;
    }

    @Override
    public List<Minion> getAll() {
        return minionDAO.findAll();
    }
}
