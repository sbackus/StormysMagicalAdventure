package example;

import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Dialogue {

	int x, y;
	int target = 0;
	int gamemode = 2;

	ArrayList<String> dialogues;

	Image dialogue;

	public Dialogue(Image image, int _x, int _y) {
		dialogue = image;
		x = _x;
		y = _y;

		dialogues = new ArrayList<String>();

		dialogues.add("Hello");
		dialogues.add("Good bye");
		dialogues.add("what's up \n its 2:30AM");

	}

	public void init(GameContainer gc) throws SlickException {

	}

	public void update(GameContainer gc, int i, SimpleSlickGame game) throws SlickException {
		Input input = gc.getInput();

		if (input.isKeyPressed(Input.KEY_SPACE) && target < dialogues.size() ) {
			target++;
		} else if (target == dialogues.size() ) {
			game.toggleGamemode();
			target = 0;
		}
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		dialogue.draw(x, y, 900, 175);
		if (target < dialogues.size()) {
			g.drawString(dialogues.get(target), 75, 625);
		}
	}

	public int getGamemode() {
		int temp = gamemode;
		gamemode = 2;
		return temp;
	}
}
