package com.example.labxpert.Service;

import com.example.labxpert.Model.Echontillon;

import java.util.List;

public interface IEchontillonService {
    Echontillon add(Echontillon echontillon);
    Echontillon update(Echontillon echontillon);
    void delete(Long id);
    List<Echontillon> getAll();
    Echontillon getById(Long id);
}
