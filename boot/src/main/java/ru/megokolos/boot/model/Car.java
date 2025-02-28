package ru.megokolos.boot.model;

import jakarta.persistence.*;
import lombok.*;



@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", series=" + series +
                ", model='" + model + '\'' +
                ", id=" + id +
                '}';
    }
}
