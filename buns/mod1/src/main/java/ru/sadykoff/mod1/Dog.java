package ru.sadykoff.mod1;

import org.springframework.stereotype.Component;

@Component("superDog")
public class Dog implements Pet{
    @Override
    public void say() {
        System.out.println("Wow-Wow!");
    }
}
