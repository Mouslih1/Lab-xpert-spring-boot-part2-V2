package com.example.labxpert.Service.Impl;

import com.example.labxpert.Dtos.PlanificationDto;
import com.example.labxpert.Model.Planification;
import com.example.labxpert.Repository.IPlanificationRepository;
import com.example.labxpert.Service.IPlanificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class PlanificationServiceImpl implements IPlanificationService {

    private IPlanificationRepository iPlanificationRepository;


    @Override
    public PlanificationDto add(PlanificationDto planificationDto) {
        return null;//iPlanificationRepository.save(planification);
    }

    @Override
    public PlanificationDto update(PlanificationDto planificationDto) {
        return null;//iPlanificationRepository.save(planification);
    }

    @Override
    public void delete(Long id) {
        //iPlanificationRepository.deleteById(id);
    }

    @Override
    public List<PlanificationDto> getAll() {
        return null;//iPlanificationRepository.findAll();
    }

    @Override
    public PlanificationDto getById(Long id) {
        return null;//iPlanificationRepository.findById(id).orElse(null);
    }

    @Override
    public void validation(PlanificationDto planificationDto) {

    }
}
