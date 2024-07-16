package com.morientesdev.beprepare.mapper;

import com.morientesdev.beprepare.dto.response.CityResponseDto;
import com.morientesdev.beprepare.dto.response.ProvinceResponseDto;
import com.morientesdev.beprepare.model.City;
import com.morientesdev.beprepare.model.Province;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Mapper {

    private final ModelMapper modelMapper;

    public ProvinceResponseDto mapProvinceToResponseDto(Province province) {

        return modelMapper.map(province, ProvinceResponseDto.class);

    }
    public List<ProvinceResponseDto> mapProvinceListToResponseDtoList(List<Province> provinces) {
        return provinces.stream().map(this::mapProvinceToResponseDto)
                .collect(Collectors.toList());
    }

    public CityResponseDto mapCityToResponseDto(City city) {

        return modelMapper.map(city, CityResponseDto.class);
    }

    public List<CityResponseDto> mapCityListToResponseDtoList(List<City> cities) {
        return cities.stream().map(this::mapCityToResponseDto)
                .collect(Collectors.toList());
    }


}
