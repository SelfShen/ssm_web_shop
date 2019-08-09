package ssm.dao;

import java.util.List;

import ssm.pojos.board.Answer;
import ssm.pojos.board.Question;

public interface BoardDao {

	public void addQuestion(Question question);

	public void addAnswer(Answer answer);

	public List<Question> queryQAAll();

	public List<Question> queryQAByProId(int proId);
}
