package com.cybertek;
import com.github.javafaker.Faker;
public class Anythig {
    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println(faker.funnyName().name());
    }
}
