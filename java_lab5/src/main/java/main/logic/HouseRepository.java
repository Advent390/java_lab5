package main.logic;

import java.io.File;

public interface HouseRepository extends Repository<House> {
    void outputArray(House[] houses, File file);

    void outputArray(House[] houses, String fileName);

    House[] readArray(File file);

    House[] readArray(String fileName);
}
