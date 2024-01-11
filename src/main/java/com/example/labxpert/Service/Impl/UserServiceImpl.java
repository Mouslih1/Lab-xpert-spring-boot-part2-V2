package com.example.labxpert.Service.Impl;

import com.example.labxpert.Model.User;
import com.example.labxpert.Repository.IPersonRepository;
import com.example.labxpert.Repository.IUserRepository;
import com.example.labxpert.Service.IUserService;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private IUserRepository iUserRepository;


    @Override
    public User add(User user)
    {
        return iUserRepository.save(user);
    }

    @Override
    public User update(User user)
    {
        return iUserRepository.save(user);
    }

    @Override
    public void delete(Long id)
    {
        iUserRepository.deleteById(id);
    }

    @Override
    public List<User> getAll()
    {
        return iUserRepository.findAll();
    }

    @Override
    public User getById(Long id)
    {
        return iUserRepository.findById(id).orElse(null);
    }
}
