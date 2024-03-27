package org.javaacademy.taxi;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.javaacademy.taxi.AssistantClasses.TimeOfDay;
import org.javaacademy.taxi.AssistantClasses.WrongAddressException;
import org.javaacademy.taxi.Taxi.TaxiCompany;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {
    final double NIGHT_RATE;
    final double DAY_RATE;
    @Getter
    String carNumber;
    @Getter
    double earnedMoney = 0;
    TaxiCompany company;

    public Car(double NIGHT_RATE, double DAY_RATE, String carNumber, TaxiCompany company) {
        this.NIGHT_RATE = NIGHT_RATE;
        this.DAY_RATE = DAY_RATE;
        this.carNumber = carNumber;
        this.company = company;

    }

    public void takeOrder(Passenger passenger, TimeOfDay time) throws WrongAddressException {
        switch (passenger.getAddress()) {
            case "Березовая роща" -> countMoney(10, time);
            case "Кандикюля" -> countMoney(4, time);
            case "Строитель" -> countMoney(12, time);
            default -> throw new WrongAddressException();
        }
    }

    private void countMoney(int distance, TimeOfDay time) {
        double cash;
        if(time.getValue() == 1) {
            cash = distance * NIGHT_RATE;
        } else {
            cash = distance * DAY_RATE;
        }
        this.earnedMoney += cash/2;
        company.setEarnedMoney(company.getEarnedMoney() + cash/2);
    }
}
