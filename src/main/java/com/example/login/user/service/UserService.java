package com.example.login.user.service;

import com.example.login.user.domain.User;

public interface UserService {

    User buscarPorName(String name);

    User guardar(User user);
}
