package ru.megokolos.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.megokolos.boot.model.Car;

@Repository
public interface CarRepository extends JpaRepository <Car, Long> {
}
