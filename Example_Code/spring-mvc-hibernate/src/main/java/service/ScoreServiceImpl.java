package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.ScoreDao;
import model.Score;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	@Qualifier("scoreDao")
	private ScoreDao dao;

	@Override
	public Score findById(int id) {
		// TODO Auto-generated method stub
		return dao.getScore(id);
	}

	@Override
	public void saveScore(Score score) {
		// TODO Auto-generated method stub
		dao.create(score);
	}

	@Override
	public void updateScore(Score score) {
		dao.update(score);
	}

	@Override
	public void deleteScoreById(int id) {
		dao.delete(id);
	}

	@Override
	public List<Score> findAllScores() {
		return dao.listScore();
	}

	@Override
	public List<Score> findAllScoresByIdStudent(int id) {
		return dao.listScoreByIdStudent(id);
	}

	@Override
	public double avgScoreByIdStudent(int id) {
		
		List<Score> scores = dao.listScoreByIdStudent(id);
		double sum = 0;
		for (int i = 0; i < scores.size();i++){
			sum += scores.get(i).getScore();
		}
		return (sum/scores.size());
	}	
}
