package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomListTest {


    private CustomList list;

    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }

    void testHasCity(){
        CustomList cityList = MockCityList();
        //check the same object
        City calgary = new City("Calgary", "Alberta");
        cityList.add(calgary);
        assertTrue(cityList.hasCity(calgary));
        //check same city but different objects
        City edmonton = new City("Edmonton", "Alberta");
        cityList.add(edmonton);
        City edmonton0 = new City("Edmonton", "Alberta");
        assertTrue(cityList.hasCity(edmonton0));
        //check if city not present
        City vancouver = new City("Vancouver", "British Columbia");
        assertFalse(cityList.hasCity(vancouver));
    }

    @Test
    void testDelete(){
        CustomList cityList = MockCityList();
        assertEquals(0, cityList.getCount());
        // delete a city actually present
        City edmonton = new City("Edmonton", "Alberta");
        cityList.addCity(edmonton);
        assertEquals(1, cityList.getCount());
        cityList.delete(edmonton);
        assertEquals(0, cityList.getCount());
        assertFalse(cityList.hasCity(edmonton));
        // delete a city not present
        City calgary = new City("Calgary", "Alberta");
        assertThrows(IllegalArgumentException.class, ()->{cityList.delete(calgary);});
    }


    @Test
    void testCountCities() {
        CustomList cityList = MockCityList();
        //check size initially
        assertEquals(0, cityList.countCities());
        //add multiple cities and check size
        City calgary = new City("Calgary", "Alberta");
        City vancouver = new City("vancouver", "British Columbia");
        City toronto = new City("Toronto", "Ontario");
        City montreal = new City("Montreal", "Quebec");
        cityList.addCity(calgary);
        cityList.addCity(vancouver);
        cityList.addCity(toronto);
        cityList.addCity(montreal);
        assertEquals(4, cityList.countCities());
        //delete multiple cities and check after each removal
        cityList.delete(calgary);
        assertEquals(3, cityList.countCities());
        cityList.delete(vancouver);
        assertEquals(2, cityList.countCities());
    }
}
