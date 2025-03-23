package main.io;

import main.logic.House;

public class View {
    public void showHouses(House[] houses) {
        for (House house : houses) {
            System.out.println(house);
        }
    }

    public void menu() {
        System.out.println("Menu");
        System.out.println("1. Find houses by number of rooms");
        System.out.println("2. Find houses by floor in between");
        System.out.println("3. Find houses by square footage in ascending order");
        System.out.println("4. Save houses to file txt");
        System.out.println("5. Save houses to file binary");
        System.out.println("6. Load houses from file txt");
        System.out.println("7. Load houses from file binary");
        System.out.println("0. Exit");
    }
}


