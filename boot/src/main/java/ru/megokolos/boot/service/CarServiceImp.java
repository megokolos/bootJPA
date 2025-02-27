package ru.megokolos.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.megokolos.boot.model.Car;
import ru.megokolos.boot.properties.CarProperties;
import ru.megokolos.boot.repositories.CarRepository;
import java.util.List;

@Service
public class CarServiceImp implements CarService{
    @Autowired
    private CarProperties carProperties;

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImp(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    @Override
    public List<Car> listCars(Integer numberOfCars) {
        if (numberOfCars == null || numberOfCars > carProperties.getMaxCar()) {
            numberOfCars=carProperties.getMaxCar();
        }
        return carRepository.findAll().stream().limit(numberOfCars).toList();
    }
}
