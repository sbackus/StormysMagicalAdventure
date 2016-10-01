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

	Image background;
	Image background2;

	MainChar oldMan;
	Char npc1;
	Char npc2;

	Dialogue1 dialogue1;
	Dialogue2 dialogue2;

	int gamemode = 1;
	int scene = 1;

	ArrayList<Char> characters;

	public SimpleSlickGame(String gamename) {
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {

		background = new Image("images/background.jpg");
		npc1 = new Char(new Image("images/character1.jpg"), 200, 200);
		oldMan = new MainChar(new Image("images/oldman.jpg"));
		dialogue1 = new Dialogue1(new Image("images/textbox.png"), 50, 600);

		background2 = new Image("images/Background2.jpg");
		npc2 = new Char(new Image("images/shark.gif"), 400, 400);
		dialogue2 = new Dialogue2(new Image("images/textbox.png"), 50, 600);

		characters = new ArrayList<Char>();
		characters.add(npc1);
		characters.add(npc2);

	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {

		if (gamemode == 1) {
			oldMan.update(gc, i, characters, this);
		} else if (gamemode == 2) {
			if (scene == 1) {
				dialogue1.update(gc, i, this);
			}
			if (scene == 2)  {
				dialogue2.update(gc, i, this);
			}
		}

	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {

		// shark.draw(250, 300);
		if (scene == 1) {
			background.draw(0, 0, 1000, 800);
			npc1.render(gc, g);
			oldMan.render(gc, g);
			if (gamemode == 2) {
				dialogue1.render(gc, g);
			}

		} else if (scene == 2) {
			background2.draw(0, 0, 1000, 800);
			oldMan.render(gc, g);
			npc2.render(gc, g);
			if (gamemode == 2) {
				dialogue2.render(gc, g);
			}

		}

	}

	public void toggleGamemode() {
		if (gamemode == 1)
			gamemode = 2;
		else
			gamemode = 1;
	}

	public void nextScene() {
		scene++;
	}

	public int getScene() {
		return scene;
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