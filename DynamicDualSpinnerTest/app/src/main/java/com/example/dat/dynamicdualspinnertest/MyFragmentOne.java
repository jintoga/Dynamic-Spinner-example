package com.example.dat.dynamicdualspinnertest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DAT on 20-Apr-16.
 */
public class MyFragmentOne extends Fragment {


    private EditText editText;
    private SeekBar seekBar;

    private Spinner spinnerCountry, spinnerCity;
    private ArrayAdapter<Country> countryArrayAdapter = null;

    private ArrayAdapter<City> cityArrayAdapter = null;

    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_one, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        setEvents();
    }

    @Override
    public void onStart() {
        super.onStart();
        loadCitiesFromInternet();
        loadDataFromInternet();
    }

    private void loadCitiesFromInternet() {
        List<Country> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Country country = new Country();
            country.setCode(i + "");
            if (i == 5) {
                country.setName("OLD COUNTRY");
            } else {
                country.setName("NEW Country #" + i);
            }
            data.add(country);
        }
        countryArrayAdapter.addAll(data);
        //user's country loaded from internet
        spinnerCountry.setSelection(5);
    }

    private void init() {

        editText = (EditText) view.findViewById(R.id.editText);
        seekBar = (SeekBar) view.findViewById(R.id.seekBar);

        spinnerCountry = (Spinner) view.findViewById(R.id.spinnerCountries);

        spinnerCountry = (Spinner) view.findViewById(R.id.spinnerCountries);
        countryArrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, new ArrayList<Country>());
        countryArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(countryArrayAdapter);

        spinnerCity = (Spinner) view.findViewById(R.id.spinnerCities);
        cityArrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, new ArrayList<City>());
        cityArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(cityArrayAdapter);

    }

    private List<City> getCitiesForSelectedCountry(@NonNull String country) {
        List<City> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            City city = new City();
            city.setCode(i + "");
            city.setName("City " + i + " of " + country);
            result.add(city);
        }
        return result;
    }

    private void loadDataFromInternet() {
        editText.setText("This text is added by Default");
        seekBar.setProgress(88);
    }

    private void setEvents() {
        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0) {
                    cityArrayAdapter.clear();
                    cityArrayAdapter.addAll(getCitiesForSelectedCountry(countryArrayAdapter.getItem(position).getName()));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
