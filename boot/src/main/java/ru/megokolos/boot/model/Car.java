package ru.megokolos.boot.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String model;
    @NonNull
    private int series;

    private int price;

    @ToString.Exclude
    @OneToOne(mappedBy = "car")
    private User user;

}
