package example;

import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Dialogue {

	int x, y;
	int currentLine = 0;
	int track = 1;

	boolean endCond = false;
	boolean nextScene = false;

	boolean correctAnswer = true;

	ArrayList<String> dialogues;
	ArrayList<String> correct;
	ArrayList<String> wrong;
	int rightAnswer;

	CharAnimation mainCharAnimation;

	Image dialogueBackground;

	public Dialogue(ArrayList<String> _dialogues, int _rightAnswer, ArrayList<String> _correct,
			ArrayList<String> _wrong) throws SlickException {
		dialogueBackground = new Image("images/textbox.png");
		x = 50;
		y = 600;

		mainCharAnimation = new CharAnimation(new Image[] { new Image("images/Stormy1.png"),
				new Image("images/Stormy2.png"), new Image("images/Stormy3.png") }, 50, 20);
		rightAnswer = _rightAnswer;
		dialogues = _dialogues;
		correct = _correct;
		wrong = _wrong;
	}

	public Dialogue(ArrayList<String> _dialogues) throws SlickException {
		dialogueBackground = new Image("images/textbox.png");
		x = 50;
		y = 600;

		mainCharAnimation = new CharAnimation(new Image[] { new Image("images/Stormy1.png"),
				new Image("images/Stormy2.png"), new Image("images/Stormy3.png") }, 50, 20);

		dialogues = _dialogues;
	}

	public void init(GameContainer gc) throws SlickException {

	}

	public void update(GameContainer gc, int i, SimpleSlickGame game) throws SlickException {
		Input input = gc.getInput();

		mainCharAnimation.update(i);

		System.out.println(game.getScene());

		if (dialogues.get(currentLine).contains("Riddle:")) {
			if (input.isKeyPressed(Input.KEY_1)) {
				if (rightAnswer == 1) {
					track = 2;
					currentLine = 0;
				} else {
					track = 3;
					currentLine = 0;
				}
			} else if (input.isKeyPressed(Input.KEY_2)) {
				if (rightAnswer == 2) {
					track = 2;
					currentLine = 0;
				} else {
					track = 3;
					currentLine = 0;
				}
			} else if (input.isKeyPressed(Input.KEY_3)) {
				if (rightAnswer == 3) {
					track = 2;
					currentLine = 0;
				} else {
					track = 3;
					currentLine = 0;
				}
			} else if (input.isKeyPressed(Input.KEY_4)) {
				if (rightAnswer == 4) {
					track = 2;
					currentLine = 0;
				} else {
					track = 3;
					currentLine = 0;
				}
			}

		} else if (input.isKeyPressed(Input.KEY_SPACE) && !dialogues.get(currentLine).contains("Riddle:")) {
			currentLine++;
		}
		if (track == 1) {
			if (currentLine == dialogues.size()) {
				game.toggleGamemode();
				currentLine = 0;
				if (correct == null || wrong == null)
					game.nextScene();
			}
		} else if (track == 2) {
			if (currentLine == correct.size()) {
				game.toggleGamemode();
				currentLine = 0;
				game.nextScene();
			}
		} else if (track == 3) {
			if (currentLine == wrong.size()) {
				track = 1;
				game.toggleGamemode();
				currentLine = 0;
			}
		}
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {

		String line = "";
		if (track == 1) {
			if (currentLine < dialogues.size()) {
				line = dialogues.get(currentLine);
				if (line.contains("Javaris:")) {
					javarisAnimation.draw();
				}
				if (line.contains("Annie:")) {
					annieSad.draw();
				}
				if (line.contains("Leopold:")) {
					leoSad.draw();
				}
				if (line.contains("Juniper:")) {
					juniperSad.draw();
				}
				if (line.contains("Christian:")) {
					christianSad.draw();
				}
				if (line.contains("Julian:")) {
					julianSad.draw();
				}

			}
		} else if (track == 2) {
			if (currentLine < correct.size()) {
				line = correct.get(currentLine);
				if (line.contains("Javaris:")) {
					javarisAnimation.draw();
				}
				if (line.contains("Annie:")) {
					annieHappy.draw();
				}
				if (line.contains("Leopold:")) {
					leoHappy.draw();
				}
				if (line.contains("Juniper:")) {
					juniperHappy.draw();
				}
				if (line.contains("Christian:")) {
					christianHappy.draw();
				}
				if (line.contains("Julian:")) {
					julianHappy.draw();
				}
			}
		} else if (track == 3) {
			if (currentLine < wrong.size()) {
				line = wrong.get(currentLine);
				if (line.contains("Javaris:")) {
					javarisAnimation.draw();
				}
				if (line.contains("Annie:")) {
					annieSad.draw();
				}
				if (line.contains("Leopold:")) {
					leoSad.draw();
				}
				if (line.contains("Juniper:")) {
					juniperSad.draw();
				}
				if (line.contains("Christian:")) {
					christianSad.draw();
				}
				if (line.contains("Julian:")) {
					julianSad.draw();
				}
			}
		}
		if (line.contains("Stormy: ")) {
			mainCharAnimation.draw();
		}
		dialogueBackground.draw(x, y, 900, 175);
		g.drawString(line, 75, 625);
	}

}
