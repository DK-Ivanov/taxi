package org.javaacademy.taxi.Taxi;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.javaacademy.taxi.Car;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("luna")
public class Luna extends TaxiCompany {
    public Luna(@Qualifier("car1") Car car1, @Qualifier("car2") Car car2, @Qualifier("car3") Car car3) {
        super("Luna", List.of(car1, car2, car3));
    }
}
