package ru.sadykoff.mod1;

import org.springframework.stereotype.Component;

@Component("superCat")
public class Cat implements Pet{

    @Override
    public void say() {
        System.out.println("Meow-Meow!");
    }
}
