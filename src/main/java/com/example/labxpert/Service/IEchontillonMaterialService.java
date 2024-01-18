package com.example.labxpert.Service;

import com.example.labxpert.Dtos.EchontillonDto;
import com.example.labxpert.Dtos.EchontillonMaterialDto;

import java.util.List;

public interface IEchontillonMaterialService {
    EchontillonMaterialDto add(EchontillonMaterialDto echontillonMaterialDto);
    EchontillonMaterialDto update(EchontillonMaterialDto echontillonMaterialDto);
    void delete(Long id);
    List<EchontillonMaterialDto> getAll();
    EchontillonMaterialDto getById(Long id);
    void validation(EchontillonMaterialDto echontillonMaterialDto);
}
