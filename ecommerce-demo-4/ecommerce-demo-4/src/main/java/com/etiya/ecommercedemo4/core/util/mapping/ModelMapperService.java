package com.etiya.ecommercedemo4.core.util.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    ModelMapper getMappingStandard();

    ModelMapper getMappingStrict();
    ModelMapper getMappingLoose();


}
