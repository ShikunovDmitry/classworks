package com.itacademy.aqa;

import org.junit.*;

public class AnimalTest {

    Animal animal;

    @AfterClass
    public static void afterrAll(){
        System.out.println("I'm running after all tests in class");
    }

    @BeforeClass
    public static void beforeAllInClass() {
        System.out.println(" Hello, I'm running before all methods in this class");
    }

    @Before
    public void testInit(){
        System.out.println("I'm running before each test method");
        Assert.assertNull("Animal should be null before test", animal);
    }
    @After
    public void tearDown(){
        System.out.println("I'm running after each test method in class");
        animal = null;
    }


    @Test
    public void testCat() {
        System.out.println("Cat test is running");
        animal = new Cat();

        Assert.assertEquals("Cat is not a cat", "Cat", animal.whoIam());

    }

    @Test
    public void testDog() {
        System.out.println("Dog test is running");
        animal = new Dog();

        Assert.assertEquals("Dog is not a dog", "Dog", animal.whoIam());
    }

    @Test
    public void testPig() {
        System.out.println("Pig test is running");
        animal = new Pig();

        Assert.assertEquals("I'm not a pig", "Pig", animal.whoIam());
    }

    @Test(expected = RuntimeException.class)
    public void testException(){
        throw new RuntimeException("Any exception");
    }

}
