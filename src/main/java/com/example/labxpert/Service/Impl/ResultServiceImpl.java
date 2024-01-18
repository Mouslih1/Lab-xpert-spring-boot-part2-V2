package com.example.labxpert.Service.Impl;

import com.example.labxpert.Dtos.ResultDto;
import com.example.labxpert.Model.Result;
import com.example.labxpert.Repository.IResultRepository;
import com.example.labxpert.Service.IResultService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ResultServiceImpl implements IResultService {

    private IResultRepository iResultRepository;

    @Override
    public ResultDto add(ResultDto resultDto) {
        return null; //iResultRepository.save(result);
    }

    @Override
    public void delete(Long id) {
        // iResultRepository.deleteById(id);
    }

    @Override
    public ResultDto getById(Long id) {
        return null;//iResultRepository.findById(id).orElse(null);
    }

    @Override
    public List<ResultDto> getAll() {
        return null;//iResultRepository.findAll();
    }

    @Override
    public ResultDto update(ResultDto resultDto) {
        return null;///iResultRepository.save(result);
    }

    @Override
    public void validation(ResultDto resultDto) {

    }
}
