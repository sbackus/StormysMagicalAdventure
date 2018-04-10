package example;

import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class SimpleDialogue {

	int x, y;
	int currentLine = 0;

	boolean endCond = false;
	boolean nextScene = false;
	ArrayList<String> dialogues;

	Image dialogueBackground;

	public SimpleDialogue(ArrayList<String> _dialogues) throws SlickException {
		dialogueBackground = new Image("images/textbox.png");
		x = 50;
		y = 600;

		dialogues = _dialogues;
	}

	public void init(GameContainer gc) throws SlickException {

	}

	public void update(GameContainer gc, int i, SimpleSlickGame game) throws SlickException {
		Input input = gc.getInput();
		
		if (input.isKeyPressed(Input.KEY_SPACE) && currentLine < dialogues.size()) {
			currentLine++;
		}  if (currentLine == dialogues.size() || (currentLine == dialogues.size() - 1 && endCond == true)) {
			game.toggleGamemode();
			currentLine = 0;
			if (endCond == true)
			{
				game.nextScene();
			}
		}
	

	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		dialogueBackground.draw(x, y, 900, 175);

		if (currentLine < dialogues.size()) {
			g.drawString(dialogues.get(currentLine), 75, 625);
		}
	}
	
}
