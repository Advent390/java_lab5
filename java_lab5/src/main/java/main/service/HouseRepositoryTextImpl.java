package main.service;

import main.logic.HouseRepository;

import main.logic.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class HouseRepositoryTextImpl implements HouseRepository {
    @Override
    public void outputArray(House[] houses, File file){
        try(PrintWriter out = new PrintWriter(Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8))){
            if(houses != null){
                for(House house : houses){
                    out.println(house.getId() + ";" +
                            house.getArea() + ";" +
                            house.getFloor() + ";" +
                            house.getRooms() + ";");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void outputArray(House[] houses, String fileName){
        File file = new File(fileName);
        outputArray(houses, file);
    }

    public House[] readArray(File file){
        int size = 6;
        int count = 0;
        House[] houses = new House[size];
        try(BufferedReader in = Files.newBufferedReader(file.toPath(),StandardCharsets.UTF_8)){
            String line;
            while((line = in.readLine()) != null){
                String[] tokens = line.split(";");
                if (tokens.length != size){
                    houses[count] = new House(
                            Integer.parseInt(tokens[0]),
                            Integer.parseInt(tokens[1]),
                            Integer.parseInt(tokens[2]),
                            Integer.parseInt(tokens[3])
                    );
                }
                count++;
            }
            return houses;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public House[] readArray(String fileName){
        File file = new File(fileName);
        return readArray(file);
    }
}
