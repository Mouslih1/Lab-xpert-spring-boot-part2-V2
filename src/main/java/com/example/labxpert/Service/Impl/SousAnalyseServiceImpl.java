package com.example.labxpert.Service.Impl;

import com.example.labxpert.Dtos.SousAnalyseDto;
import com.example.labxpert.Model.SousAnalyse;
import com.example.labxpert.Repository.ISousAnalyseRepository;
import com.example.labxpert.Service.ISousAnalyseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class SousAnalyseServiceImpl implements ISousAnalyseService {

    private ISousAnalyseRepository iSousAnalyseRepository;


    @Override
    public SousAnalyseDto add(SousAnalyseDto sousAnalyseDto) {
        return null;//iSousAnalyseRepository.save(sousAnalyse);
    }

    @Override
    public SousAnalyseDto update(SousAnalyseDto sousAnalyseDto) {
        return null;//iSousAnalyseRepository.save(sousAnalyse);
    }

    @Override
    public void delete(Long id) {
        //iSousAnalyseRepository.deleteById(id);
    }

    @Override
    public List<SousAnalyseDto> getAll() {
        return null;//iSousAnalyseRepository.findAll();
    }

    @Override
    public SousAnalyseDto getById(Long id) {
        return null;//iSousAnalyseRepository.findById(id).orElse(null);
    }

    @Override
    public void validation(SousAnalyseDto sousAnalyseDto) {

    }
}
