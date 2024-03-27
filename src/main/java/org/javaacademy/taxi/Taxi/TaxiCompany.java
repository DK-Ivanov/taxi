package org.javaacademy.taxi.Taxi;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.javaacademy.taxi.AssistantClasses.TimeOfDay;
import org.javaacademy.taxi.Car;
import org.javaacademy.taxi.Passenger;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class TaxiCompany {
    String name;
    @Getter
    @Setter
    double earnedMoney;
    List<Car> cars;
    int count = 0;

    public TaxiCompany(String name, List<Car> cars) {
        this.name = name;
        this.cars = new ArrayList<>(List.copyOf(cars));
    }

    public void takeOrder(Passenger passenger, TimeOfDay time) {
        try {
            cars.get(count).takeOrder(passenger, time);
        } catch (Exception e) {
            e.getMessage();
        }
        count++;
        if(count == cars.size()) {
            count = 0;
        }
    }

    public void takeStock() {
        System.out.printf("@s\nЗаработано: @s\n", this.name, this.earnedMoney);
        cars.stream().forEach(e -> System.out.printf("Водитель машины @s заработал: @s\n", e.getCarNumber(), e.getEarnedMoney() ));
    }

}

