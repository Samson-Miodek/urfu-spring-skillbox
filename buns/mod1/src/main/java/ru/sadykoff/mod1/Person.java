package ru.sadykoff.mod1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("superPerson")
public class Person {

    private final Pet pet;
    private String name;
    private int age;

    public Person(@Autowired @Qualifier("superDog") Pet pet) {
        this.pet = pet;
    }


    public void callPet(){
        System.out.println("Hello, my lovely Pet!");
        pet.say();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
