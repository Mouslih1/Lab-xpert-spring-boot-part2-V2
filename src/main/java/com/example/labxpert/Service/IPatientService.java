package com.example.labxpert.Service;

import com.example.labxpert.Model.Patient;

import java.util.List;

public interface IPatientService {
    Patient add(Patient patient);
    Patient update(Patient patient);
    void delete(Long id);
    List<Patient> getAll();
    Patient getById(Long id);
}
