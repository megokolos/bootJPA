package ru.megokolos.boot.properties;


import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@ConfigurationProperties(prefix = "car")
@Data
public class CarProperties {
    private int maxCar;
    @PostConstruct
    public void init() {
        System.out.println("✅ CarProperties loaded! maxCar = " + maxCar);
    }
}
