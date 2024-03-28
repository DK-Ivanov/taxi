package org.javaacademy.taxi;

import org.javaacademy.taxi.AssistantClasses.TimeOfDay;
import org.javaacademy.taxi.Taxi.TaxiCompany;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Runner {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Runner.class, args);
		TaxiCompany luna = context.getBean(TaxiCompany.class);
		Passenger passenger1 = new Passenger("Кандикюля");
		Passenger passenger2 = new Passenger("Строитель");
		Passenger passenger3 = new Passenger("Березовая роща");
		Passenger passenger4 = new Passenger("Ломоносов");

		luna.takeOrder(passenger1, TimeOfDay.DAY);
		luna.takeOrder(passenger2, TimeOfDay.DAY);
		luna.takeOrder(passenger3, TimeOfDay.NIGHT);
		luna.takeOrder(passenger4, TimeOfDay.NIGHT);
	}
}