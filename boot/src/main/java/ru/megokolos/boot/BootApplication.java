package ru.megokolos.boot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import ru.javamentor.config.IncomeClientAutoConfiguration;
import ru.megokolos.boot.properties.CarProperties;
import ru.megokolos.boot.properties.LoanProperties;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties({CarProperties.class, LoanProperties.class})
public class BootApplication {
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
