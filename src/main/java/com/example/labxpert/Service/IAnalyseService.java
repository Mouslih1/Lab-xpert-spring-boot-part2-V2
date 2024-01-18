package com.example.labxpert.Service;

import com.example.labxpert.Dtos.AnalyseDto;
import com.example.labxpert.Dtos.MaterialDto;
import com.example.labxpert.Model.Analyse;

import java.util.List;

public interface IAnalyseService {
    AnalyseDto add(AnalyseDto analyseDto);
    AnalyseDto update(AnalyseDto analyseDto);
    void delete(Long id);
    List<AnalyseDto> getAll();
    AnalyseDto getById(Long id);
    void validation(AnalyseDto analyseDto);

}
