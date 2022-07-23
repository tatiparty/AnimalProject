package com.selenium;

import com.selenium.Animals.*;
import Options.Options;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Animals> animals = new ArrayList<Animals>();

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Введите, какую команду из меню выполнить: add/list/exit");
            String choice = sc.next().toUpperCase().trim();

            String option1 = Options.ADD.getOpt();
            String option2 = Options.LIST.getOpt();
            String option3 = Options.EXIT.getOpt();

            boolean a = false;

            switch (choice){
                case "ADD":
                    while(a = true){
                        if (choice.matches(option1)) {
                            System.out.println("Введите, какое животное добавить: кот/кошка/пёс/собака/утка. Или введите q для выхода из команды");
                            String animalType = sc.next();
                            if (animalType.matches("кот") || animalType.matches("кошка")) {
                                Animals unit = new Cat();
                                AddAnimal(unit, sc);
                                animals.add(unit);
                                break;
                            } else if (animalType.matches("собака") || animalType.matches("пес") || animalType.matches("пёс")) {
                                Animals unit = new Dog();
                                AddAnimal(unit, sc);
                                animals.add(unit);
                                break;
                            } else if (animalType.matches("утка")) {
                                Animals unit = new Duck();
                                AddAnimal(unit, sc);
                                animals.add(unit);
                                Flying f = new Duck();
                                f.Fly();
                                break;
                            } else if (animalType.matches("q")){
                                break;
                            } else {
                                System.out.println("Некорректный ввод");
                                a = true;
                            }
                        }
                    }
                case "LIST":
                    if(choice.matches(option1) || choice.matches(option2)) {
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
                    if(choice.matches(option3)) {
                        System.out.println("Выход");
                        System.exit(0);
                    }
                default:
                    System.out.println("Некорректный ввод");
            }
        }
    }
    public static void CreateAnimal(Animals animal, Scanner scanner){

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
    public static void AddAnimal(Animals unit, Scanner sc){
        CreateAnimal(unit, sc);
        unit.say();
    }
}
