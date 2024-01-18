package com.example.labxpert.Service;

import com.example.labxpert.Dtos.MaterialDto;
import com.example.labxpert.Dtos.PatientDto;
import com.example.labxpert.Dtos.UserDto;
import com.example.labxpert.Model.User;

import java.util.List;

public interface IUserService {

    UserDto add(UserDto userDto);
    UserDto update(UserDto userDto);
    void delete(Long id);
    List<UserDto> getAll();
    UserDto getById(Long id);
    UserDto getByName(String name);
    void validation(UserDto userDto);
}
