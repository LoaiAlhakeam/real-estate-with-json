package com.example.app.Repositories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.app.Models.Property;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Repository;

@Repository
public class PropertyRepo {

    ObjectMapper objectMapper = new ObjectMapper();
    File data = new File("./data.json");

    public List<Property> getAllProperties() throws JsonParseException, JsonMappingException, IOException {
        List<Property> all = objectMapper.readValue(data,
                new com.fasterxml.jackson.core.type.TypeReference<List<Property>>() {
                });
        return all;
    }

    public Property addProperty(String name, Double price, int bedRoomsNum, int bathRoomsNum, String homeType,
            int parkingSpots, String view) throws JsonParseException, JsonMappingException, IOException {

        List<Property> all = getAllProperties();
        Property p = new Property();
        boolean propertyIsExist = false;
        int index = 0;

        if (all.isEmpty()) {
            p.setId(1);
        } else {
            p.setId(all.get(all.size() - 1).getId() + 1);
        }
        p.setName(name);
        p.setPrice(price);
        p.setBedRoomsNum(bedRoomsNum);
        p.setBathRoomsNum(bathRoomsNum);
        p.setHomeType(homeType);
        p.setParkingSpots(parkingSpots);
        p.setView(view);

        for (Property property : all) {
            if (property.getName().equals(p.getName()) && property.getBedRoomsNum() == p.getBedRoomsNum()
                    && property.getBathRoomsNum() == p.getBathRoomsNum()
                    && property.getHomeType().equals(p.getHomeType())
                    && property.getParkingSpots() == p.getParkingSpots() && property.getView().equals(p.getView())) {
                all.get(index).setPrice(p.getPrice());
                propertyIsExist = true;
                break;
            }
            index++;
        }

        if (!propertyIsExist) {
            all.add(p);
        }

        objectMapper.writeValue(data, all);

        return p;
    }

    public void updateProperty(int id, String name, Double price, int bedRoomsNum, int bathRoomsNum, String homeType,
            int parkingSpots, String view) throws JsonParseException, JsonMappingException, IOException {
        List<Property> all = getAllProperties();
        int index = findById(id);
        Property p = all.get(index);
        p.setName(name);
        p.setPrice(price);
        p.setBedRoomsNum(bedRoomsNum);
        p.setBathRoomsNum(bathRoomsNum);
        p.setHomeType(homeType);
        p.setParkingSpots(parkingSpots);
        p.setView(view);

        objectMapper.writeValue(data, all);

    }

    public List<Property> deletePropertyById(int id) throws JsonParseException, JsonMappingException, IOException {
        List<Property> all = getAllProperties();
        int index = findById(id);
        all.remove(index);
        objectMapper.writeValue(data, all);
        return all;
    }

    public int findById(int id) throws JsonParseException, JsonMappingException, IOException {
        List<Property> all = getAllProperties();
        int index = -1;

        for (Property property : all) {
            if (property.getId() == id) {
                index = all.indexOf(property);
            }
        }
        System.out.println(index);
        return index;
    }

    public List<Property> searchByName(String name) throws JsonParseException, JsonMappingException, IOException {
        List<Property> all = getAllProperties();
        List<Property> search = new ArrayList<>();

        for (Property property : all) {
            if (property.getName().equals(name)) {
                search.add(property);
            }
        }
        return search;
    }

    public List<Property> searchByPrice(double price) throws JsonParseException, JsonMappingException, IOException {
        List<Property> all = getAllProperties();
        List<Property> search = new ArrayList<>();

        for (Property property : all) {
            if (property.getPrice().equals(price)) {
                search.add(property);
            }
        }
        return search;
    }

    public List<Property> searchByBathRoomsNum(int BathRoomsNum)
            throws JsonParseException, JsonMappingException, IOException {
        List<Property> all = getAllProperties();
        List<Property> search = new ArrayList<>();

        for (Property property : all) {
            if (property.getBathRoomsNum() == BathRoomsNum) {
                search.add(property);
            }
        }
        return search;
    }

    public List<Property> searchByBedRoomsNum(int BedRoomsNum)
            throws JsonParseException, JsonMappingException, IOException {
        List<Property> all = getAllProperties();
        List<Property> search = new ArrayList<>();

        for (Property property : all) {
            if (property.getBedRoomsNum() == BedRoomsNum) {
                search.add(property);
            }
        }
        return search;
    }

    public List<Property> searchByHomeType(String HomeType)
            throws JsonParseException, JsonMappingException, IOException {
        List<Property> all = getAllProperties();
        List<Property> search = new ArrayList<>();

        for (Property property : all) {
            if (property.getHomeType().equals(HomeType)) {
                search.add(property);
            }
        }
        return search;
    }

    public List<Property> searchByParkingSpots(int ParkingSpots)
            throws JsonParseException, JsonMappingException, IOException {
        List<Property> all = getAllProperties();
        List<Property> search = new ArrayList<>();

        for (Property property : all) {
            if (property.getParkingSpots() == ParkingSpots) {
                search.add(property);
            }
        }
        return search;
    }

    public List<Property> searchByView(String View) throws JsonParseException, JsonMappingException, IOException {
        List<Property> all = getAllProperties();
        List<Property> search = new ArrayList<>();

        for (Property property : all) {
            if (property.getView().equals(View)) {
                search.add(property);
            }
        }
        return search;
    }

    public String chickIndex(int index) {
        if (index < 0) {
            return "badsearch";
        } else {
            return "";
        }
    }

}
