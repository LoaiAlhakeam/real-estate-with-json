package com.example.app.Models;

import java.util.Objects;

public class Property {
    int id;
    String name;
    Double price;
    int bedRoomsNum;
    int bathRoomsNum;
    String homeType;
    int parkingSpots;
    String view;

    public Property() {
    }

    public Property(int id, String name, Double price, int bedRoomsNum, int bathRoomsNum, String homeType,
            int parkingSpots, String view) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.bedRoomsNum = bedRoomsNum;
        this.bathRoomsNum = bathRoomsNum;
        this.homeType = homeType;
        this.parkingSpots = parkingSpots;
        this.view = view;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getBedRoomsNum() {
        return this.bedRoomsNum;
    }

    public void setBedRoomsNum(int bedRoomsNum) {
        this.bedRoomsNum = bedRoomsNum;
    }

    public int getBathRoomsNum() {
        return this.bathRoomsNum;
    }

    public void setBathRoomsNum(int bathRoomsNum) {
        this.bathRoomsNum = bathRoomsNum;
    }

    public String getHomeType() {
        return this.homeType;
    }

    public void setHomeType(String homeType) {
        this.homeType = homeType;
    }

    public int getParkingSpots() {
        return this.parkingSpots;
    }

    public void setParkingSpots(int parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public String getView() {
        return this.view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public Property id(int id) {
        setId(id);
        return this;
    }

    public Property name(String name) {
        setName(name);
        return this;
    }

    public Property price(Double price) {
        setPrice(price);
        return this;
    }

    public Property bedRoomsNum(int bedRoomsNum) {
        setBedRoomsNum(bedRoomsNum);
        return this;
    }

    public Property bathRoomsNum(int bathRoomsNum) {
        setBathRoomsNum(bathRoomsNum);
        return this;
    }

    public Property homeType(String homeType) {
        setHomeType(homeType);
        return this;
    }

    public Property parkingSpots(int parkingSpots) {
        setParkingSpots(parkingSpots);
        return this;
    }

    public Property view(String view) {
        setView(view);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Property)) {
            return false;
        }
        Property property = (Property) o;
        return Objects.equals(id, property.id) && Objects.equals(name, property.name)
                && Objects.equals(price, property.price) && Objects.equals(bedRoomsNum, property.bedRoomsNum)
                && Objects.equals(bathRoomsNum, property.bathRoomsNum) && Objects.equals(homeType, property.homeType)
                && Objects.equals(parkingSpots, property.parkingSpots) && Objects.equals(view, property.view);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, bedRoomsNum, bathRoomsNum, homeType, parkingSpots, view);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", price='" + getPrice() + "'"
                + ", bedRoomsNum='" + getBedRoomsNum() + "'" + ", bathRoomsNum='" + getBathRoomsNum() + "'"
                + ", homeType='" + getHomeType() + "'" + ", parkingSpots='" + getParkingSpots() + "'" + ", view='"
                + getView() + "'" + "}";
    }

}
