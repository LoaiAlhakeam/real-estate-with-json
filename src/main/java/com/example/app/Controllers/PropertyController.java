package com.example.app.Controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.example.app.Models.Property;
import com.example.app.Repositories.PropertyRepo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PropertyController {

    @Autowired
    PropertyRepo propertyRepo;
    ObjectMapper objectMapper = new ObjectMapper();
    File data = new File("./data.json");

    @RequestMapping(path = "/")
    public String indexpage() {
        return "index";
    }

    @RequestMapping(path = "/SellerPage")
    public String SellerPage() {
        return "SellerPage";
    }

    @RequestMapping(path = "/AddProperty")
    public String AddPropertyPage() {
        return "AddProperty";
    }

    @RequestMapping(path = "/BuyerPage")
    public String buyerPage() {
        return "BuyerPage";
    }

    @RequestMapping(path = "/ViewProperty")
    public String viewPropertyPage(Model model) {
        Property property = new Property();
        model.addAttribute("property", property);
        return "ViewProperty";
    }

    @RequestMapping(path = "/Search")
    public String searchPage(Model model) {
        Property property = new Property();
        model.addAttribute("property", property);
        return "Search";
    }

    @RequestMapping(path = "/addProperty/{name}/{price}/{bedRoomsNum}/{bathRoomsNum}/{homeType}/{parkingSpots}/{view}")
    public String addProperty(@PathVariable String name, @PathVariable Double price, @PathVariable int bedRoomsNum,
            @PathVariable int bathRoomsNum, @PathVariable String homeType, @PathVariable int parkingSpots,
            @PathVariable String view) throws IOException {
        propertyRepo.addProperty(name, price, bedRoomsNum, bathRoomsNum, homeType, parkingSpots, view);
        return "redirect:/getall";
    }

    @RequestMapping(path = "/getall")
    public String getAllProperties(Model model) throws JsonParseException, JsonMappingException, IOException {
        List<Property> property = propertyRepo.getAllProperties();
        model.addAttribute("Properties", property);
        return "ViewAllProperties";
    }

    @RequestMapping(path = "/getallS")
    public String getAllPropertiesSeller(Model model) throws JsonParseException, JsonMappingException, IOException {
        List<Property> property = propertyRepo.getAllProperties();
        model.addAttribute("Properties", property);
        return "ViewAllProperties S";
    }

    @RequestMapping(path = "/DeleteProperty")
    public String deletePropertyPage() {
        return "DeleteProperty";
    }

    @PostMapping(path = "/delete/{id}")
    public String deletePropertie(@PathVariable(name = "id") int id)
            throws JsonParseException, JsonMappingException, IOException {
        propertyRepo.deletePropertyById(id);
        return "redirect:/getall";
    }

    @RequestMapping(path = "/update/{id}")
    public String updatePropertyPage(@PathVariable int id, Model model)
            throws JsonParseException, JsonMappingException, IOException {
        List<Property> all = propertyRepo.getAllProperties();
        Property property = all.get(propertyRepo.findById(id));
        model.addAttribute("property", property);
        return "updateProperty";
    }

    @RequestMapping(path = "/update/{id}/{name}/{price}/{bedRoomsNum}/{bathRoomsNum}/{homeType}/{parkingSpots}/{view}")
    public String updatePropertie(@PathVariable int id, @PathVariable String name, @PathVariable Double price,
            @PathVariable int bedRoomsNum, @PathVariable int bathRoomsNum, @PathVariable String homeType,
            @PathVariable int parkingSpots, @PathVariable String view)
            throws JsonParseException, JsonMappingException, IOException {
        propertyRepo.updateProperty(id, name, price, bedRoomsNum, bathRoomsNum, homeType, parkingSpots, view);

        return "redirect:/getall";
    }

    @RequestMapping(path = "/findbyId/{id}")
    public String findById(@PathVariable int id, Model model)
            throws JsonParseException, JsonMappingException, IOException {
        List<Property> all = propertyRepo.getAllProperties();
        int index = propertyRepo.findById(id);
        String s = propertyRepo.chickIndex(index);
        if (s.equals("")) {
            Property property = all.get(index);
            model.addAttribute("property", property);
            s = "ViewProperty";
        }

        return s;
    }

    @RequestMapping(path = "/searchByID/{id}")
    public String searchByid(@PathVariable int id, Model model)
            throws JsonParseException, JsonMappingException, IOException {
        List<Property> all = propertyRepo.getAllProperties();
        List<Property> search = new ArrayList<>();
        int index = propertyRepo.findById(id);
        String s = propertyRepo.chickIndex(index);
        if (s.equals("")) {
            search.add(all.get(index));
            model.addAttribute("Properties", search);
            s = "Search";
        }

        return s;
    }

    @RequestMapping(path = "/searchByName/{name}")
    public String searchByName(@PathVariable String name, Model model)
            throws JsonParseException, JsonMappingException, IOException {
        List<Property> search = propertyRepo.searchByName(name);
        model.addAttribute("Properties", search);
        return "search";

    }

    @RequestMapping(path = "/searchByPrice/{price}")
    public String findByPrice(@PathVariable Double price, Model model)
            throws JsonParseException, JsonMappingException, IOException {
        List<Property> search = propertyRepo.searchByPrice(price);
        model.addAttribute("Properties", search);
        return "search";
    }

    @RequestMapping(path = "/searchByBathRoomsNum/{BathRoomsNum}")
    public String searchByBathRoomsNum(@PathVariable int BathRoomsNum, Model model)
            throws JsonParseException, JsonMappingException, IOException {
        List<Property> search = propertyRepo.searchByBathRoomsNum(BathRoomsNum);
        model.addAttribute("Properties", search);
        return "search";
    }

    @RequestMapping(path = "/searchByBedRoomsNum/{BedRoomsNum}")
    public String searchByBedRoomsNum(@PathVariable int BedRoomsNum, Model model)
            throws JsonParseException, JsonMappingException, IOException {
        List<Property> search = propertyRepo.searchByBedRoomsNum(BedRoomsNum);
        model.addAttribute("Properties", search);
        return "search";
    }

    @RequestMapping(path = "/searchByHomeType/{HomeType}")
    public String searchByHomeType(@PathVariable String HomeType, Model model)
            throws JsonParseException, JsonMappingException, IOException {
        List<Property> search = propertyRepo.searchByHomeType(HomeType);
        model.addAttribute("Properties", search);
        return "search";
    }

    @RequestMapping(path = "/searchByView/{View}")
    public String searchByView(@PathVariable String View, Model model)
            throws JsonParseException, JsonMappingException, IOException {
        List<Property> search = propertyRepo.searchByView(View);
        model.addAttribute("Properties", search);
        return "search";
    }

    @RequestMapping(path = "/searchByParkingSpots/{ParkingSpots}")
    public String searchByParkingSpots(@PathVariable int ParkingSpots, Model model)
            throws JsonParseException, JsonMappingException, IOException {
        List<Property> search = propertyRepo.searchByParkingSpots(ParkingSpots);
        model.addAttribute("Properties", search);
        return "search";
    }

}