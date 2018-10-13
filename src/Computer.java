import java.util.Random;

public class Computer {
	public int[] hiddenNumber;
	public Computer(int length) {
		this.hiddenNumber = getRandomNumber(length);
	}
	private int[] getRandomNumber(int length) {
		return new Random().ints(0, 9)
				.distinct()
				.limit(length).toArray();
	}
	public String getHiddenNumberToString() {
		String res = "";
		for (int i = 0; i < hiddenNumber.length; i++) {
			res += hiddenNumber[i];
		}
		return res;
	}
}
