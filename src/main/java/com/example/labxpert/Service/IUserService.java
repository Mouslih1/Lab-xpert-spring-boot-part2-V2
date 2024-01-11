package com.example.labxpert.Service;

import com.example.labxpert.Model.User;

import java.util.List;

public interface IUserService {

    User add(User user);
    User update(User user);
    void delete(Long id);
    List<User> getAll();
    User getById(Long id);
}
