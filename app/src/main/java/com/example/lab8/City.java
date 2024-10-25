package com.example.lab8;

public class City implements Comparable<City>{

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    /**
     * This compares the name of this city object with another city's name
     * @param city
     *      city object that is to be compared with
     * @return
     *      returns integer value to indicate which city's name comes before lexicographically
     */
    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName());
    }

    /**
     * This compares the City object with another object
     * @param o
     *      object to be compared to
     * @return
     *      returns a boolean based on if the given object is equal to the city
     */
    @Override
    public boolean equals(Object o){
        if(o == this)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        City city = (City) o;
        return this.city.equals(city.city) && this.province.equals(city.province);
    }
}
