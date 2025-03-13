package com.itacademy.aqa;

import com.itacademy.aqa.junit5.Animal;
import com.itacademy.aqa.junit5.Cat;
import com.itacademy.aqa.junit5.Dog;
import com.itacademy.aqa.junit5.Pig;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
//https://junit.org/junit5/docs/current/user-guide/

public class AnimalTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("I'm running before all method");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("all cleanup");
    }

    @BeforeEach
    public void testInitialize() {
        System.out.println("Setup test");
    }

    @Test
    @DisplayName("Test case for checking dog class")
    @Tag("Regression")
    public void testDog() {
        System.out.println("run first test");
        Animal animal = new Dog();
        Assertions.assertEquals("Cat", animal.whoIam(), "Dag is not dog");
    }

    @Test
    @Tag("Smoke")
    public void testCat() {
        System.out.println("run second test");
        Cat cat = new Cat();
        Assertions.assertNotEquals("Dog", cat.whoIam(), "Cat is dog");
    }

    public static List<Object[]> params() {
        List<Object[]> params = new ArrayList<>();
        params.add(new Object[]{new Dog(), "Dog"});
        params.add(new Object[]{new Cat(), "Cat"});
        params.add(new Object[]{new Pig(), "Pig"});
        return params;
    }

    @ParameterizedTest
    @MethodSource("params")
    @Tags({@Tag("parametrized"), @Tag("Smoke")})
//    @Tag("parametrized")
//    @Tag("Smoke")
    public void testDataDriven(Animal animal, String name) {
        Assertions.assertEquals(name, animal.whoIam(), String.format("%s is not %s", name, animal.whoIam()));
    }

    @Test
    public void exceptionTest(){
        Exception exception = Assertions.assertThrows(NullPointerException.class,()->{
            new Cat().whoIam();
        });
        Assertions.assertEquals(exception.getMessage(),"Exception for Cat");

    }
}
