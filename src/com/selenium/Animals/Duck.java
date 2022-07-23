package com.selenium.Animals;

public class Duck extends Animals implements Flying {

    @Override
    public void say() {
        System.out.println("Я говорю КРЯ");
    }

    public void Fly(){
        System.out.println("Я лечу");
    }

}