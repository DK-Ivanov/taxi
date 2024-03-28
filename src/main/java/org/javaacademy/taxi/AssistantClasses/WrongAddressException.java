package org.javaacademy.taxi.AssistantClasses;

public class WrongAddressException extends Exception{
    public WrongAddressException(String message) {
        super("Заказ не выполнен. Неизвестный адрес " + message);
    }
}
