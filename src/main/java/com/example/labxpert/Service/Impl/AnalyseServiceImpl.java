package com.example.labxpert.Service.Impl;

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
    public Analyse add(Analyse analyse)
    {
        return iAnalyseRepository.save(analyse);
    }

    @Override
    public Analyse update(Analyse analyse)
    {
        return iAnalyseRepository.save(analyse);
    }

    @Override
    public void delete(Long id)
    {
        iAnalyseRepository.deleteById(id);
    }

    @Override
    public List<Analyse> getAll()
    {
        return iAnalyseRepository.findAll();
    }

    @Override
    public Analyse getById(Long id)
    {
        return iAnalyseRepository.findById(id).orElse(null);
    }
}
