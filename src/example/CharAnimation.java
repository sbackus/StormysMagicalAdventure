package example;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class CharAnimation {
	
	SpriteSheet spriteSheet;
	Animation happyAnimation;
	Animation distraughtAnimation;
	
	public CharAnimation(SpriteSheet spriteSheet) throws SlickException{
		happyAnimation = new Animation(new Image [] {spriteSheet.getSubImage(0, 0), spriteSheet.getSubImage(0, 1), spriteSheet.getSubImage(0, 2)},4000);
		distraughtAnimation = new Animation(new Image [] {spriteSheet.getSubImage(1, 0), spriteSheet.getSubImage(1, 1), spriteSheet.getSubImage(1, 2)},4000 );
	}
	
	public CharAnimation(Image[] images) throws SlickException{
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
		distraughtAnimation.update(50);
		distraughtAnimation.draw(460, 20);
	}

}
