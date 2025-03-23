package main.factory;

import main.logic.House;

public class HouseFactory {

    public static House[] createHouses() {
        return new House[] {
                new House(1, 100, 1, 2),
                new House(2, 200, 1, 3),
                new House(3, 300, 2, 4),
                new House(4, 200, 2, 3),
                new House(5, 100, 3, 2),
                new House(6, 300, 3, 4)
        };

    }
}
