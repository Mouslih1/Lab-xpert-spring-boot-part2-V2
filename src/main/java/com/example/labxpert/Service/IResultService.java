package com.example.labxpert.Service;

import com.example.labxpert.Dtos.PatientDto;
import com.example.labxpert.Dtos.ResultDto;
import com.example.labxpert.Model.Analyse;
import com.example.labxpert.Model.Result;

import java.util.List;

public interface IResultService {
    ResultDto add(ResultDto resultDto);
    void delete(Long id);
    ResultDto getById(Long id);
    List<ResultDto> getAll();
    ResultDto update(ResultDto resultDto);
    void validation(ResultDto resultDto);

}
