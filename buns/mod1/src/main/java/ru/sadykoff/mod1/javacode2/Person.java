package ru.sadykoff.mod1.javacode2;


import org.springframework.beans.factory.annotation.Value;

public class Person {

    private final Pet pet;
    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private int age;

    public Person(Pet pet) {
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
