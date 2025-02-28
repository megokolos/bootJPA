package ru.megokolos.boot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "loan")
@Data
public class LoanProperties {
    private int minimalIncome;
    private int minimumCarPrice;
    private  double percentFromIncome;
    private  double percentFromCarPrice;

    public int getMinimumCarPrice() {
        return minimumCarPrice;
    }

    public void setMinimumCarPrice(int minimumCarPrice) {
        this.minimumCarPrice = minimumCarPrice;
    }

    public int getMinimalIncome() {
        return minimalIncome;
    }

    public void setMinimalIncome(int minimalIncome) {
        this.minimalIncome = minimalIncome;
    }

    public double getPercentFromIncome() {
        return percentFromIncome;
    }

    public void setPercentFromIncome(double percentFromIncome) {
        this.percentFromIncome = percentFromIncome;
    }

    public double getPercentFromCarPrice() {
        return percentFromCarPrice;
    }

    public void setPercentFromCarPrice(double percentFromCarPrice) {
        this.percentFromCarPrice = percentFromCarPrice;
    }
}
