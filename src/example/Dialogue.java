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
	CharAnimation javarisAnimation;
	CharAnimation leoHappyAnimation;
	CharAnimation leoSadAnimation;
	CharAnimation julianHappyAnimation;
	CharAnimation julianSadAnimation;
	CharAnimation christianHappyAnimation;
	CharAnimation christianSadAnimation;
	CharAnimation annieHappyAnimation;
	CharAnimation annieSadAnimation;
	CharAnimation juniperHappyAnimation;
	CharAnimation juniperSadAnimation;

	Image dialogueBackground;

	public Dialogue(ArrayList<String> _dialogues, int _rightAnswer, ArrayList<String> _correct,
			ArrayList<String> _wrong) throws SlickException {
		dialogueBackground = new Image("images/textbox.png");
		x = 50;
		y = 600;

		mainCharAnimation = new CharAnimation(new Image[] { new Image("images/Stormy1.png"),
				new Image("images/Stormy2.png"), new Image("images/Stormy3.png") }, 50, 20);
		javarisAnimation = new CharAnimation(new Image[] { new Image("images/Wizard2_big.png") }, 460, 250);
		leoHappyAnimation = new CharAnimation(new Image[] { new Image("images/LeoRelax1.png"),
				new Image("images/LeoRelax2.png"), new Image("images/LeoRelax3.png") }, 460, 20);
		leoSadAnimation = new CharAnimation(new Image[] { new Image("images/LeoStressed1.png"),
				new Image("images/LeoStressed2.png"), new Image("images/LeoStressed3.png") }, 460, 20);
		julianHappyAnimation = new CharAnimation(new Image[] { new Image("images/JulianRelax1.png"),
				new Image("images/JulianRelax2.png"), new Image("images/JulianRelax3.png") }, 460, 20);
		julianSadAnimation = new CharAnimation(new Image[] { new Image("images/JulianStressed1.png"),
				new Image("images/JulianStressed2.png"), new Image("images/JulianStressed3.png") }, 460, 20);
		christianHappyAnimation = new CharAnimation(new Image[] { new Image("images/ChristianContent1.png"),
				new Image("images/ChristianContent2.png"), new Image("images/ChristianContent3.png") }, 460, 20);
		christianSadAnimation = new CharAnimation(new Image[] { new Image("images/ChristianStressed1.png"),
				new Image("images/ChristianStressed2.png"), new Image("images/ChristianStressed3.png") }, 460, 20);
		annieHappyAnimation = new CharAnimation(new Image[] { new Image("images/AnnieContent1.png"),
				new Image("images/AnnieContent2.png"), new Image("images/AnnieContent2.png") }, 460, 20);
		annieSadAnimation = new CharAnimation(new Image[] { new Image("images/AnnieStressed1.png"),
				new Image("images/AnnieStressed2.png"), new Image("images/AnnieStressed3.png") }, 460, 20);
		juniperHappyAnimation = new CharAnimation(new Image[] { new Image("images/JuniperContent1.png"),
				new Image("images/JuniperContent2.png"), new Image("images/JuniperContent3.png") }, 460, 20);
		juniperSadAnimation = new CharAnimation(new Image[] { new Image("images/JuniperStressed1.png"),
				new Image("images/JuniperStressed2.png"), new Image("images/JuniperStressed3.png") }, 460, 20);

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
		javarisAnimation = new CharAnimation(new Image[] { new Image("images/Wizard2_big.png") }, 460, 250);
		leoHappyAnimation = new CharAnimation(new Image[] { new Image("images/LeoRelax1.png"),
				new Image("images/LeoRelax2.png"), new Image("images/LeoRelax3.png") }, 460, 20);
		leoSadAnimation = new CharAnimation(new Image[] { new Image("images/LeoStressed1.png"),
				new Image("images/LeoStressed2.png"), new Image("images/LeoStressed3.png") }, 460, 20);
		julianHappyAnimation = new CharAnimation(new Image[] { new Image("images/JulianRelax1.png"),
				new Image("images/JulianRelax2.png"), new Image("images/JulianRelax3.png") }, 460, 20);
		julianSadAnimation = new CharAnimation(new Image[] { new Image("images/JulianStressed1.png"),
				new Image("images/JulianStressed2.png"), new Image("images/JulianStressed3.png") }, 460, 20);
		christianHappyAnimation = new CharAnimation(new Image[] { new Image("images/ChristianContent1.png"),
				new Image("images/ChristianContent2.png"), new Image("images/ChristianContent3.png") }, 460, 20);
		christianSadAnimation = new CharAnimation(new Image[] { new Image("images/ChristianStressed1.png"),
				new Image("images/ChristianStressed2.png"), new Image("images/ChristianStressed3.png") }, 460, 20);
		annieHappyAnimation = new CharAnimation(new Image[] { new Image("images/AnnieContent1.png"),
				new Image("images/AnnieContent2.png"), new Image("images/AnnieContent2.png") }, 460, 20);
		annieSadAnimation = new CharAnimation(new Image[] { new Image("images/AnnieStressed1.png"),
				new Image("images/AnnieStressed2.png"), new Image("images/AnnieStressed3.png") }, 460, 20);
		juniperHappyAnimation = new CharAnimation(new Image[] { new Image("images/JuniperContent1.png"),
				new Image("images/JuniperContent2.png"), new Image("images/JuniperContent3.png") }, 460, 20);
		juniperSadAnimation = new CharAnimation(new Image[] { new Image("images/JuniperStressed1.png"),
				new Image("images/JuniperStressed2.png"), new Image("images/JuniperStressed3.png") }, 460, 20);

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
					annieSadAnimation.draw();
				}
				if (line.contains("Leopold:")) {
					leoSadAnimation.draw();
				}
				if (line.contains("Juniper:")) {
					juniperSadAnimation.draw();
				}
				if (line.contains("Christian:")) {
					christianSadAnimation.draw();
				}
				if (line.contains("Julian:")) {
					julianSadAnimation.draw();
				}

			}
		} else if (track == 2) {
			if (currentLine < correct.size()) {
				line = correct.get(currentLine);
				if (line.contains("Javaris:")) {
					javarisAnimation.draw();
				}
				if (line.contains("Annie:")) {
					annieHappyAnimation.draw();
				}
				if (line.contains("Leopold:")) {
					leoHappyAnimation.draw();
				}
				if (line.contains("Juniper:")) {
					juniperHappyAnimation.draw();
				}
				if (line.contains("Christian:")) {
					christianHappyAnimation.draw();
				}
				if (line.contains("Julian:")) {
					julianHappyAnimation.draw();
				}
			}
		} else if (track == 3) {
			if (currentLine < wrong.size()) {
				line = wrong.get(currentLine);
				if (line.contains("Javaris:")) {
					javarisAnimation.draw();
				}
				if (line.contains("Annie:")) {
					annieSadAnimation.draw();
				}
				if (line.contains("Leopold:")) {
					leoSadAnimation.draw();
				}
				if (line.contains("Juniper:")) {
					juniperSadAnimation.draw();
				}
				if (line.contains("Christian:")) {
					christianSadAnimation.draw();
				}
				if (line.contains("Julian:")) {
					julianSadAnimation.draw();
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
