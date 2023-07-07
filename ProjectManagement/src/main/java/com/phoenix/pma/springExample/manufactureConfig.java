package com.phoenix.pma.springExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class manufactureConfig {

	@Bean
	public Cars newCar() {
		Engine e = new Engine();
		Doors d = new Doors();
		Tires t = new Tires();
		return new Cars(e, d, t);
	}

}
