package example;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class MainChar {

	int x, y;

	Image character;

	public MainChar(Image image) {
		character = image;
	}

	public MainChar(Image image, int _x, int _y) {
		character = image;
		x = _x;
		y = _y;
	}

	public void init(GameContainer gc) throws SlickException {

	}

	public void update(GameContainer gc, int i, ArrayList<Char> character) throws SlickException {
		Input input = gc.getInput();

		for (int j = 0; j < character.size(); j++) {
			if (this.collide(character.get(j))) {
				x += 100;
				
			}
		}

		if (input.isKeyDown(Input.KEY_UP)) {
			y -= 1;
		} else if (input.isKeyDown(Input.KEY_DOWN)) {
			y += 1;
		} else if (input.isKeyDown(Input.KEY_LEFT)) {
			x -= 1;
		} else if (input.isKeyDown(Input.KEY_RIGHT)) {
			x += 1;
		}
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		character.draw(x, y, 60, 96);
	}

	public boolean collide(Char target) {
		return target.getVector().distance(new Vector2f(x, y)) <= 60;
	}

}
