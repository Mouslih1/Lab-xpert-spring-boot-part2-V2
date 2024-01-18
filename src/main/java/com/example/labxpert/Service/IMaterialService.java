package com.example.labxpert.Service;

import com.example.labxpert.Dtos.MaterialDto;
import com.example.labxpert.Dtos.PatientDto;

import java.util.List;

public interface IMaterialService {

    MaterialDto add(MaterialDto materialDto);
    MaterialDto update(Long id, MaterialDto materialDto);
    void delete(Long id);
    List<MaterialDto> getAll();
    MaterialDto getById(Long id);
    MaterialDto getByLibelle(String libelle);
    void validation(MaterialDto materialDto);
}
