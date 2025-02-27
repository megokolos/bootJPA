package ru.megokolos.boot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.megokolos.boot.model.User;
import ru.megokolos.boot.repositories.UserRepository;

import java.util.List;

@Service
@Transactional (readOnly = true)
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void add(User user) {
        userRepository.save(user);
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }


    public List<User> getUserByCarModelAndSeries(String model, int series) {
        return userRepository.findAllByCar_ModelAndCar_Series(model, series);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

}
