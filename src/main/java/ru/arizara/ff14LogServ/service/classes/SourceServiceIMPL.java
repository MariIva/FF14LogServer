package ru.arizara.ff14LogServ.service.classes;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.arizara.ff14LogServ.dao.SourceDAO;
import ru.arizara.ff14LogServ.entities.Source;
import ru.arizara.ff14LogServ.service.interfaces.SourceService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SourceServiceIMPL implements SourceService {

   private final SourceDAO sourceDAO;


    @Override
    public List<Source> getAll() {
        return sourceDAO.findAll();
    }

    @Override
    public Source insert(Source source) {
        try {
            return sourceDAO.save(source);
        }
        catch (DataIntegrityViolationException e){
            return null;
        }
    }
}
