package com.isima.blablacampus.routes.service.impl;

import org.springframework.stereotype.Service;

import com.isima.blablacampus.routes.Address;
import com.isima.blablacampus.routes.service.AddressRepository;
import com.isima.blablacampus.routes.service.IAddressService;

@Service
public class AddressService implements IAddressService{
	
	private AddressRepository addressRepository;
	
	

	@Override
	public void saveAddress(Address address) {
		
		addressRepository.save(address);
		
	}

}
