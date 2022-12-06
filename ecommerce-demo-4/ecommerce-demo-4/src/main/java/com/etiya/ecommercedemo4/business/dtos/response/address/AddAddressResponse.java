package com.etiya.ecommercedemo4.business.dtos.response.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddAddressResponse {

    private int id;
    private String description;
    private String addressTypeName;
    private String streetName;
    private String userName;
    private String countryName;
    private String cityName;
    private String townName;
    private String districtName;


}
