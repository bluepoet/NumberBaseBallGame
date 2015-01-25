package main.java.com.bluepoet;

public class GameResult {
	private int strike;
	private int ball;

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public void addStrike() {
		this.strike++;
	}

	public void addBall() {
		this.ball++;
	}
}
