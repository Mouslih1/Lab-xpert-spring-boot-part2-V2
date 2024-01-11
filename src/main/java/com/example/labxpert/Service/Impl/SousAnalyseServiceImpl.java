package com.example.labxpert.Service.Impl;

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
    public SousAnalyse add(SousAnalyse sousAnalyse) {
        return iSousAnalyseRepository.save(sousAnalyse);
    }

    @Override
    public SousAnalyse update(SousAnalyse sousAnalyse) {
        return iSousAnalyseRepository.save(sousAnalyse);
    }

    @Override
    public void delete(Long id) {
        iSousAnalyseRepository.deleteById(id);
    }

    @Override
    public List<SousAnalyse> getAll() {
        return iSousAnalyseRepository.findAll();
    }

    @Override
    public SousAnalyse getById(Long id) {
        return iSousAnalyseRepository.findById(id).orElse(null);
    }
}
