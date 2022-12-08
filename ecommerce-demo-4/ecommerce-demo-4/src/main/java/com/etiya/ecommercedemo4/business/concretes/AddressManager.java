package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IAddressService;
import com.etiya.ecommercedemo4.business.abstracts.IAddressTypeService;
import com.etiya.ecommercedemo4.business.abstracts.IStreetService;
import com.etiya.ecommercedemo4.business.abstracts.IUserService;
import com.etiya.ecommercedemo4.business.constants.Messages;
import com.etiya.ecommercedemo4.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemo4.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.entities.concretes.*;
import com.etiya.ecommercedemo4.repository.IAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressManager implements IAddressService {

    private IAddressRepository addressRepository;
    private IAddressTypeService addressTypeService;
    private IStreetService streetService;
    private IUserService userService;
    private ModelMapperService modelMapperService;

    public AddressManager(IAddressRepository addressRepository, IAddressTypeService addressTypeService,
                          IStreetService streetService, IUserService userService,ModelMapperService modelMapperService) {
        this.addressRepository = addressRepository;
        this.addressTypeService = addressTypeService;
        this.streetService = streetService;
        this.userService = userService;
        this.modelMapperService=modelMapperService;
    }

    @Override
    public List<Address> getAll() {
        return this.addressRepository.findAll();
    }

    @Override
    public Address getById(int id) {
        return this.addressRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Address> getByAddressType() {
        return this.addressRepository.findByAddressType();
    }

    @Override
    public AddAddressResponse add(AddAddressRequest addAddressRequest) {

        checkIfStreetExists(addAddressRequest.getStreetId());
        checkIfUserExists(addAddressRequest.getUserId());

        Address address = this.modelMapperService.getMappingStandard().map(addAddressRequest,Address.class);
        Address savedAddress = this.addressRepository.save(address);
        AddAddressResponse response = this.modelMapperService.getMappingStandard().map(savedAddress,AddAddressResponse.class);

        String districtName = getDistrictByStreetId(addAddressRequest.getStreetId()).getName();
        String townName = getTownByDistrictName(districtName).getName();
        String cityName = getCityByTownName(townName).getName();
        String countryName = getCountryByCityName(cityName).getName();

        response.setDistrictName(districtName);
        response.setTownName(townName);
        response.setCityName(cityName);
        response.setCountryName(countryName);

        response.setUser(this.userService.getById(savedAddress.getUser().getId()));
        response.setAddressType(this.addressTypeService.getById(savedAddress.getAddressType().getId()));
        response.setStreet(this.streetService.getById(savedAddress.getStreet().getId()));

        return response;

        //******MANUEL_MAPPING******

        /*
        Address address = new Address();
        address.setDescription(addAddressRequest.getDescription());
        address.setAddressType(this.addressTypeService.getById(addAddressRequest.getAddressTypeId()));
        address.setUser(this.userService.getById(addAddressRequest.getUserId()));
        address.setStreet(this.streetService.getById(addAddressRequest.getStreetId()));
        Address savedAddress = this.addressRepository.save(address);
        */

        //******MANUEL_MAPPING_RESPONSE******

        /*
        AddAddressResponse response = new AddAddressResponse();
        response.setId(savedAddress.getId());
        response.setDescription(savedAddress.getDescription());
        response.setUserName(savedAddress.getUser().getName());
        response.setAddressTypeName(savedAddress.getAddressType().getName());
        response.setStreetName(savedAddress.getStreet().getName());
         */

        //**********************ADDRESS SET ****************


    }


    private Country getCountryByCityName(String name) {
        return this.addressRepository.findCountryByCityName(name);
    }

    private City getCityByTownName(String name) {
        return this.addressRepository.findCityByTownName(name);
    }

    private Town getTownByDistrictName(String name) {
        return this.addressRepository.findTownByDistrictName(name);
    }

    private District getDistrictByStreetId(int id) {
        return this.addressRepository.findDistrictByStreetId(id);
    }

    private void checkIfStreetExists(int id){
        Street street = this.streetService.getById(id);
        if(street==null){
            throw new RuntimeException(Messages.Address.StreetDoesNotExist);
        }
    }

    private void checkIfUserExists(int id) {
        User user = this.userService.getById(id);
        if (user == null){
            throw new RuntimeException(Messages.User.UserDoesNotExist);
        }
    }
}
