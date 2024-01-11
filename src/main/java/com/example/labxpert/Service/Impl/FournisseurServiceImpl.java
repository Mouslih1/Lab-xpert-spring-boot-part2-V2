package com.example.labxpert.Service.Impl;

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
    public Fournisseur add(Fournisseur fournisseur)
    {
        return iFournisseurRepository.save(fournisseur);
    }

    @Override
    public Fournisseur update(Fournisseur fournisseur)
    {
        return iFournisseurRepository.save(fournisseur);
    }

    @Override
    public void delete(Long id)
    {
        iFournisseurRepository.deleteById(id);
    }

    @Override
    public List<Fournisseur> getAll()
    {
        return iFournisseurRepository.findAll();
    }

    @Override
    public Fournisseur getById(Long id)
    {
        return iFournisseurRepository.findById(id).orElse(null);
    }
}
