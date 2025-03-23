package main.service;

import main.logic.House;
import main.logic.HouseRepository;

import java.io.*;
import java.nio.file.Files;

public class HouseRepositoryBinaryImpl implements HouseRepository {
    @Override
    public void outputArray(House[] houses, File file){
        try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file.toPath()))){
            out.writeObject(houses);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void outputArray(House[] houses, String fileName) {
        File file = new File(fileName);
        outputArray(houses, file);
    }

    @Override
    public House[] readArray(File file){
        try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file.toPath()))){
            Object o = in.readObject();
            return (House[])o;
        } catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public House[] readArray(String fileName){
        File file = new File(fileName);
        return readArray(file);
    }
}
