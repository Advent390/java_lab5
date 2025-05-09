package main.controller;

import main.io.View;
import main.logic.House;
import main.service.HouseService;

import java.util.Scanner;

public class HouseController {
    private final HouseService service = new HouseService();
    private final View view = new View();
    private final Scanner scanner = new Scanner(System.in);
    private final View menu = new View();

    public void controller(House[] houses) {
        label:
        while (true){
            menu.menu();

            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu){
                case 1 -> {
                    System.out.print("Enter the number of rooms: ");
                    int rooms = scanner.nextInt();
                    view.showHouses(service.findHousesByNumberOfRooms(houses, rooms));
                }
                case 2 -> {
                    System.out.print("Enter the number of the first floor interval: ");
                    int firstFloor = scanner.nextInt();
                    System.out.print("Enter the number of the last floor interval: ");
                    int lastFloor = scanner.nextInt();
                    view.showHouses(service.findHousesByFloorInBetween(houses, firstFloor, lastFloor));
                }
                case 3 -> {
                    System.out.print("Enter the area of the house: ");
                    int area = scanner.nextInt();
                    view.showHouses(service.findHousesByArea(houses, area));
                }
                case 4 -> {
                    System.out.print("Save houses to file txt: ");
                    String file = scanner.nextLine();
                    service.outputArrayTxt(houses, file);
                }
                case 5 -> {
                    System.out.print("Save houses to file binary: ");
                    String file = scanner.nextLine();
                    service.outputArrayBin(houses, file);
                }
                case 6 -> {
                    System.out.print("load houses from file txt: ");
                    String fileName = scanner.nextLine();
                    service.readArrayTxt(fileName);
                }
                case 7 -> {
                    System.out.print("load houses from file binary: ");
                    String fileName = scanner.nextLine();
                    service.readArrayBin(fileName);
                }
                case 0 -> {
                    break label;
                }
                default -> System.out.println("Invalid menu");
            }
        }
    }
}
