package main.logic;

import java.io.Serializable;

public class House implements Serializable {
    private int id;
    private int area;
    private int floor;
    private int rooms;

    public House(int id, int area, int floor, int rooms) {
        this.id = id;
        this.area = area;
        this.floor = floor;
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", area=" + area +
                ", floor=" + floor +
                ", rooms=" + rooms +
                '}';
    }
}
