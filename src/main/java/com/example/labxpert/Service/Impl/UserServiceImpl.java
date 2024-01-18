package com.example.labxpert.Service.Impl;

import com.example.labxpert.Dtos.PatientDto;
import com.example.labxpert.Dtos.UserDto;
import com.example.labxpert.Model.User;
import com.example.labxpert.Repository.IUserRepository;
import com.example.labxpert.Service.IUserService;
//import com.sun.xml.internal.ws.developer.Serialization;
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
    public UserDto add(UserDto userDto)
    {
        return null;//iUserRepository.save(userDto);
    }

    @Override
    public UserDto  update(UserDto userDto)
    {
        return null;//iUserRepository.save(user);
    }

    @Override
    public void delete(Long id)
    {
        //iUserRepository.deleteById(id);
    }

    @Override
    public List<UserDto> getAll()
    {
        return null;//iUserRepository.findAll();
    }

    @Override
    public UserDto getById(Long id)
    {
        return null;//iUserRepository.findById(id).orElse(null);
    }

    @Override
    public UserDto getByName(String name) {
        return null;
    }

    @Override
    public void validation(UserDto userDto) {

    }
}
