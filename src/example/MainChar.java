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

	public void update(GameContainer gc, int i, ArrayList<Char> character, SimpleSlickGame game) throws SlickException {
		Input input = gc.getInput();

		if (this.collide(character.get(game.getScene()-1)) && input.isKeyPressed(Input.KEY_SPACE))
		{
			game.toggleGamemode();
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
		character.draw(x, y, 120, 192);
	}

	public boolean collide(Char target) {
		return target.getVector().distance(new Vector2f(x, y)) <= 150;
	}
	
	public void move()
	{
		x = 500;
		y = 400;
	}
	

}
