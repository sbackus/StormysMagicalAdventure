package example;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;

public class SimpleSlickGame extends BasicGame {
	Image shark;
	MainChar oldMan;
	Char npc1;
	Image background;
	
	ArrayList<Char> characters;

	public SimpleSlickGame(String gamename) {
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		shark = new Image("images/shark.gif");
		background = new Image("images/background.jpg");
		oldMan = new MainChar(new Image("images/oldman.jpg"));
		npc1 = new Char(new Image("images/character1.jpg"), 200, 200);
		
		characters = new ArrayList<Char>();
		characters.add(npc1);

	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		oldMan.update(gc, i, characters);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.drawString("Welcome to Stormy's Magical Adventure!", 150, 200);
		// shark.draw(250, 300);

		background.draw(0, 0, 1000, 800);
		oldMan.render(gc, g);
		npc1.render(gc, g);
	}

	public static void main(String[] args) {
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlickGame("Simple Slick Game"));
			appgc.setDisplayMode(1000, 800, false);
			appgc.start();
		} catch (SlickException ex) {
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}