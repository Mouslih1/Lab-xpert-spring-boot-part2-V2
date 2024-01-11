package com.example.labxpert.Service.Impl;

import com.example.labxpert.Model.Echontillon;
import com.example.labxpert.Repository.IEchontillonRepository;
import com.example.labxpert.Service.IEchontillonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class EchontillonServiceImpl implements IEchontillonService {

    private IEchontillonRepository iEchontillonRepository;


    @Override
    public Echontillon add(Echontillon echontillon)
    {
        return iEchontillonRepository.save(echontillon);
    }

    @Override
    public Echontillon update(Echontillon echontillon)
    {
        return iEchontillonRepository.save(echontillon);
    }

    @Override
    public void delete(Long id)
    {
        iEchontillonRepository.deleteById(id);
    }

    @Override
    public List<Echontillon> getAll()
    {
        return iEchontillonRepository.findAll();
    }

    @Override
    public Echontillon getById(Long id)
    {
        return iEchontillonRepository.findById(id).orElse(null);
    }
}
