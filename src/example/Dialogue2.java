package example;

import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Dialogue2 {

	int x, y;
	int target = 0;

	boolean riddleCond = false;
	boolean endCond = false;
	ArrayList<String> dialogues;

	Image dialogue;

	public Dialogue2(Image image, int _x, int _y) {
		dialogue = image;
		x = _x;
		y = _y;

		dialogues = new ArrayList<String>();

		dialogues.add("This is new");
		dialogues.add("Oh shit whaddup");
		dialogues.add("Riddle: \n What is the thing for the thing \n1. Correct Answer\n2. option 2\n3. option 3\n4. option 4");
		dialogues.add("You are correct");
		dialogues.add("You are wrong");
	}

	public void init(GameContainer gc) throws SlickException {

	}

	public void update(GameContainer gc, int i, SimpleSlickGame game) throws SlickException {
		Input input = gc.getInput();

		System.out.println("debug");
		
		if (target == dialogues.size() - 3) {
			riddleCond = true;
		}
		if (input.isKeyPressed(Input.KEY_1) && riddleCond == true) {
			target = dialogues.size() - 2;
			riddleCond = false;
			endCond = true;
			game.nextScene();
		} else if (input.isKeyPressed(Input.KEY_2) && riddleCond == true) {
			target = dialogues.size() - 1;
			riddleCond = false;
		} else if (input.isKeyPressed(Input.KEY_3) && riddleCond == true) {
			target = dialogues.size() - 1;
			riddleCond = false;
		} else if (input.isKeyPressed(Input.KEY_4) && riddleCond == true) {
			target = dialogues.size() - 1;
			riddleCond = false;
		} else if (input.isKeyPressed(Input.KEY_SPACE) && target < dialogues.size() && riddleCond == false) {
			target++;
		} else if (target == dialogues.size() || (target == dialogues.size() - 1 && endCond == true)) {
			game.toggleGamemode();
			target = 0;
			if (endCond == true)
			{
				game.nextScene();
			}
		}

	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		dialogue.draw(x, y, 900, 175);

		if (target < dialogues.size()) {
			g.drawString(dialogues.get(target), 75, 625);
		}
	}
}
