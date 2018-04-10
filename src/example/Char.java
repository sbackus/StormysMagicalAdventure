package example;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Char {

	int x, y;
	
	Image character;

	public Char(Image image, int _x, int _y) {
		character = image;
		x = _x;
		y = _y;
	}

	public void init(GameContainer gc) throws SlickException {
		
	}

	public void update(GameContainer gc, int i) throws SlickException {
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		character.draw(x, y, 4f);
	}

	public Vector2f getVector()
	{
		return new Vector2f(x,y);
	}
}
