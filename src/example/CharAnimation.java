package example;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class CharAnimation {
	
	SpriteSheet spriteSheet;
	Animation happyAnimation;
	int x;
	int y;
	
//	public CharAnimation(SpriteSheet spriteSheet, int _x, int _y) throws SlickException{
//		happyAnimation = new Animation(new Image [] {spriteSheet.getSubImage(0, 0), spriteSheet.getSubImage(0, 1), spriteSheet.getSubImage(0, 2)},4000);
//		distraughtAnimation = new Animation(new Image [] {spriteSheet.getSubImage(1, 0), spriteSheet.getSubImage(1, 1), spriteSheet.getSubImage(1, 2)},4000 );
//		x = _x;
//		y = _y;	
//	}
	
	public CharAnimation(Image[] images, int _x, int _y) throws SlickException{
		happyAnimation = new Animation(images,1000);
		x = _x;
		y = _y;	
	}
	
	public void update(int delta){
		happyAnimation.update(delta);
	}
	
	public void draw(){
		happyAnimation.draw(x, y);
	}
	
	

}
