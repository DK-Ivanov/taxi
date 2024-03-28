package org.javaacademy.taxi.Taxi;

import org.javaacademy.taxi.Car;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("bluz")
public class Bluz extends TaxiCompany {
    public Bluz(@Qualifier("car1") Car car1, @Qualifier("car2") Car car2) {
        super("Bluz", List.of(car1, car2));
    }
}
