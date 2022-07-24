package com.selenium.animals;

public class Duck extends Animals implements Flying {

    @Override
    public void say() {
        System.out.println("Я говорю КРЯ");
    }

    public void fly() { System.out.println("Я летаю"); }

}