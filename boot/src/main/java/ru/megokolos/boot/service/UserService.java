package ru.megokolos.boot.service;



import ru.megokolos.boot.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    List<User> getUserByCarModelAndSeries(String model, int series);

    User getUserById(Long id);
}
