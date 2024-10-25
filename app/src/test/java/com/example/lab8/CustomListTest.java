package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

    /**
     *
     */
    void testHasCity(){
        CustomList cityList = MockCityList();
        //check the same object
        City calgary = new City("Calgary", "Alberta");
        cityList.add(calgary);
        assertTrue(cityList.hasCity(calgary));
        //check same city but different objects
        City edmonton = new City("Edmonton", "Alberta");
        assertTrue(cityList.hasCity(edmonton));
        //check if city not present
        City vancouver = new City("Vancouver", "British Columbia");
        assertFalse(cityList.hasCity(vancouver));
    }

}
