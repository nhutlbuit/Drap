package model;

public class Score {
private int scoreId;
private  String subject;
private int score;

private Student student;

public int getScoreId() {
	return scoreId;
}

public void setScoreId(int scoreId) {
	this.scoreId = scoreId;
}

public String getSubject() {
	return subject;
}

public void setSubject(String subject) {
	this.subject = subject;
}

public int getScore() {
	return score;
}

public void setScore(int score) {
	this.score = score;
}

public Student getStudent() {
	return student;
}

public void setStudent(Student student) {
	this.student = student;
}

public Score(int scoreId, String subject, int score, Student student) {
	super();
	this.scoreId = scoreId;
	this.subject = subject;
	this.score = score;
	this.student = student;
}

@Override
public String toString() {
	return "Score [scoreId=" + scoreId + ", subject=" + subject + ", score=" + score + ", student=" + student + "]";
}



}
