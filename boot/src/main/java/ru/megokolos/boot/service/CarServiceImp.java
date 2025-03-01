package ru.megokolos.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.megokolos.boot.model.Car;
import ru.megokolos.boot.properties.CarProperties;
import ru.megokolos.boot.repositories.CarRepository;


import java.util.List;

@Service
public class CarServiceImp implements CarService {

    private final CarProperties carProperties;
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImp(CarRepository carRepository, CarProperties carProperties) {
        this.carRepository = carRepository;
        this.carProperties = carProperties;
    }

    @Transactional
    @Override
    public List<Car> listCars(Integer numberOfCars, String field) {
        if (numberOfCars == null || numberOfCars > carProperties.getMaxCar()) {
            numberOfCars = carProperties.getMaxCar();
        }
        if (field == null) {
            return carRepository.findFirstN(numberOfCars);
        }
        if (!carProperties.getSortFields().contains(field)) {
            throw new RuntimeException("Invalid field: " + field);
        }
        return carRepository.findFirstNSortedByField(numberOfCars, field);
    }
}
