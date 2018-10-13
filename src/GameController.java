import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GameController {
	Computer 	computer;
	int			length;
	boolean		win;
	boolean		debug;
	
	public GameController(int length, boolean debug) {
		this.computer 	= new Computer(length);
		this.length		= length;
		this.win		= false;
		this.debug		= debug;
	}
	
	public GameController(int length) {
		this(length, false);
	}
	
	public GameController() {
		this(4, false);
	}
	
	public void letsPlay() throws IOException {
		System.out.print(" ");
		if (!debug)
			for (int i = 0; i < length; i++)
				System.out.print("*");
		else
			Arrays.stream(computer.hiddenNumber).forEach(System.out::print);
		while (!win) {
			System.out.print("\n>");
			readAnswerAndPrintResult();
		}
		System.out.println("\n—ongratulations! You are win!");
	}
	
	private void readAnswerAndPrintResult() throws IOException {
		int bulls 	= 0;
		int cows 	= length;
		int length	= 0;
		BufferedReader 	input = 
				new BufferedReader(new InputStreamReader(System.in));
		String line = input.readLine();
		length = Math.min(this.length, line.length());
		for (int i = 0; i < length; i++) {
			if (line.charAt(i) == (char)(computer.hiddenNumber[i] + '0')) {
				bulls++;
				cows--;
			}
		}
		System.out.printf("bulls = %d, cows = %d", bulls, cows);
		if (bulls == this.length) {
			win = true;
		}
	}
}
