package ssm.controller.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import ssm.dao.BoardDao;
import ssm.pojos.board.Answer;
import ssm.pojos.board.Question;
import ssm.pojos.user.User;

@Controller
@RequestMapping("/ssm")
public class BoardControl {

	@Autowired
	private BoardDao boardDao;

	@Autowired
	private HttpSession session;

	@ResponseBody
	@RequestMapping(value = "/source/question", method = RequestMethod.POST)
	public String addQuestion(Integer proId, String question) {
		User user = (User) session.getServletContext().getAttribute("user");
		int userId = user.getID().intValue();
		Question quest = new Question(0, userId, proId, question);
		boardDao.addQuestion(quest);
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/source/answer", method = RequestMethod.POST)
	public String addAnswer(Integer questionId, Integer proId, String answer) {
		Integer userId = (Integer) session.getServletContext().getAttribute("user");
		Answer answ = new Answer(questionId, userId, proId, answer);
		boardDao.addAnswer(answ);
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/source/queryQA", method = RequestMethod.POST)
	public String queryAllBoards() {
		List<Question> questions = boardDao.queryQAAll();
		return JSON.toJSONString(questions);
	}

	@ResponseBody
	@RequestMapping(value = "/source/queryQAByProId", method = RequestMethod.POST)
	public String queryBoard(Integer proId) {
		List<Question> questions = boardDao.queryQAByProId(proId.intValue());
		return JSON.toJSONString(questions);
	}
}
