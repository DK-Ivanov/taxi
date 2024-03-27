package org.javaacademy.taxi.Taxi;

import org.javaacademy.taxi.Car;

import java.util.List;

public class Luna extends TaxiCompany{
    public Luna(String name, Car car1, Car car2, Car car3) {
        super(name, List.of(car1, car2, car3));
    }
}
