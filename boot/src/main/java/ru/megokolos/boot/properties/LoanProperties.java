package ru.megokolos.boot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "loan")
@Data
public class LoanProperties {
    private int minimalIncome;
    private int minimumCarPrice;
    private double percentFromIncome;
    private double percentFromCarPrice;
}
