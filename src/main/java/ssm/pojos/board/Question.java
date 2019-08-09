package ssm.pojos.board;

public class Question {

	private int id;
	private int userId;
	private int proId;
	private String question;

	public Question() {

	}

	public Question(int id, int userId, int proId, String question) {
		super();
		this.id = id;
		this.userId = userId;
		this.proId = proId;
		this.question = question;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
