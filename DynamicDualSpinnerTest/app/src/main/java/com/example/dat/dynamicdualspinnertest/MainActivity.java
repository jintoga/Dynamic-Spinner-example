package com.example.dat.dynamicdualspinnertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner1, spinner2;
    ArrayList<Country> listOfCountries = new ArrayList<>();
    ArrayAdapter<Country> countryArrayAdapter = null;
    ArrayList<City> listOfCities = new ArrayList<>();
    ArrayList<City> listOfCities2 = new ArrayList<>();
    ArrayAdapter<City> cityArrayAdapter = null;
    ArrayList<City> listOfCitiesToShow = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getIDs();
        setEvents();
    }

    private void getIDs() {

        String[] cityNames = getResources().getStringArray(R.array.cities);
        for (int i = 0; i < cityNames.length; i++) {
            City city = new City();
            city.setCode(i + "");
            city.setName(cityNames[i]);
            listOfCities.add(city);
        }
        String[] cityNames2 = getResources().getStringArray(R.array.cities2);
        for (int i = 0; i < cityNames2.length; i++) {
            City city = new City();
            city.setCode(i + "");
            city.setName(cityNames2[i]);
            listOfCities2.add(city);
        }
        for (int i = 0; i < 18; i++) {
            Country country = new Country();
            country.setCode(i + "");
            country.setName("Country" + i);
            if (i == 0)
                country.setListOfCities(listOfCities);
            else
                country.setListOfCities(listOfCities2);
            listOfCountries.add(country);
        }
        spinner1 = (Spinner) findViewById(R.id.spinner);
        countryArrayAdapter = new ArrayAdapter<Country>(this, android.R.layout.simple_spinner_item, listOfCountries);
        countryArrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner1.setAdapter(countryArrayAdapter);

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        listOfCitiesToShow = new ArrayList<>(listOfCountries.get(0).getListOfCities());
        cityArrayAdapter = new ArrayAdapter<City>(this, android.R.layout.simple_spinner_item, listOfCitiesToShow);
        cityArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(cityArrayAdapter);

    }

    private void setEvents() {
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0) {
                    cityArrayAdapter.clear();
                    cityArrayAdapter.addAll(listOfCountries.get(position).getListOfCities());
                    spinner2.setSelection(0);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
