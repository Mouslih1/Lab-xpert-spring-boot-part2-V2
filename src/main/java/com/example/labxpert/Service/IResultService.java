package com.example.labxpert.Service;

import com.example.labxpert.Model.Analyse;
import com.example.labxpert.Model.Result;

import java.util.List;

public interface IResultService {
    Result add(Result result);
    void delete(Long id);
    Result getById(Long id);
    List<Result> getAll();
    Result update(Result result);
}
