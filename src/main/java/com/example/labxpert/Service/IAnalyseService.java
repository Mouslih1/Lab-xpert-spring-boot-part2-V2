package com.example.labxpert.Service;

import com.example.labxpert.Model.Analyse;

import java.util.List;

public interface IAnalyseService {
    Analyse add(Analyse analyse);
    Analyse update(Analyse analyse);
    void delete(Long id);
    List<Analyse> getAll();
    Analyse getById(Long id);
}
