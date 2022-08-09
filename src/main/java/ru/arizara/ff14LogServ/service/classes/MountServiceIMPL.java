package ru.arizara.ff14LogServ.service.classes;

import lombok.RequiredArgsConstructor;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.arizara.ff14LogServ.dao.MountDAO;
import ru.arizara.ff14LogServ.dao.SourceDAO;
import ru.arizara.ff14LogServ.entities.Mount;
import ru.arizara.ff14LogServ.entities.Source;
import ru.arizara.ff14LogServ.service.interfaces.MountService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MountServiceIMPL implements MountService {

    private final MountDAO mountDAO;
    private final SourceDAO sourceDAO;

    @Override
    public Mount insert(Mount mount) {

        for (Source source : mount.getSources()) {
            try {
               List<Source> s = sourceDAO.findByTypeAndText(source.getType(), source.getText());
               if(s.size()>0)
                   source.setId(s.get(0).getId());
               else
                   sourceDAO.save(source);
            } catch (NoSuchElementException e) {
            }
        }

        Mount m = null;
        m = mountDAO.save(mount);
        return m;
    }

    @Override
    public List<Mount> getAll() {
        return mountDAO.findAll();
    }
}
