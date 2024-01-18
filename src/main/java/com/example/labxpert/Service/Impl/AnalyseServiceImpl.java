package com.example.labxpert.Service.Impl;

import com.example.labxpert.Dtos.AnalyseDto;
import com.example.labxpert.Model.Analyse;
import com.example.labxpert.Repository.IAnalyseRepository;
import com.example.labxpert.Service.IAnalyseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AnalyseServiceImpl implements IAnalyseService {

    private IAnalyseRepository iAnalyseRepository;


    @Override
    public AnalyseDto add(AnalyseDto analyseDto)
    {
        return null;
    }

    @Override
    public AnalyseDto update(AnalyseDto analyseDto)
    {
        return null;
    }

    @Override
    public void delete(Long id)
    {
        //iAnalyseRepository.deleteById(id);
    }

    @Override
    public List<AnalyseDto> getAll()
    {
        return null;
    }

    @Override
    public AnalyseDto getById(Long id)
    {
        return null;//iAnalyseRepository.findById(id).orElse(null);
    }

    @Override
    public void validation(AnalyseDto analyseDto) {

    }
}
