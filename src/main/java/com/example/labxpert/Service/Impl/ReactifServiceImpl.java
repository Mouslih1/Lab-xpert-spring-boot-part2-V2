package com.example.labxpert.Service.Impl;

import com.example.labxpert.Model.Reactif;
import com.example.labxpert.Repository.IReactifRepository;
import com.example.labxpert.Service.IReactifService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ReactifServiceImpl implements IReactifService {

    private IReactifRepository iReactifRepository;


    @Override
    public Reactif add(Reactif reactif) {
        return iReactifRepository.save(reactif);
    }

    @Override
    public Reactif update(Reactif reactif) {
        return iReactifRepository.save(reactif);
    }

    @Override
    public void delete(Long id) {
        iReactifRepository.deleteById(id);
    }

    @Override
    public List<Reactif> getAll() {
        return iReactifRepository.findAll();
    }

    @Override
    public Reactif getById(Long id) {
        return iReactifRepository.findById(id).orElse(null);
    }
}
