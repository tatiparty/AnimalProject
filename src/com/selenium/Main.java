package com.selenium;

import com.selenium.animals.*;
import com.selenium.animals.birds.Duck;
import com.selenium.animals.birds.Flying;
import com.selenium.animals.pets.Cat;
import com.selenium.animals.pets.Dog;
import options.Options;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Animals> animals = new ArrayList<Animals>();

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Введите, какую команду из меню выполнить: add/list/exit");
            String choice = sc.next().toUpperCase().trim();

            String optionAdd = Options.ADD.getOpt();
            String optionList = Options.LIST.getOpt();
            String optionExit = Options.EXIT.getOpt();

            switch (choice){
                case "ADD":
                    while(true){
                        if (choice.matches(optionAdd)) {
                            System.out.println("Введите, какое животное добавить: кот/кошка/пёс/собака/утка. Или введите q для выхода из команды");
                            String animalType = sc.next();
                            if (animalType.matches("кот") || animalType.matches("кошка")) {
                                Animals unit = new Cat();
                                addAnimal(unit, sc);
                                animals.add(unit);
                                break;
                            } else if (animalType.matches("собака") || animalType.matches("пес") || animalType.matches("пёс")) {
                                Animals unit = new Dog();
                                addAnimal(unit, sc);
                                animals.add(unit);
                                break;
                            } else if (animalType.matches("утка")) {
                                Animals unit = new Duck();
                                addAnimal(unit, sc);
                                animals.add(unit);
                                Flying f = new Duck();
                                f.fly();
                                break;
                            } else if (animalType.matches("q")){
                                break;
                            } else {
                                System.out.println("Некорректный ввод");
                            }
                        }
                    }
                case "LIST":
                    if(choice.matches(optionAdd) || choice.matches(optionList)) {
                        if (animals.size() == 0) {
                            System.out.println("В список пока не было добавлено ни одного животного");
                        } else {
                            System.out.println("\n" + "Список добавленных животных:");
                            for (Animals animal : animals) {
                                System.out.println(animal);
                            }
                        }
                        break;
                    }
                case "EXIT":
                    if(choice.matches(optionExit)) {
                        System.out.println("Выход");
                        System.exit(0);
                    }
                default:
                    System.out.println("Некорректный ввод");
            }
        }
    }
    public static void createAnimal(Animals animal, Scanner scanner){

        System.out.println("Введите имя животного");
        animal.setName(scanner.next());

        while (true){
            try{
                System.out.println("Введите возраст животного (только цифры)");
                String enter = scanner.next();
                int i = Integer.parseInt(enter);
                animal.setAge(i);
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный формат! Повторите ввод:");
            }
        }

        while (true){
            try{
                System.out.println("Введите вес животного (только цифры)");
                String enter = scanner.next();
                int i = Integer.parseInt(enter);
                animal.setWeight(i);
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный формат! Повторите ввод:");
            }
        }

        System.out.println("Введите цвет животного");
        animal.setColor(scanner.next());
    }
    public static void addAnimal(Animals unit, Scanner sc){
        createAnimal(unit, sc);
        unit.say();
    }
}
