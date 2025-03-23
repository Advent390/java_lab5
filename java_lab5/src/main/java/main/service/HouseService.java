package main.service;

import main.logic.House;
import main.logic.HouseRepository;

import java.util.Arrays;

public class HouseService {
    private final HouseRepository repository = new HouseRepositoryTextImpl();
    private final HouseRepository repository1 = new HouseRepositoryBinaryImpl();

    public void outputArrayTxt(House[] houses, String fileName) {
        repository.outputArray(houses, fileName);
    }

    public void outputArrayBin(House[] houses, String fileName) {
        repository1.outputArray(houses, fileName);
    }

    public House[] readArrayTxt(String fileName) {
        return repository.readArray(fileName);
    }

    public House[] readArrayBin(String fileName) {
        return repository1.readArray(fileName);
    }

    public House[] findHousesByNumberOfRooms(House[] houses, int numberOfRooms) {
        House[] housesFound = new House[houses.length];
        int count = 0;
        for (House house : houses) {
            if (house.getRooms() == numberOfRooms) {
                housesFound[count] = house;
                count++;
            }
        }
        return Arrays.copyOf(housesFound, count);
    }

    public House[] findHousesByFloorInBetween(House[] houses, int floorFrom, int floorTo) {
        House[] housesFound = new House[houses.length];
        int count = 0;
        for (House house : houses) {
            if (house.getFloor() >= floorFrom && house.getFloor() <= floorTo) {
                housesFound[count] = house;
                count++;
            }
        }
        return Arrays.copyOf(housesFound, count);
    }

    public House[] findHousesByArea(House[] houses, int area) {
        House[] housesFound = new House[houses.length];
        int count = 0;
        for (House house : houses) {
            if (house.getArea() >= area) {
                housesFound[count] = house;
                count++;
            }
        }
        return Arrays.copyOf(housesFound, count);
    }
}
