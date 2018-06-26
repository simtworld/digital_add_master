package com.digitaladd.service.addressservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitaladd.dao.address.AddressDAO;
import com.digitaladd.model.CityMO;
import com.digitaladd.model.CountryMO;
import com.digitaladd.model.StateMO;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressDAO addressDao;
	
	@Override
	public List<CountryMO> getCountreies() {
		return addressDao.getCountreies();
	}

	@Override
	public List<StateMO> getAllStates(String countryCode) {
		return addressDao.getAllStates(countryCode);
	}

	@Override
	public List<CityMO> getAllCities(String stateCode) {
		return addressDao.getAllCities(stateCode);
	}

}
