/**
 * 
 */
package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import model.Address;
import model.Score;

/**
 * @author Chicken
 *
 */
@Repository
public class AddressDaoImpl implements AddressDao {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(Address address) {
		Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(address);
        tx.commit();
        session.close();
	}

	/* (non-Javadoc)
	 * @see dao.AddressDao#getAddress(java.lang.Integer)
	 */
	@Override
	public Address getAddress(Integer id) {
		Session session = getSessionFactory().openSession();
		Address address = (Address) session.get(Address.class, id);
		session.close();
		return address;
	}

	/* (non-Javadoc)
	 * @see dao.AddressDao#listAddress()
	 */
	@Override
	public List<Address> listAddress() {
		Session session = getSessionFactory().openSession();
        List<Address> list = session.createQuery("from Address").list();
        session.close();
        return list;
	}

	/* (non-Javadoc)
	 * @see dao.AddressDao#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Address address = (Address) session.get(Address.class, id);
		session.delete(address);
		tx.commit();
		session.close();
	}

	/* (non-Javadoc)
	 * @see dao.AddressDao#update(model.Address)
	 */
	@Override
	public void update(Address address) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(address);;
		tx.commit();
		session.close();
	}

}
