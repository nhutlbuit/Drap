package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.AddressDao;
import dao.ScoreDao;
import model.Address;
import model.Score;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	@Qualifier("addressDao")
	private AddressDao dao;

	@Override
	public Address findById(int id) {
		// TODO Auto-generated method stub
		return dao.getAddress(id);
	}

	@Override
	public void saveAddress(Address address) {
		// TODO Auto-generated method stub
		dao.create(address);
	}

	@Override
	public void updateAddress(Address address) {
		dao.update(address);
	}

	@Override
	public void deleteAddressById(int id) {
		dao.delete(id);
	}

	@Override
	public List<Address> findAllAddress() {
		return dao.listAddress();
	}
	
}
