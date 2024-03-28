package org.javaacademy.taxi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaxiConfig {
    @Bean
    public Car car1() {
        return new Car("O001OO");
    }
    @Bean
    public Car car2() {
        return new Car("O002OO");
    }
    @Bean
    public Car car3() {
        return new Car("O003OO");
    }
}
