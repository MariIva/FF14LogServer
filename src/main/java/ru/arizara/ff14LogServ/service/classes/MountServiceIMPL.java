package ru.arizara.ff14LogServ.service.classes;

import lombok.RequiredArgsConstructor;
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

        /*for (Source source : mount.getSources()) {
            try {
                sourceDAO.findByText(source.getText());
            } catch (NoSuchElementException e) {
                sourceDAO.save(source);
            }
        }*/

        return mountDAO.save(mount);
    }

    @Override
    public List<Mount> getAll() {
        return mountDAO.findAll();
    }
}
