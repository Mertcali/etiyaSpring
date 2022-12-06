package com.etiya.ecommercedemo4.business.dtos.response.town;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddTownResponse {

    private int id;
    private String name;
    private String cityName;
}
