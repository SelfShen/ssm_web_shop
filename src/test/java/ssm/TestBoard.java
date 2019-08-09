package ssm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ssm.controller.board.BoardControl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "/spring-mybatis.xml")
public class TestBoard {

	@Autowired
	private BoardControl board;

	// @Test
	public void addQuestion() {
		String result = board.addQuestion(1, "�����Ʒ�ò��ð�");
		System.out.println(result);
	}

	// @Test
	public void addAnswer() {
		String result = board.addAnswer(1, 1, "�����Ʒ�ܺ�");
		System.out.println(result);
	}

	@Test
	public void queryQ() {
		String result = board.queryBoard(8);
		System.out.println(result);
	}
}
