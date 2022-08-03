package ru.arizara.ff14LogServ.service.interfaces;

import ru.arizara.ff14LogServ.entities.Mount;
import ru.arizara.ff14LogServ.entities.Orchestration;

import java.util.List;

public interface MountService {
    Mount insert(Mount mount);

    public List<Mount> getAll();
}
