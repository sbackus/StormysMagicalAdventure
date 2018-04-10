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

	Image background1;
	Image background2;
	Image background3;
	Image background4;
	Image background5;
	Image background6;
	Image background7;

	MainChar oldMan;
	Char npc1;
	Char npc2;
	Char npc3;
	Char npc4;
	Char npc5;
	Char npc6;
	Char npc7;

	Dialogue dialogue1;
	Dialogue dialogue2;
	Dialogue dialogue3;
	Dialogue dialogue4;
	Dialogue dialogue5;
	Dialogue dialogue6;
	Dialogue dialogue7;

	int gamemode = 1;
	int scene = 1;

	ArrayList<Char> characters;

	public SimpleSlickGame(String gamename) {
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {

		oldMan = new MainChar(new Image("images/StormyOverworld.png"));

		background1 = new Image("images/background.jpg");
		npc1 = new Char(new Image("images/wizard2.png"), 200, 500);

		ArrayList<String> dialogues = new ArrayList<String>();
		ArrayList<String> correct = new ArrayList<String>();
		ArrayList<String> wrong = new ArrayList<String>();

		dialogues.add(
				"Stormy: Oh no I procrastinated for too long!  There�fs no way I'll ever finish my Comm Media \nfinal in time before class tomorrow! Professor Wizard will be so disappointed...");
		dialogues.add("Stormy: I better... Keep...No put that frame.. ");
		dialogues.add("Stormy: zz...z.... z.... ");
		dialogues.add("Stormy: What in the name Gloria Steinem is this?");
		dialogues.add("Javaris: GREETINGS");
		dialogues.add("Javaris: Oh magnificent, strong, empowered, female heroine, I have a task to ask of thee!");
		dialogues.add("Stormy: What is it? Who are you? You kind of look like Professor Wizard�c");
		dialogues.add(
				"Javaris: Amidst the hardships of finals week, WOE has befallen the colleges of the Fenway, \nseek out your peers. The leopard, the cardinal, the mastodon, the hound, and the \nwildcat all require aid.");
		dialogues.add("Stormy: What do you mean?");
		dialogues.add(
				"Javaris: Your peers have succumbed to the stress of finals and need an encouraging soul to \ncome lift their spirits back up, visit each one in turn and bring back the \nenthusiasm for life that finals has drained!");
		dialogues.add("Javaris: And hero! If you should fail this task, you're fired.");
		dialogues.add("Stormy: What?! I don't even work for yo-");
		dialogues.add(
				"Stormy: What a strange dream... Oh well, I better put my Doc Martens on and go check on my \nfriend Leopold.");

		dialogue1 = new Dialogue(dialogues);

		
		background2 = new Image("images/Background2.jpg");
		npc2 = new Char(new Image("images/LeoOverworld.png"), 300, 400);

		dialogues = new ArrayList<String>();
		correct = new ArrayList<String>();
		wrong = new ArrayList<String>();

		dialogues.add("Stormy: Leopold! Leopold!");
		dialogues.add(
				"Leopold: This code! What do you MEAN my method isn't static! You�fre not static you \nconfounding piece of-");
		dialogues.add(
				"Stormy: Whoa, whoa there friend! You look like you're about to smash that laptop!  \nIs everything okay?");
		dialogues.add(
				"Leopold: Yes- I mean no, not really. I got distracted reading /r/ShowerThoughts and \nleft all my finals till the last minute and now I�fm beyond stressed.");
		dialogues.add(
				"Leopold: Actually, can you answer a couple of questions for me? It's for this creative \nwriting class I'm taking, some wizard looking character said you may be able to help�c");
		dialogues.add(
				"Leopold: Riddle: �eThe more you have of it the less you see�f.  What could that \npossibly be referring to? \n1. Money \n2. Darkness \n3. An illusion \n4. Attitude");

		correct.add("Leopold: That�fs it! That has to be it! ");
		correct.add(
				"Stormy: I think you didn�ft think of that idea at first because you cats have \nnight vision, don�ft you?");
		correct.add("Leopold: Yeah! I never thought of that answer because I can always see in the dark!");
		correct.add(
				"Leopold: You're so much more helpful than the stuff I found StackOverflow, \nthanks a lot! I feel so much more relaxed and confident now. I don�ft know why, \nI was caught up doing finals and those riddles kept nagging at me!");
		correct.add("Leopold: You're a true friend, thanks Stormy!");

		wrong.add("Leopold: Hmm... That doesn't sound quite right though, can you think of any other ideas?");

		dialogue2 = new Dialogue(dialogues, 2, correct, wrong);

		
		background3 = new Image("images/background3.png");
		npc3 = new Char(new Image("images/JulianOverworld.png"), 600, 300);
		
		dialogues = new ArrayList<String>();
		correct = new ArrayList<String>();
		wrong = new ArrayList<String>();

		dialogues.add(
				"Julian: So many elements and acronyms to memorize�c I know all this knowledge is going \nto save lives one day but pharmaceuticals are so complicated�c!");
		dialogues.add("Stormy: Hey Julian I heard you may be having some trouble, anything I can do?");
		dialogues.add(
				"Julian: Sodium! I mean.. Stormy! Ah my mistake, finals have me so distraught! \nMy finals are just so rough, I have so much to memorize and no time and \nWHY did I decide to go into Pharmaceuticals");
		dialogues.add("Julian: Oh right I like helping people. But not at the cost of my sanity...");
		dialogues.add("Stormy: It's alright Julian, but again, is there any way I can help? You look so stressed.");
		dialogues.add(
				"Julian: Actually there's this one thing, I don't know what�fs with all the teachers \nthis semester they all seem to be obsessed with riddles? Anyway one of \nmy Chem teachers decided it would be funny to put a couple on our final.");
		dialogues.add(
				"Julian: It's not funny. Actually funny you�fre here, this old bloke came by and \nmentioned you may be able to help.");
		dialogues.add(
				"Julian: Riddle: �eWhy do chemists like nitrates so much?�f I can't think \nof anything beyond the obvious scientific reasons! \n1. They're cheaper than day rates \n2. Polyatmoic ions are lyfe \n3. Because those chemists need to go outside \n4. Because... science?");

		correct.add(
				"Julian: That was probably the worst joke I�fve ever heard, but I think that�fs the solution!  \nWhy do our professors torture us so?");
		correct.add(
				"Stormy: I don't know!  What's with all these teachers giving riddles on \ntheir finals?  Seems a bit out of character and silly and causing unnecessary stress.  \nI'm so glad we solved that though!");
		correct.add(
				"Jullian: I agree, it's most peculiar, but thank you so much for your help, Stormy! \nI'll record our findings in my data journal.");

		wrong.add(
				"Julain: Hmm... I don't quite think that�fs the right answer. Maybe look at it from \na different angle?");

		dialogue3 = new Dialogue(dialogues, 1, correct, wrong);

		
		background4 = new Image("images/background4.png");
		npc4 = new Char(new Image("images/ChristianOverworld.png"), 300, 300);
		
		dialogues = new ArrayList<String>();
		correct = new ArrayList<String>();
		wrong = new ArrayList<String>();

		dialogues.add("CHURCH BELLS RING IN THE DISTANCE OVER A SERENE CAMPUS, \nYET SOMETHING FEELS AMISS");
		dialogues.add(
				"Stormy: I always love walking through this campus it's so calming, and I mean it's \na convenient shortcut between Academic and Res campus too which always \nhelps!");
		dialogues.add(
				"Stormy: Oh, there's my friend Christian! Oh wow he looks like someone just stepped \non his tail. I better make sure he's okay.");
		dialogues.add(
				"Christian: My ma always said I need to keep my head in the game, but when the game \ngets this ruff? What do I do?");
		dialogues.add(
				"Christian: It feels like I'm chasing my tail in circles, always so close but never \nclose enough to my goal!");
		dialogues.add("Stormy: Christian what's wrong?");
		dialogues.add(
				"Christian: Oh Stormy! I wish I could hang out but I'm busy as a stump-tailed cow \nin fly time. These teachers just don't know when to quit!");
		dialogues.add(
				"Christian: We're doing finals but my rhetoric professor assigned us all these riddles \nfor homework and there's just one I can't seem to wrap my head \naround!");
		dialogues.add(
				"Stormy: Oh no maybe I can help?  It's gonna sound crazy but I had this dream and this \neccentric wizard dude said you may be having some trouble with \nfinals so I came to check on you.");
		dialogues.add(
				"Christian: Riddle: �eThis thing all things devours:Birds, beasts, trees, \nflowers; Gnaws iron, bites steel; Grinds hard stones to meal; \nSlays king, ruins town, And beats high mountain down.�f \n1. My ex-girlfriend \n2. Poullution \n3. Time \n4. A Sharknado");

		correct.add("Stormy: Christian!  It�fs that riddle from The Hobbit, the answer is 'time'! ");
		correct.add(
				"Christian: Much obliged Stormy!  I really owe you one, you always know how to be \nsupportive of everyone no matter who it is.  \nOh my I feel like a giant weight is off my shoulders, thanks Stormy!");
		correct.add(
				"Stormy: No problem Christian, just your friendly neighborhood tough, independent, \nstrong female lead character passing through!");
		correct.add(
				"Christian: You know characters like yours are so rare nowadays, I wish I had more \nfriends like you around.  I feel better than if I'd just played a good game of catch!");

		wrong.add("Christian: I don't know that seems off, let's put a few other ideas on the table!");

		dialogue4 = new Dialogue(dialogues, 3, correct, wrong);

		
		background5 = new Image("images/background5.png");
		npc5 = new Char(new Image("images/AnnieOverworld.png"), 300, 100);
		
		dialogues = new ArrayList<String>();
		correct = new ArrayList<String>();
		wrong = new ArrayList<String>();

		dialogues.add(
				"Annie: Ah! This stress is killing me! How am I supposed to become a teacher \nand help kids learn if I can�ft even learn myself!");
		dialogues.add(
				"Annie: Oh Stormy! It's so wonderful to do you, how�fs that fin you sprained last \nweek?  Did everything heal okay! Oh and are you getting enough water??");
		dialogues.add("Annie: I know you're always terrible about that! You need your water!");
		dialogues.add("Stormy: Annie! Why are you worrying about me so much, you look so stressed!");
		dialogues.add(
				"Annie: Oh it�fs just finals, one of my professors thought it�fd be funny to give us \na bunch of riddles to do as homework and while I DO appreciate a \nlittle innovation and humor every now and then in classes this one is just so difficult!");
		dialogues.add(
				"Stormy: I�fve been helping a lot of people with problems like these lately!  Let me \ntake a look at it!");
		dialogues.add(
				"Annie: Riddle: �eI go around in circles, but always straight ahead, never \ncomplain, no matter where I am led.�f  I can't even begin to figure this out. \n1. A wheel \n2. A donkey \n3. A servant \n4. A unicycle");

		correct.add("Stormy: Hey Annie, don't you go to WHEELock?");
		correct.add("Annie: �gOh of course!  A wheel!  That's so obvious, I can't believe I didn't see that!");
		correct.add(
				"Annie: �gYou're such a dear!  Thank you so much Stormy!  That helps a whole lot, I think \nI'll be able to concentrate on my other schoolwork so much \neasier now!");
		correct.add("Stormy: �gAlways here to help a friend out, you know I'm here if you need to talk!");

		wrong.add(
				"Annie: I'm not quite so sure about that one sweetie, try something else maybe?  I'm sure \nsomething will click!");

		dialogue5 = new Dialogue(dialogues, 1, correct, wrong);

		
		background6 = new Image("images/background6.png");
		npc6 = new Char(new Image("images/JuniperOverworld.png"), 500, 200);
		
		dialogues = new ArrayList<String>();
		correct = new ArrayList<String>();
		wrong = new ArrayList<String>();

		dialogues.add(
				"Juniper: She said that I cut that one graphic .000001 cm shorter on one side than the \nother but I can't even see a difference and now I�fve gotta \ndo it all over again!");
		dialogues.add("Juniper: This is why I never have any printing money!");
		dialogues.add(
				"Juniper: Such rigid guidelines really cut into the free spirit I try to encompass \nin my graphic design projects�c");
		dialogues.add("Stormy: Hey Juniper what�fs going on?");
		dialogues.add(
				"Juniper: Do you mean in my life or in my heart because quite frankly Stormy my heart \nis in turmoil and my head is ripping in half over these \nGraphic Design final projects!");
		dialogues.add(
				"Juniper: And AS IF my current stress wasn't enough, one of my mandatory literature \nclasses assigned these AWFUL riddles, I  could figure out \nmost of them but there's this one that just keeps eluding me!");
		dialogues.add(
				"Stormy: Oh give me a shot at it!  Maybe I'll be able to provide some other insight \nand we can figure it out together!");
		dialogues.add(
				"Juniper: Riddle: �eI have keys but do not lock. I have space but have no \nroom. You can enter but not come in. What am I?�f \n1. The void \n2. The bank \n3. A vampire's coffin \n4. A keyboard");

		correct.add(
				"Juniper: Oh wow, that's actually a little corny to be honest, I can't believe I couldn�ft \nfigure that out.");
		correct.add("Stormy: Better now?");
		correct.add("Juniper: I feel so great it's almost like we rid the world of Comic Sans.");
		correct.add(
				"Stormy: What's wrong with Comic Sans?  My computer science professor says it's the \nbest font in the world!");
		correct.add("Juniper: .......");
		correct.add(
				"Juniper: Thanks for the help though Stormy!  You really saved the day, I've still got a \nlot of things to glue though for my display, seeya!");
		correct.add("Stormy: Wait!  Really what's wrong with Comic Sans?!");

		wrong.add("Juniper: �gHmm�c Clever, but not quite, take another stab at it?");

		dialogue6 = new Dialogue(dialogues, 4, correct, wrong);

		
		background7 = new Image("images/background7.jpg");
		
		dialogues = new ArrayList<String>();

		dialogues.add("Stormy: Whew! That was eventful! I'm so glad everyone�fs okay!");
		dialogues.add("Javaris: GREETINGS young one");
		dialogues.add("Javaris: You're fired.");
		dialogues.add("Stormy: But I completed my task!  Don't fire me!");
		dialogues.add("Javaris: Fired again!");
		dialogues.add("Stormy: But I don�ft even work for you!");
		dialogues.add(
				"Javaris: Ahahah, I know, you did a fine job, young one. 10 points to Simmons! \nAnd I award you with a magical wave of my wand~ \nFinalis Examinus Passicus!");
		dialogues.add("Stormy: Wait I passed my final!?");
		dialogues.add(
				"Javaris: You demonstrated EXCELLENT skills in communications, I think that deserves \nan A for your Comm final!  Or, at least a lot \nof extra credit for effort.");

		dialogue7 = new Dialogue(dialogues);

		characters = new ArrayList<Char>();
		characters.add(npc1);
		characters.add(npc2);
		characters.add(npc3);
		characters.add(npc4);
		characters.add(npc5);
		characters.add(npc6);
		characters.add(npc1);

	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {

		if (gamemode == 1) {
			oldMan.update(gc, i, characters, this);
		} else if (gamemode == 2) {
			if (scene == 1) {
				dialogue1.update(gc, i, this);
			}
			if (scene == 2) {
				dialogue2.update(gc, i, this);
			}
			if (scene == 3) {
				dialogue3.update(gc, i, this);
			}
			if (scene == 4) {
				dialogue4.update(gc, i, this);
			}
			if (scene == 5) {
				dialogue5.update(gc, i, this);
			}
			if (scene == 6) {
				dialogue6.update(gc, i, this);
			}
			if (scene == 7) {
				dialogue7.update(gc, i, this);
			}
		}

	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {

		if (scene == 1) {
			background1.draw(0, 0, 1000, 800);
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

		} else if (scene == 3) {
			background3.draw(0, 0, 1000, 800);
			oldMan.render(gc, g);
			npc3.render(gc, g);
			if (gamemode == 2) {
				dialogue3.render(gc, g);
			}

		} else if (scene == 4) {
			background4.draw(0, 0, 1000, 800);
			oldMan.render(gc, g);
			npc4.render(gc, g);
			if (gamemode == 2) {
				dialogue4.render(gc, g);
			}

		} else if (scene == 5) {
			background5.draw(0, 0, 1000, 800);
			oldMan.render(gc, g);
			npc5.render(gc, g);
			if (gamemode == 2) {
				dialogue5.render(gc, g);
			}

		} else if (scene == 6) {
			background6.draw(0, 0, 1000, 800);
			oldMan.render(gc, g);
			npc6.render(gc, g);
			if (gamemode == 2) {
				dialogue6.render(gc, g);
			}

		} else if (scene == 7) {
			background7.draw(0, 0, 1000, 800);
			oldMan.render(gc, g);
			npc1.render(gc, g);
			if (gamemode == 2) {
				dialogue7.render(gc, g);
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