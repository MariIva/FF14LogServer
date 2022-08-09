package ru.arizara.ff14LogServ.service.interfaces;

import ru.arizara.ff14LogServ.entities.BlueMage;

import java.util.List;

public interface BlueMageService {
    BlueMage insert(BlueMage blueMage);

    public List<BlueMage> getAll();
}
