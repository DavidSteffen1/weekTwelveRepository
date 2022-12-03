import java.util.Random;

public class TestDemo {
	public int addPositive(int firstInt, int secondInt) {
		if (firstInt > 0 && secondInt > 0) {
			return firstInt + secondInt;
		}
		else throw new IllegalArgumentException("Both parameters must be positive!");
	}
	
	protected int randomNumberSquared() {
		int intToSquare = getRandomInt();
		return intToSquare * intToSquare;
	}

	protected int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;		
	}
}
