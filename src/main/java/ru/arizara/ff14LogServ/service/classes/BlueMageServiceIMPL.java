package ru.arizara.ff14LogServ.service.classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.arizara.ff14LogServ.dao.BlueMageDAO;
import ru.arizara.ff14LogServ.dao.SourceDAO;
import ru.arizara.ff14LogServ.entities.BlueMage;
import ru.arizara.ff14LogServ.entities.Mount;
import ru.arizara.ff14LogServ.entities.Source;
import ru.arizara.ff14LogServ.service.interfaces.BlueMageService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BlueMageServiceIMPL implements BlueMageService {

    private final BlueMageDAO blueMageDAO;
    private final SourceDAO sourceDAO;

    @Override
    public BlueMage insert(BlueMage blueMage) {

        for (Source source : blueMage.getSources()) {
            try {
               List<Source> s = sourceDAO.findByTypeAndText(source.getType(), source.getText());
               if(s.size()>0)
                   source.setId(s.get(0).getId());
               else
                   sourceDAO.save(source);
            } catch (NoSuchElementException e) {
            }
        }

        BlueMage mage = null;
        mage = blueMageDAO.save(blueMage);
        return mage;
    }

    @Override
    public List<BlueMage> getAll() {
        return blueMageDAO.findAll();
    }
}
