package com.morientesdev.beprepare.service.impl;

import com.morientesdev.beprepare.exception.EntityNotFoundException;
import com.morientesdev.beprepare.model.City;
import com.morientesdev.beprepare.model.Province;
import com.morientesdev.beprepare.repository.CityRepository;
import com.morientesdev.beprepare.repository.ProvinceRepository;
import com.morientesdev.beprepare.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final CityRepository  cityRepository;
    private final ProvinceRepository provinceRepository;

    @Override
    public List<Province> getAllProvinces() {

        return provinceRepository.findAll();
    }

    @Override
    public List<City> getAllCities() {

        return cityRepository.findAll();
    }

    @Override
    public List<City> getAllCitiesProvinceId(Long provinceId) {

        return cityRepository.findAllByProvinceId(provinceId);
    }

    @Override
    public Province getProvinceById(Long provinceId) {

        return provinceRepository.findById(provinceId).orElseThrow(()->
                new EntityNotFoundException("A provincia não foi encontrada!"));
    }

    @Override
    public City getCityById(Long cityId) {

        return cityRepository.findById(cityId).orElseThrow(()->
                new EntityNotFoundException("O distrito  não foi encontrada!"));
    }
}
