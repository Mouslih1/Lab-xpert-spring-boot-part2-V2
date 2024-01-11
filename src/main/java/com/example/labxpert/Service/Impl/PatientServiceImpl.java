package com.example.labxpert.Service.Impl;

import com.example.labxpert.Model.Patient;
import com.example.labxpert.Repository.IPatientRepository;
import com.example.labxpert.Repository.IPersonRepository;
import com.example.labxpert.Service.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PatientServiceImpl implements IPatientService {

    private IPatientRepository iPatientRepository;


    @Override
    public Patient add(Patient patient)
    {
        return iPatientRepository.save(patient);
    }

    @Override
    public Patient update(Patient patient)
    {
        return iPatientRepository.save(patient);
    }

    @Override
    public void delete(Long id)
    {
        iPatientRepository.deleteById(id);
    }

    @Override
    public List<Patient> getAll()
    {
        return iPatientRepository.findAll();
    }

    @Override
    public Patient getById(Long id) {
        return iPatientRepository.findById(id).orElse(null);
    }
}
