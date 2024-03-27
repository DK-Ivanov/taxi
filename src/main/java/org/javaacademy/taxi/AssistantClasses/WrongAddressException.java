package org.javaacademy.taxi.AssistantClasses;

public class WrongAddressException extends Exception{
    public WrongAddressException() {
        super("Заказ не выполнен. Такого адреса не существует.");
    }
}
