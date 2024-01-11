package com.example.labxpert.Service.Impl;

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
    public Result add(Result result) {
        return iResultRepository.save(result);
    }

    @Override
    public void delete(Long id) {
        iResultRepository.deleteById(id);
    }

    @Override
    public Result getById(Long id) {
        return iResultRepository.findById(id).orElse(null);
    }

    @Override
    public List<Result> getAll() {
        return iResultRepository.findAll();
    }

    @Override
    public Result update(Result result) {
        return iResultRepository.save(result);
    }
}
