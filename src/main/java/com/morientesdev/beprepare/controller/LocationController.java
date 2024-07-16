package com.morientesdev.beprepare.controller;

import com.morientesdev.beprepare.dto.response.CityResponseDto;
import com.morientesdev.beprepare.dto.response.ProvinceResponseDto;
import com.morientesdev.beprepare.mapper.Mapper;
import com.morientesdev.beprepare.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/locations")
public class LocationController {

    private final Mapper mapper;
    private final LocationService locationService;

    @GetMapping("/provinces")
    public ResponseEntity<List<ProvinceResponseDto>> getAllProvince(){
        return ResponseEntity.ok(mapper.mapProvinceListToResponseDtoList(
                locationService.getAllProvinces())
        );
    }

    @GetMapping("/province")
    public ResponseEntity<ProvinceResponseDto> getProvinceById(@RequestParam Long id){

        return ResponseEntity.ok(mapper.mapProvinceToResponseDto(
                locationService.getProvinceById(id)
        ));
    }

    @GetMapping("/cities")
    public ResponseEntity<List<CityResponseDto>> getAllCities(){
        return ResponseEntity.ok(mapper.mapCityListToResponseDtoList(
                locationService.getAllCities()
        ));
    }

    @GetMapping("/cities/{provinceId}")
    public ResponseEntity<List<CityResponseDto>>getCityById(@PathVariable Long provinceId){
        return ResponseEntity.ok(mapper.mapCityListToResponseDtoList(
                locationService.getAllCitiesProvinceId(provinceId)
        ));

    }

    @GetMapping("/city")
    public ResponseEntity<CityResponseDto> getCityByProvinceId(@RequestParam Long id){
        return ResponseEntity.ok(mapper.mapCityToResponseDto(
                locationService.getCityById(id)));
    }

}
