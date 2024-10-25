package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list
     * @return
     */
    public int getCount() {
        return cities.size();
    }

    /**
     * this adds a city to the list
     * @param city
     *  city to be added
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * This checks if a given city is present inside the CityList
     * @param city
     *      This is the city that is being checked
     * @return
     *      Returns a boolean based on if the city is present or not
     */
    public boolean hasCity(City city) {
        return this.cities.contains(city);
    }

    /**
     * This removes a city if present, throws an error otherwise
     * @param city
     *      city to be removed
     */
    public void delete(City city){
        if(this.hasCity(city))
            this.cities.remove(city);
        else
            throw new IllegalArgumentException();
    }

    /**
     * this gets size of the list
     * @return
     */
    public int countCities() {
        return cities.size();
    }

}
