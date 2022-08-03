package ru.arizara.ff14LogServ.service.interfaces;

import ru.arizara.ff14LogServ.entities.CategoryLog;

import java.util.List;

public interface CategoryLogService {
    public List<CategoryLog> getAll();
}
