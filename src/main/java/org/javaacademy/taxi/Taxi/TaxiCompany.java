package org.javaacademy.taxi.Taxi;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.javaacademy.taxi.AssistantClasses.TimeOfDay;
import org.javaacademy.taxi.Car;
import org.javaacademy.taxi.Passenger;
import org.springframework.stereotype.Component;

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
        //cars.stream().forEach(e -> e.setCompany(this));
    }

    public void takeOrder(Passenger passenger, TimeOfDay time) {
        try {
            cars.get(count).takeOrder(passenger, time);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        count++;
        if(count == cars.size()) {
            count = 0;
        }
    }

    @PreDestroy
    public void takeStock() {
        System.out.printf("%s\nЗаработано: %s \n", this.name, this.earnedMoney);
        cars.stream().forEach(e -> System.out.printf("Водитель машины %s заработал: %s\n", e.getCarNumber(), e.getEarnedMoney() ));
    }

}

