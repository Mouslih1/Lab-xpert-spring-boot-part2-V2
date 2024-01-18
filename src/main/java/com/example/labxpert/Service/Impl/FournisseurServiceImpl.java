package com.example.labxpert.Service.Impl;

import com.example.labxpert.Dtos.FournisseurDto;
import com.example.labxpert.Model.Fournisseur;
import com.example.labxpert.Repository.IFournisseurRepository;
import com.example.labxpert.Service.IFournisseurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class FournisseurServiceImpl implements IFournisseurService {

    private IFournisseurRepository iFournisseurRepository;


    @Override
    public FournisseurDto add(FournisseurDto fournisseurDto)
    {
        return null;//iFournisseurRepository.save(fournisseur);
    }

    @Override
    public FournisseurDto update(FournisseurDto fournisseurDto)
    {
        return null;//iFournisseurRepository.save(fournisseur);
    }

    @Override
    public void delete(Long id)
    {
        iFournisseurRepository.deleteById(id);
    }

    @Override
    public List<FournisseurDto> getAll()
    {
        return null;//iFournisseurRepository.findAll();
    }

    @Override
    public FournisseurDto getById(Long id)
    {
        return null;//iFournisseurRepository.findById(id).orElse(null);
    }

    @Override
    public FournisseurDto getByName(String name) {
        return null;
    }

    @Override
    public void validation(FournisseurDto fournisseurDto) {

    }
}
