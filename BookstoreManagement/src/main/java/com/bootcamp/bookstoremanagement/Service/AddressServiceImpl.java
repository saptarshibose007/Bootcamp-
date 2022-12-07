package com.bootcamp.bookstoremanagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.bookstoremanagement.Entity.Address;
import com.bootcamp.bookstoremanagement.Repository.IAddressRepository;
import com.bootcamp.bookstoremanagement.exception.AddressNotFoundException;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
    private IAddressRepository addressRepository;
    @Override
    public Address addAddress(Address address){
        return addressRepository.save(address);
    }
    @Override
    public Address viewAddress(int id) {
        return addressRepository.findById(id).orElseThrow(()-> new AddressNotFoundException("This address is not present"));
    }
    @Override
    public Address editAddress(Address address){
        addressRepository.findById(address.getAddressId()).orElseThrow(()-> new AddressNotFoundException("This address is not present"));
        return addressRepository.save(address);
    }
    @Override
    public Address deleteAddress(int id){
        addressRepository.findById(id).orElseThrow(()-> new AddressNotFoundException("This address is not present"));
    	addressRepository.deleteById(id);
        return null;
    }
    @Override
    public List<Address> viewAllAddresses(){
        return addressRepository.findAll();
    }
}
