package com.digitaladd.service.addressservice;

import java.util.List;

import com.digitaladd.model.CityMO;
import com.digitaladd.model.CountryMO;
import com.digitaladd.model.StateMO;

public interface AddressService {
	public List<CountryMO> getCountreies();
	public List<StateMO> getAllStates(String countryCode);
	public List<CityMO> getAllCities(String stateCode);
}
