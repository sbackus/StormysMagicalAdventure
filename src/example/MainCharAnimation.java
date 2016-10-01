package example;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class MainCharAnimation {
	
	SpriteSheet spriteSheet;
	Animation happyAnimation;
	Animation distraughtAnimation;
	
	public MainCharAnimation(SpriteSheet spriteSheet) throws SlickException{
		happyAnimation = new Animation(new Image [] {spriteSheet.getSubImage(0, 0), spriteSheet.getSubImage(0, 1), spriteSheet.getSubImage(0, 2)},4000);
		distraughtAnimation = new Animation(new Image [] {spriteSheet.getSubImage(1, 0), spriteSheet.getSubImage(1, 1), spriteSheet.getSubImage(1, 2)},4000 );
	}
	
	public MainCharAnimation(Image[] images) throws SlickException{
		happyAnimation = new Animation(images,4000);
		distraughtAnimation = new Animation(images,4000 );
	}
	
	public void update(int delta){
		distraughtAnimation.update(delta);
		happyAnimation.update(delta);
	}
	
	public void drawHappy(){
		happyAnimation.draw(400, 20);
		
	}
	
	public void drawDistraught(){
		distraughtAnimation.draw(460, 20);
	}

}
