import java.io.IOException;

public class BullsAndCowsApp {
	public static void main(String[] args) throws IOException {
		GameController 	game;
		int 			param = args.length;
		switch (param) {
		case 1:
			try {
				game = new GameController(Integer.parseInt(args[0]));
			} catch (Exception e) {
				System.out.println("Wrong parametr ¹1!");
				game = new GameController();
			} 
			break;
		case 2:
			try {
				game = new GameController(Integer.parseInt(args[0]), 
						Boolean.parseBoolean(args[1]));
			} catch (Exception e) {
				System.out.println("Wrong parametrs");
				game = new GameController();
			} 
			break;
		default:
			game = new GameController();
		}
		game.letsPlay();
	}
}
