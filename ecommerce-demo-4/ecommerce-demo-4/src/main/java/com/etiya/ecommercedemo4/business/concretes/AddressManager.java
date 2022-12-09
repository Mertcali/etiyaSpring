package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IAddressService;
import com.etiya.ecommercedemo4.business.abstracts.IAddressTypeService;
import com.etiya.ecommercedemo4.business.abstracts.IStreetService;
import com.etiya.ecommercedemo4.business.abstracts.IUserService;
import com.etiya.ecommercedemo4.business.constants.Messages;
import com.etiya.ecommercedemo4.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo4.core.util.results.SuccessResult;
import com.etiya.ecommercedemo4.entities.concretes.*;
import com.etiya.ecommercedemo4.repository.IAddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AddressManager implements IAddressService {

    private IAddressRepository addressRepository;
    private IAddressTypeService addressTypeService;
    private IStreetService streetService;
    private IUserService userService;
    private ModelMapperService modelMapperService;


    @Override
    public DataResult<List<Address>> getAll() {
        List<Address> response = this.addressRepository.findAll();
        return new SuccessDataResult<List<Address>>(response, Messages.SuccessMessages.ListAll);
    }

    @Override
    public DataResult<Address> getById(int id) {
        Address response = this.addressRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Address>(response, Messages.SuccessMessages.ListById);
    }

    @Override
    public DataResult<List<Address>> getByAddressType() {
        List<Address> response = this.addressRepository.findByAddressType();
        return new SuccessDataResult<List<Address>>(response,"ADDRESSES_LISTED_BY_ADDRESSTYPE");

    }

    @Override
    public Result add(AddAddressRequest addAddressRequest) {

        checkIfStreetExists(addAddressRequest.getStreetId());
        checkIfUserExists(addAddressRequest.getUserId());

        Address address = this.modelMapperService.forRequest().map(addAddressRequest,Address.class);

        this.addressRepository.save(address);
        return new SuccessResult(Messages.SuccessMessages.Add);


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

        // ***** ADD_ADDRESS_RESPONSE_SET *****
        /*
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

         */

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
