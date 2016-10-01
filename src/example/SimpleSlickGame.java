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

		oldMan = new MainChar(new Image("images/oldman.jpg"));

		background1 = new Image("images/background.jpg");
		npc1 = new Char(new Image("images/character1.jpg"), 200, 200);

		ArrayList<String> dialogues = new ArrayList<String>();
		ArrayList<String> correct = new ArrayList<String>();
		ArrayList<String> wrong = new ArrayList<String>();

		dialogues.add(
				"Stormy: Oh no I procrastinated for too long!  ThereÅfs no way IÅfll ever finish my Comm Media \nfinal in time before class tomorrow! Professor Wizard will be so disappointed...");
		dialogues.add("Stormy: I betterÅc KeepÅc No put that frame.. ");
		dialogues.add("Stormy: zzÅc.zÅc.. zÅcÅc. ");
		dialogues.add("Stormy: What in the name Gloria Steinem is this?");
		dialogues.add("Javaris: GREETINGS");
		dialogues.add("Javaris: Oh magnificent, strong, empowered, female heroine, I have a task to ask of thee!");
		dialogues.add("Stormy: What is it? Who are you? You kind of look like Professor WizardÅc");
		dialogues.add(
				"Javaris: Amidst the hardships of finals week, WOE has befallen the colleges of the Fenway, \nseek out your peers. The leopard, the cardinal, the mastodon, the hound, and the \nwildcat all require aid.");
		dialogues.add("Stormy: What do you mean?");
		dialogues.add(
				"Javaris: Your peers have succumbed to  the stress of finals and need an encouraging soul to \ncome lift their spirits back up, visit each one in turn and bring back the \nenthusiasm for life that finals has drained!");
		dialogues.add("Javaris: And hero!  If you should fail this task, youÅfre fired.");
		dialogues.add("Stormy: What?!  I donÅft even work for yo-");
		dialogues.add(
				"Stormy: What a strange dreamÅc  Oh well, I better put my Doc Martens on and go check on my \nfriend Leopold.");

		dialogue1 = new Dialogue(dialogues);

		background2 = new Image("images/Background2.jpg");
		npc2 = new Char(new Image("images/shark.gif"), 400, 400);

		dialogues = new ArrayList<String>();
		correct = new ArrayList<String>();
		wrong = new ArrayList<String>();

		dialogues.add("Stormy: Leopold!  Leopold!");
		dialogues.add(
				"Leopold: This code!  What do you MEAN my method isnÅft static!  YouÅfre not static you \nconfounding piece of-");
		dialogues.add(
				"Stormy: Whoa, whoa there friend!  You look like youÅfre about to smash that laptop!  \nIs everything okay?");
		dialogues.add(
				"Leopold: Yes- I mean no, not really.  I got distracted reading /r/ShowerThoughts and \nleft all my finals till the last minute and now IÅfm beyond stressed.");
		dialogues.add(
				"Leopold: Actually, can you answer a couple of questions for me?  ItÅfs for this creative \nwriting class IÅfm taking, some wizard looking character said you \nmay be able to helpÅc");
		dialogues.add(
				"Leopold: Okay here it is: ÅeThe more you have of it the less you seeÅf.  What could that \npossibly be referring to? \n1. Money \n2. Darkness \n3. An illusion \n4. Attitude");

		correct.add("Leopold: ThatÅfs it! That has to be it! ");
		correct.add(
				"Stormy: I think you didnÅft think of that idea at first because you cats have \nnight vision, donÅft you?");
		correct.add("Leopold: Yeah!  I never thought of that answer because I can always see in the dark!");
		correct.add(
				"Leopold: YouÅfre so much more helpful than the stuff I found StackOverflow, \nthanks a lot!  I feel so much more relaxed and confident now.  I donÅft know why, \nI was caught up doing finals and those riddles kept nagging at me!");
		correct.add("Leopold: YouÅfre a true friend, thanks Stormy!");

		wrong.add("Leopold: HmmÅc That doesnÅft sound quite right though, think of any other ideas?");

		dialogue2 = new Dialogue(dialogues, 2, correct, wrong);

		background3 = new Image("images/background3.jpg");

		dialogues = new ArrayList<String>();
		correct = new ArrayList<String>();
		wrong = new ArrayList<String>();

		dialogues.add(
				"Julian: So many elements and acronyms to memorizeÅc I know all this knowledge is going \nto save lives one day but pharmaceuticals are so complicatedÅc!");
		dialogues.add("Stormy: Hey Julian I heard you may be having some trouble, anything I can do?");
		dialogues.add(
				"Julian: Sodium!  I mean.. Stormy!  Ah my mistake, finals have me so distraught!  \nMy finals are just so rough, I have so much to memorize and no time and \nWHY did I decide to go into Pharmaceuticals");
		dialogues.add("Julian: Oh right I like helping people.  But not at the cost of my sanity...");
		dialogues.add("Stormy: ItÅfs alright Julian, but again, is there any way I can help? You look so stressed.");
		dialogues.add(
				"Julian: Actually thereÅfs this one thing, I donÅft know whatÅfs with all the teachers \nthis semester they all seem to be obsessed with riddles?  Anyway one of \nmy Chem teachers decided it would be funny to put a couple on our final.");
		dialogues.add(
				"Julian: ItÅfs not funny.  Actually funny youÅfre here, this old bloke came by and \nmentioned you may be able to help.");
		dialogues.add(
				"Julian: Okay so here it is: ÅeWhy do chemists like nitrates so much?Åf I canÅft think \nof anything beyond the obvious scientific reasons! \n1. They're cheaper than day rates \n2. Polyatmoic ions are lyfe \n3. Because those chemists need to go outside \n4. Because... science?");

		correct.add(
				"Julian: That was probably the worst joke IÅfve ever heard, but I think thatÅfs the solution!  Why do our professors torture us so?");
		correct.add(
				"Stormy: I donÅft know!  WhatÅfs with all these teachers giving riddles on \ntheir finals?  Seems a bit out of character and silly and causing unnecessary stress.  \nIÅfm so glad we solved that though!");
		correct.add(
				"Jullian: I agree, itÅfs most peculiar, but thank you so much for your help, Stormy! \nIÅfll record our findings in my data journal.");

		wrong.add(
				"Julain: HmmÅc I donÅft quite think thatÅfs the right answer.  Maybe look at it from \na different angle?");

		dialogue3 = new Dialogue(dialogues, 1, correct, wrong);

		background4 = new Image("images/background4.jpg");

		dialogues = new ArrayList<String>();
		correct = new ArrayList<String>();
		wrong = new ArrayList<String>();

		dialogues.add("CHURCH BELLS RING IN THE DISTANCE OVER A SERENE CAMPUS, \nYET SOMETHING FEELS AMISS");
		dialogues.add(
				"Stormy: I always love walking through this campus itÅfs so calming, and I mean itÅfs \na convenient shortcut between Academic and Res campus too which always \nhelps!");
		dialogues.add(
				"Stormy: Oh thereÅfs my friend Christian!  Oh wow he looks like someone just stepped \non his tail.  I better make sure heÅfs okay.");
		dialogues.add(
				"Christian: My ma always said I need to keep my head in the game, but when the game \ngets this ruff?  What do I do?");
		dialogues.add(
				"Christian: It feels like IÅfm chasing my tail in circles, always so close but never \nclose enough to my goal!");
		dialogues.add("Stormy: Christian whatÅfs wrong?");
		dialogues.add(
				"Christian: Oh Stormy!  I wish I could hang out but IÅfm busy as a stump-tailed cow \nin fly time.  These teachers just donÅft know when to quit!");
		dialogues.add(
				"Christian: WeÅfre doing finals but my rhetoric professor assigned us all these riddles \nfor homework and thereÅfs just one I canÅft seem to wrap my head \naround!");
		dialogues.add(
				"Stormy: Oh no maybe I can help?  ItÅfs gonna sound crazy but I had this dream and this \neccentric wizard dude said you may be having some trouble with \nfinals so I came to check on you.");
		dialogues.add(
				"Christian: Okay here it is: ÅeThis thing all things devours:Birds, beasts, trees, \nflowers; Gnaws iron, bites steel; Grinds hard stones to meal; Slays king, ruins town, And beats high mountain down.Åf \n1. My ex-girlfriend \n2. Poullution \n3. Time \n4. A Sharknado");

		correct.add("Stormy: Christian!  ItÅfs that riddle from The Hobbit, the answer is 'time'! ");
		correct.add(
				"Christian: Much obliged Stormy!  I really owe you one, you always know how to be \nsupportive of everyone no matter who it is.  Oh my I feel like a giant weight is off my shoulders, thanks Stormy!");
		correct.add(
				"Stormy: No problem Christian, just your friendly neighborhood tough, independent, \nstrong female lead character passing through!");
		correct.add(
				"Christian: You know characters like yours are so rare nowadays, I wish I had more \nfriends like you around.  I feel better than if IÅfd just played a good game of catch!");

		wrong.add("Christian: I donÅft know that seems off, letÅfs put a few other ideas on the table!");

		dialogue4 = new Dialogue(dialogues, 3, correct, wrong);

		background5 = new Image("images/background5.jpg");

		dialogues = new ArrayList<String>();
		correct = new ArrayList<String>();
		wrong = new ArrayList<String>();

		dialogues.add(
				"Annie: Ah!  This stress is killing me!  How am I supposed to become a teacher \nand help kids learn if I canÅft even learn myself!");
		dialogues.add(
				"Annie: Oh Stormy! ItÅfs so wonderful to do you, howÅfs that fin you sprained last \nweek?  Did everything heal okay!  Oh and are you getting enough water??");
		dialogues.add("Annie: I know youÅfre always terrible about that!  You need your water!");
		dialogues.add("Stormy: Annie!  Why are you worrying about me so much, you look so stressed!");
		dialogues.add(
				"Annie: Oh itÅfs just finals, one of my professors thought itÅfd be funny to give us \na bunch of riddles to do as homework and while I DO appreciate a \nlittle innovation and humor every now and then in classes this one is just so difficult!");
		dialogues.add(
				"Stormy: IÅfve been helping a lot of people with problems like these lately!  Let me \ntake a look at it!");
		dialogues.add(
				"Annie: Okay so here it is! ÅeI go around in circles, but always straight ahead, never \ncomplain, no matter where I am led.Åf  I canÅft even begin to figure this out. \n1. A wheel \n2. A donkey \n3. A servant \n4. A unicycle");

		correct.add("Stormy: Hey Annie, donÅft you go to WHEELock?");
		correct.add("Annie: ÅgOh of course!  A wheel!  ThatÅfs so obvious, I canÅft believe I didnÅft see that!");
		correct.add(
				"Annie: ÅgYouÅfre such a dear!  Thank you so much Stormy!  That helps a whole lot, I think \nIÅfll be able to concentrate on my other schoolwork so much \neasier now!");
		correct.add("Stormy: ÅgAlways here to help a friend out, you know IÅfm here if you need to talk!");

		wrong.add(
				"Annie: IÅfm not quite so sure about that one sweetie, try something else maybe?  IÅfm sure \nsomething will click!");

		dialogue5 = new Dialogue(dialogues, 1, correct, wrong);

		background6 = new Image("images/background6.jpg");

		dialogues = new ArrayList<String>();
		correct = new ArrayList<String>();
		wrong = new ArrayList<String>();

		dialogues.add(
				"Juniper: She said that I cut that one graphic .000001 cm shorter on one side than the \nother but I canÅft even see a difference and now IÅfve gotta \ndo it all over again!");
		dialogues.add("Juniper: This is why I never have any printing money!");
		dialogues.add(
				"Juniper: Such rigid guidelines really cut into the free spirit I try to encompass \nin my graphic design projectsÅc");
		dialogues.add("Stormy: Hey Juniper whatÅfs going on?");
		dialogues.add(
				"Juniper: Do you mean in my life or in my heart because quite frankly Stormy my heart \nis in turmoil and my head is ripping in half over these \nGraphic Design final projects!");
		dialogues.add(
				"Juniper: And AS IF my current stress wasnÅft enough, one of my mandatory literature \nclasses assigned these AWFUL riddles, I  could figure out \nmost of them but thereÅfs this one that just keeps eluding me!");
		dialogues.add(
				"Stormy: Oh give me a shot at it!  Maybe IÅfll be able to provide some other insight \nand we can figure it out together!");
		dialogues.add(
				"Juniper: Okay so here it is: ÅeI have keys but do not lock. I have space but have no \nroom. You can enter but not come in. What am I?Åf \n1. The void \n2. The bank \n3. A vampire's coffin \n4. A keyboard");

		correct.add(
				"Juniper: Oh wow, thatÅfs actually a little corny to be honest, I canÅft believe I couldnÅft \nfigure that out.");
		correct.add("Stormy: Better now?");
		correct.add("Juniper: I feel so great itÅfs almost like we rid the world of Comic Sans.");
		correct.add(
				"Stormy: WhatÅfs wrong with Comic Sans?  My computer science professor says itÅfs the \nbest font in the world!");
		correct.add("Juniper: .......");
		correct.add(
				"Juniper: Thanks for the help though Stormy!  You really saved the day, IÅfve still got a \nlot of things to glue though for my display, seeya!");
		correct.add("Stormy: Wait!  Really whatÅfs wrong with Comic Sans?!");

		wrong.add("Juniper: ÅgHmmÅc Clever, but not quite, take another stab at it?");

		dialogue6 = new Dialogue(dialogues, 4, correct, wrong);

		background7 = new Image("images/background7.jpg");

		dialogues = new ArrayList<String>();

		dialogues.add("Stormy: Whew!  That was eventful!  IÅfm so glad everyoneÅfs okay!");
		dialogues.add("Javaris: GREETINGS young one");
		dialogues.add("Javaris: YouÅfre fired.");
		dialogues.add("Stormy: But I completed my task!  DonÅft fire me!");
		dialogues.add("Javaris: Fired again!");
		dialogues.add("Stormy: But I donÅft even work for you!");
		dialogues.add(
				"Javaris: Ahahah, I know, you did a fine job, young one.  10 points to Simmons!  \nAnd I award you with a magical wave of my wand~ \nFinalis Examinus Passicus!");
		dialogues.add("Stormy: Wait I passed my final!?");
		dialogues.add(
				"Javaris: You demonstrated EXCELLENT skills in communications, I think that deserves \nan A for your Comm final!  Or, at least a lot \nof extra credit for effort.");

		dialogue7 = new Dialogue(dialogues);

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

		// shark.draw(250, 300);
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
			if (gamemode == 2) {
				dialogue3.render(gc, g);
			}

		} else if (scene == 4) {
			background4.draw(0, 0, 1000, 800);
			oldMan.render(gc, g);
			if (gamemode == 2) {
				dialogue4.render(gc, g);
			}

		} else if (scene == 5) {
			background5.draw(0, 0, 1000, 800);
			oldMan.render(gc, g);
			if (gamemode == 2) {
				dialogue5.render(gc, g);
			}

		} else if (scene == 6) {
			background6.draw(0, 0, 1000, 800);
			oldMan.render(gc, g);
			if (gamemode == 2) {
				dialogue6.render(gc, g);
			}

		} else if (scene == 7) {
			background7.draw(0, 0, 1000, 800);
			oldMan.render(gc, g);
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