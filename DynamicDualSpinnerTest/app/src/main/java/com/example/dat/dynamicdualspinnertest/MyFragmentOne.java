package com.example.dat.dynamicdualspinnertest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DAT on 20-Apr-16.
 */
public class MyFragmentOne
    extends BaseMvpFragment<MVPContract.View, MVPContract.UserActionsListener> {

    @Bind(R.id.editText)
    protected EditText editText;
    @Bind(R.id.seekBar)
    protected SeekBar seekBar;

    @Bind(R.id.spinnerCountries)
    protected Spinner spinnerCountry;

    @Bind(R.id.spinnerCities)
    protected Spinner spinnerCity;

    private ArrayAdapter<Country> countryArrayAdapter = null;

    private ArrayAdapter<City> cityArrayAdapter = null;

    private View view;

    private int savedCityPosition = -1;
    private boolean stateSaved = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_one, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public MVPContract.UserActionsListener createPresenter() {
        return new MVPPresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        setEvents();
        loadCitiesFromInternet();
        if (savedInstanceState != null) {
            savedCityPosition = savedInstanceState.getInt(KEY_SAVED_CITY_POS);
            stateSaved = true;
        }
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
        countryArrayAdapter.notifyDataSetChanged();
        //user's country loaded from internet
        //spinnerCountry.setSelection(5);
    }

    private void init() {

        countryArrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item,
            new ArrayList<Country>());
        countryArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(countryArrayAdapter);

        cityArrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item,
            new ArrayList<City>());
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

    private void setEvents() {
        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0) {
                    cityArrayAdapter.clear();
                    cityArrayAdapter.addAll(getCitiesForSelectedCountry(
                        countryArrayAdapter.getItem(position).getName()));
                    if (savedCityPosition >= 0 && stateSaved == true) {
                        spinnerCity.setSelection(savedCityPosition);
                        savedCityPosition = -1;
                        stateSaved = false;
                    } else {
                        spinnerCity.setSelection(0);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private final String KEY_SAVED_CITY_POS = "saved_pos";

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        savedCityPosition = spinnerCity.getSelectedItemPosition();
        outState.putInt(KEY_SAVED_CITY_POS, savedCityPosition);
    }
}
