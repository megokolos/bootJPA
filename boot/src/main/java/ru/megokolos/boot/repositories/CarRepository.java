package ru.megokolos.boot.repositories;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.megokolos.boot.model.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    default List<Car> findFirstN(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return findAll(pageable).getContent();
    }

    default List<Car> findFirstNSortedByField(int n, String field) {
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        Pageable pageable = PageRequest.of(0, n, sort);
        return findAll(pageable).getContent();
    }
}
