package org.javaacademy.taxi;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.javaacademy.taxi.AssistantClasses.TimeOfDay;
import org.javaacademy.taxi.AssistantClasses.WrongAddressException;
import org.javaacademy.taxi.Taxi.TaxiCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;


@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {
    @Value("${Car.NIGHT_RATE}")
    double nightRate;
    @Value("${Car.DAY_RATE}")
    double dayRate;
    @Getter
    String carNumber;
    @Getter
    double earnedMoney = 0;
    @Autowired
    @Lazy
    TaxiCompany company;

    public Car(String carNumber) {
        this.carNumber = carNumber;
    }

    public void takeOrder(Passenger passenger, TimeOfDay time) throws WrongAddressException {
        switch (passenger.getAddress()) {
            case "Березовая роща" -> countMoney(10, time);
            case "Кандикюля" -> countMoney(4, time);
            case "Строитель" -> countMoney(12, time);
            default -> throw new WrongAddressException(passenger.getAddress());
        }
    }

    private void countMoney(int distance, TimeOfDay time) {
        double cash;
        if(time.getValue() == 1) {
            cash = distance * nightRate;
        } else {
            cash = distance * dayRate;
        }
        this.earnedMoney += cash/2;
        company.setEarnedMoney(company.getEarnedMoney() + cash/2);
    }
}
