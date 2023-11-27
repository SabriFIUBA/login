package com.example.login.user.service.impl;

import com.example.login.user.domain.User;
import com.example.login.user.repository.UserRepository;
import com.example.login.user.service.UserService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    //    private OrdenPagoRepository ordenPagoRepository;
    //
    //    public OrdenPagoServiceImpl(OrdenPagoRepository ordenPagoRepository) { this.ordenPagoRepository = ordenPagoRepository; }

    private  UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    public User buscarPorName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User guardar(User user) {
        return userRepository.save(user);
    }

    public Optional<User> buscarPorId(Long id) { return userRepository.findById(id); }
}
