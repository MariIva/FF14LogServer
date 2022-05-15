package ru.arizara.ff14LogServ.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.arizara.ff14LogServ.dao.CategoryLogDAO;
import ru.arizara.ff14LogServ.entities.CategoryLog;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryLogServiceIMPL implements CategoryLogService{

    private final CategoryLogDAO categoryLogDAO;

    @Override
    public List<CategoryLog> getAll() {

        return categoryLogDAO.findAll();
    }
}
