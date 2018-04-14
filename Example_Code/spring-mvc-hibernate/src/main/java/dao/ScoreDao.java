package dao;

import java.util.List;

import model.Score;

public interface ScoreDao {
	
	public void create(Score score);

	public Score getScore(Integer id);

	public List<Score> listScore();
	
	public List<Score> listScoreByIdStudent(int id);

	public void delete(Integer id);

	public void update(Score score);
}
