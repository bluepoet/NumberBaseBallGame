package test.java.com.bluepoet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import main.java.com.bluepoet.Game;
import main.java.com.bluepoet.GameResult;
import main.java.com.bluepoet.NotValidNumberException;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	private Game game = new Game();

	@Before
	public void setUp() {
		game.setResult("123");
	}

	@Test(expected = NotValidNumberException.class)
	public void createGame_결과숫자넣지않았을때() throws NotValidNumberException {
		game.calculator(null);
	}

	@Test(expected = NotValidNumberException.class)
	public void createGame_빈공백문자입력() throws NotValidNumberException {
		game.calculator("   ");
	}

	@Test(expected = NotValidNumberException.class)
	public void createGame_입력자릿수가3자리가아닐때() throws NotValidNumberException {
		game.calculator("12");
	}

	@Test(expected = NotValidNumberException.class)
	public void createGame_입력문자가특수문자일때() throws NotValidNumberException {
		game.calculator("1#2");
	}

	@Test(expected = NotValidNumberException.class)
	public void createGame_중복숫자입력() throws NotValidNumberException {
		game.calculator("121");
	}

	@Test
	public void calculateResult_NoStrikeAndNoBall() throws NotValidNumberException {
		GameResult result = game.calculator("456");
		verifyResult(result, 0, 0);
	}

	@Test
	public void calculateResult_3StrikeAndNoBall() throws NotValidNumberException {
		GameResult result = game.calculator("123");
		verifyResult(result, 3, 0);
	}

	@Test
	public void calculateResult_NoStrikeAnd3Ball() throws NotValidNumberException {
		GameResult result = game.calculator("312");
		verifyResult(result, 0, 3);
	}

	@Test
	public void calculateResult_1StrikeAnd1Ball() throws NotValidNumberException {
		GameResult result = game.calculator("130");
		verifyResult(result, 1, 1);
	}
	
	@Test
	public void calculateResult_1StrikeAnd2Ball() throws NotValidNumberException {
		GameResult result = game.calculator("132");
		verifyResult(result, 1, 2);
	}

	private void verifyResult(GameResult result, int expectedStrike, int expectedBall) {
		assertThat(result.getStrike(), is(expectedStrike));
		assertThat(result.getBall(), is(expectedBall));
	}
}