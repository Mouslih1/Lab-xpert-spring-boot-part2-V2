package com.example.labxpert.Service.Impl;

import com.example.labxpert.Dtos.EchontillonDto;
import com.example.labxpert.Dtos.EchontillonMaterialDto;
import com.example.labxpert.Repository.IEchontillonMaterialRepository;
import com.example.labxpert.Repository.IEchontillonRepository;
import com.example.labxpert.Service.IEchontillonMaterialService;
import com.example.labxpert.Service.IEchontillonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EchontillonMaterialServiceImpl implements IEchontillonMaterialService {

    private final IEchontillonMaterialRepository iEchontillonMaterialRepository;


    @Override
    public EchontillonMaterialDto add(EchontillonMaterialDto echontillonMaterialDto) {
        return null;
    }

    @Override
    public EchontillonMaterialDto update(EchontillonMaterialDto echontillonMaterialDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<EchontillonMaterialDto> getAll() {
        return null;
    }

    @Override
    public EchontillonMaterialDto getById(Long id) {
        return null;
    }

    @Override
    public void validation(EchontillonMaterialDto echontillonMaterialDto) {

    }
}
