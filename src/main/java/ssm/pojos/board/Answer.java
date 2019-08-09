package ssm.pojos.board;

public class Answer {

	private int questionId;
	private int userId;
	private int proId;
	private String answer;

	public Answer() {

	}

	public Answer(int questionId, int userId, int proId, String answer) {
		super();
		this.questionId = questionId;
		this.userId = userId;
		this.proId = proId;
		this.answer = answer;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
