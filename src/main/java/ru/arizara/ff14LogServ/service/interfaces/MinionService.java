package ru.arizara.ff14LogServ.service.interfaces;

import ru.arizara.ff14LogServ.entities.Minion;
import ru.arizara.ff14LogServ.entities.Mount;

import java.util.List;

public interface MinionService {
    Minion insert(Minion minion);

    public List<Minion> getAll();
}
