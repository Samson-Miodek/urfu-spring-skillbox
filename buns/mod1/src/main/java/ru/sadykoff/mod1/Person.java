package ru.sadykoff.mod1;

public class Person {
    private final Pet pet;
    private String name;
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
