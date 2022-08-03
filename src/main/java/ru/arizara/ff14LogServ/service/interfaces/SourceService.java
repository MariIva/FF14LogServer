package ru.arizara.ff14LogServ.service.interfaces;

import ru.arizara.ff14LogServ.entities.CategoryLog;
import ru.arizara.ff14LogServ.entities.Mount;
import ru.arizara.ff14LogServ.entities.Source;

import java.util.List;

public interface SourceService {
    List<Source> getAll();
    Source insert(Source source);
}
