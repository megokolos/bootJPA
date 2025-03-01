package ru.megokolos.boot.properties;


import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;


@ConfigurationProperties(prefix = "car")
@Data
public class CarProperties {
    private int maxCar;
    private List<String> sortFields;
    @PostConstruct
    public void init() {
        System.out.println("✅ CarProperties loaded! maxCar = " + maxCar);
    }
}
