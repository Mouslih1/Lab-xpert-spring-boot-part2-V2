package com.example.labxpert.Service.Impl;

import com.example.labxpert.Dtos.ReactifDto;
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
    public ReactifDto add(ReactifDto reactif) {
        return null;//iReactifRepository.save(reactif);
    }

    @Override
    public ReactifDto update(ReactifDto reactifDto) {
        return null;//iReactifRepository.save(reactif);
    }

    @Override
    public void delete(Long id) {
        //iReactifRepository.deleteById(id);
    }

    @Override
    public List<ReactifDto> getAll() {
        return null;//iReactifRepository.findAll();
    }

    @Override
    public ReactifDto getById(Long id) {
        return null;//iReactifRepository.findById(id).orElse(null);
    }

    @Override
    public ReactifDto getByName(String name) {
        return null;
    }

    @Override
    public void validation(ReactifDto ReactifDto) {

    }
}
