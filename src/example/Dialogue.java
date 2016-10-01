package example;

import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Dialogue {

	int x, y;
	int currentLine = 0;

	boolean endCond = false;
	boolean nextScene = false;
	ArrayList<String> dialogues;
	ArrayList<String> correct;
	ArrayList<String> wrong;
	int rightAnswer;

	Image dialogueBackground;

	public Dialogue(ArrayList<String> _dialogues, int _rightAnswer, ArrayList<String> _correct, ArrayList<String> _wrong) throws SlickException {
		dialogueBackground = new Image("images/textbox.png");
		x = 50;
		y = 600;

		rightAnswer = _rightAnswer;
		dialogues = _dialogues;
		correct = _correct;
		wrong = _wrong;
	}
	
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
		
		System.out.println(game.getScene());
		if (dialogues.get(currentLine).contains("Riddle:")) {
			if (input.isKeyPressed(Input.KEY_1) ) {
				if(rightAnswer == 1){
					//show trhe correct dialogeu
				}
				else
				{
					//show wrong answer
				}
				currentLine = dialogues.size() - 2;
				endCond = true;
			} else if (input.isKeyPressed(Input.KEY_2) ) {
				if(rightAnswer == 2){
					//show trhe correct dialogeu
				}
				else
				{
					//show wrong answer
				}
				currentLine = dialogues.size() - 1;
			} else if (input.isKeyPressed(Input.KEY_3)) {
				if(rightAnswer == 3){
					//show trhe correct dialogeu
				}
				else
				{
					//show wrong answer
				}
				currentLine = dialogues.size() - 1;
			} else if (input.isKeyPressed(Input.KEY_4)) {
				if(rightAnswer == 4){
					//show trhe correct dialogeu
				}
				else
				{
					//show wrong answer
				}
				currentLine = dialogues.size() - 1;
			}
		}
		else{
			if (input.isKeyPressed(Input.KEY_SPACE) && currentLine < dialogues.size()) {
				currentLine++;
			}  
		}
		
		if (correct == null && wrong == null ){
			if (currentLine == dialogues.size()){
				game.toggleGamemode();
				currentLine = 0;
			}
		}
		
		if (currentLine == dialogues.size() && endCond == true) {
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
