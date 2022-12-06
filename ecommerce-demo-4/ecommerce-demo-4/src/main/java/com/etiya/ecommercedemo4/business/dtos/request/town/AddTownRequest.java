package com.etiya.ecommercedemo4.business.dtos.request.town;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddTownRequest {

    private String name;
    private int cityId;
}
