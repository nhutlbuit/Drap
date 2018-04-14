package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import model.Score;

@Repository
public class ScoreDaoImpl implements ScoreDao {

	private SessionFactory sessionFactory;
	
	@Override
	public void create(Score score) {
		Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(score);
        tx.commit();
        session.close();
	}

	@Override
	public Score getScore(Integer id) {
		Session session = getSessionFactory().openSession();
		Score score = (Score) session.get(Score.class, id);
		session.close();
		return score;
	}

	@Override
	public List<Score> listScore() {
		Session session = getSessionFactory().openSession();
        List<Score> list = session.createQuery("from Score").list();
        session.close();
        return list;
	}

	@Override
	public void delete(Integer id) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Score score = (Score) session.get(Score.class, id);
		session.delete(score);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Score score) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(score);;
		tx.commit();
		session.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Score> listScoreByIdStudent(int id) {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("from Score where student_id= :code ");
		query.setParameter("code", id);
		query.list();
        List<Score> list = query.list();
        session.close();
        return list;
	}

	
	
}
