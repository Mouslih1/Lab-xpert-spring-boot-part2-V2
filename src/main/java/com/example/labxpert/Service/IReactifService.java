package com.example.labxpert.Service;

import com.example.labxpert.Model.Reactif;

import java.util.List;

public interface IReactifService {
    Reactif add(Reactif reactif);
    Reactif update(Reactif reactif);
    void delete(Long id);
    List<Reactif> getAll();
    Reactif getById(Long id);
}
