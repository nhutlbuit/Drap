package dao;

import java.util.List;

import model.Address;

public interface AddressDao {
	
	public void create(Address address);

	public Address getAddress(Integer id);

	public List<Address> listAddress();
	
	public void delete(Integer id);

	public void update(Address address);
}
