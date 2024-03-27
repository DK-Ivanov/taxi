package org.javaacademy.taxi.AssistantClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum TimeOfDay {
    NIGHT(1), DAY(2);
    @Getter
    int value;
}
