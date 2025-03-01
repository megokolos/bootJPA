package ru.megokolos.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.megokolos.boot.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByCar_ModelAndCar_Series(String model, int series);

    List<User> findAllByCarModelAndCarSeries(String model, int series);
}
