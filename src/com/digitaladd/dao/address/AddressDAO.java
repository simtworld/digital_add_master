package com.digitaladd.dao.address;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.digitaladd.model.CityMO;
import com.digitaladd.model.CountryMO;
import com.digitaladd.model.StateMO;

@Repository
public interface AddressDAO {
	public List<CountryMO> getCountreies();
	public List<StateMO> getAllStates(String countryCode);
	public List<CityMO> getAllCities(String stateCode);
}
