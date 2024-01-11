package com.example.labxpert.Service;

import com.example.labxpert.Model.Planification;

import java.util.List;

public interface IPlanificationService {
    Planification add(Planification planification);
    Planification update(Planification planification);
    void delete(Long id);
    List<Planification> getAll();
    Planification getById(Long id);
}
