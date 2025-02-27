package ru.megokolos.boot.service;


import ru.megokolos.boot.model.Car;

import java.util.List;

public interface CarService {
    List<Car> listCars(Integer numberOfCars);
}
