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

	boolean riddleCond = false;
	boolean endCond = false;
	boolean nextScene = false;
	ArrayList<String> dialogues;

	Image dialogueBackground;

	public Dialogue(ArrayList<String> _dialogues) throws SlickException {
		dialogueBackground = new Image("images/textbox.png");
		x = 50;
		y = 600;

		dialogues = _dialogues;
	}

	public void init(GameContainer gc) throws SlickException {

	}

	public void update(GameContainer gc, int i, SimpleSlickGame game) throws SlickException {
		Input input = gc.getInput();

		if (target == dialogues.size() - 3) {
			riddleCond = true;
		}
		if (input.isKeyPressed(Input.KEY_1) && riddleCond == true) {
			target = dialogues.size() - 2;
			riddleCond = false;
			endCond = true;
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
		dialogueBackground.draw(x, y, 900, 175);

		if (target < dialogues.size()) {
			g.drawString(dialogues.get(target), 75, 625);
		}
	}
	
}
