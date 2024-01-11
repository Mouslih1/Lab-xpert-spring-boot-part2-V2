package com.example.labxpert.Service;

import com.example.labxpert.Model.SousAnalyse;

import java.util.List;

public interface ISousAnalyseService {
    SousAnalyse add(SousAnalyse sousAnalyse);
    SousAnalyse update(SousAnalyse sousAnalyse);
    void delete(Long id);
    List<SousAnalyse> getAll();
    SousAnalyse getById(Long id);
}
