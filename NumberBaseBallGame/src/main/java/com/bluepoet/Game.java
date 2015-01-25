package main.java.com.bluepoet;

public class Game {
	private String result;

	public Game() {
	}

	public String getResult() {
		return result;
	}

	public void setResult(String number) {
		this.result = number;
	}

	public GameResult calculator(String number) throws NotValidNumberException {
		isValidNumber(number);

		GameResult gameResult = new GameResult();
		char[] resultChars = result.toCharArray();
		for (int i = 0; i < 3; i++) {
			char ch = number.charAt(i);

			if (ch == resultChars[i]) {
				gameResult.addStrike();
			}

			for (int j = 0; j < resultChars.length; j++) {
				if (j == i) {
					continue;
				} else {
					if (ch == resultChars[j]) {
						gameResult.addBall();
					}
				}
			}
		}

		return gameResult;
	}

	private void isValidNumber(String number) throws NotValidNumberException {
		if (number == null) {
			throw new NotValidNumberException("input number is null");
		}

		int numberLength = number.trim().length();
		if (numberLength != 3) {
			throw new NotValidNumberException("input number length is not 3");
		}

		char[] chars = new char[3];
		for (int i = 0; i < numberLength; i++) {
			char ch = number.charAt(i);
			if (ch < 48 || ch > 57) {
				throw new NotValidNumberException("input number is not number");
			}

			for (int j = 0; j < chars.length; j++) {
				char savedCh = chars[j];

				if (savedCh == ch) {
					throw new NotValidNumberException("input number is previous saved number");
				}
			}

			chars[i] = ch;
		}
	}
}
