package com.morientesdev.beprepare.service;

import com.morientesdev.beprepare.model.City;
import com.morientesdev.beprepare.model.Province;

import java.util.List;

public interface LocationService {

    Iterable<Province> getAllProvinces();

    List<City> getAllCities();

    List<City> getAllCitiesProvinceId(Long provinceId);

    Province getProvinceById(Long provinceId);

    City getCityById(Long cityId);
}
