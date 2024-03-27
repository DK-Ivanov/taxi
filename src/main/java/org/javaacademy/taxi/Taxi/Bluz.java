package org.javaacademy.taxi.Taxi;

import org.javaacademy.taxi.Car;

import java.util.List;

public class Bluz extends TaxiCompany{
    public Bluz(String name, Car car1, Car car2) {
        super(name, List.of(car1, car2));
    }
}
