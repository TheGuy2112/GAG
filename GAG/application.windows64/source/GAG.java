import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class GAG extends PApplet {

boolean changed = false;

String[] hammers = new String[]{"Sharing", "Praising", "Voting", "Trading", "Healing", "Cooperating", "Singing", "Subverting", "Nurturing", "Creating", "Avoiding", "Boasting", "Collecting", "Complaining", "Deceiving", "Delaying", "Destroying", "Disarming", "Embarassing", "Exploiting", "Harassing", "Haunting", "Jamming", "Melting", "Protecting", "Punishing", "Smashing", "Tempting", "Walking", "Yelling"};
String[] pillars = new String[]{"Sexism\n(stereotypes of and discrimination based on sexual roles)\nstrategies: education, awareness, legislation", "Colonialism\n(exploitation of one group by people of another)\nstrategies: economic, political, or cultural resistance", "Racism\n(personal and instituional discrimination based on race, belief in the superiority of one race)\nstrategies: education, diversification, legislation", "Food Politics\n(GMO crops, factory farming, low availability of quality foods in low-income neighborhoods)\nstrategies: incentives for sustainable agriculture, food co-ops", "Displacement\n(forced relocation, refugess, migrant workers)\nstrategies: security, economic developement", "Pollution\n(toxic waste, emissions, trash, unclean air)\nstrategies: clean-ups, legislation, incentives for sustainable practices", "Crime\n(theft, abuse, violence, corruption)\nstrategies: community developement, law enforcement", "Social Inequality\n(income disparity, technological divides, gentrification, lack of healthcare, targeting by police)\nstrategies: income redistribution, welfare programs, anarchosyndicalism", "Addiction\n(destructive dependence on drugs, alcohol, wealth, pleasure, etc.)\nstrategies: emotional support, counseling, peer pressure", "Disease\n(HIV/ADIS, epidemics, diabetes, cancer, healthcare)\nstrategies: medical research, government investment, public education"};
String[] games = new String[]{"Super Mario Brothers\naracede scrolling platform game\nevade or destroy enemies\nrun and jump from platform to platform\nsuper power modes", "Asteroids\narcade shooting game\nmoving field of asteroids\nevade or destroy objects\nplayer-controlled starship\nlaser, rotation, thrusters and teleportation", "Gran Tourismo\narcade car racing game\ncompete against the computer or other players\nwin prize money to upgrade car", "Centipede\narcade shooting game\nevade or destroy enemies\nchanging field of mushrooms\nlaser weapon\nenemy morphs or divides when hit", "Pac-Man\narcade maze game\nnavigate maze\nevade or temporarily destroy enemies\nconsume all dots on screen to advance", "Tetris\naracde puzzle game\nmatchfalling pieces to form solid rows\nsolid rows disapear to make room for more pieces", "Quake\nfirst person shooter\nevade or destroy enemies\nmultiple weapons\nmultiple levels", "Myst\nsingle-player adventure puzzle game\nsolve story puzzles\nexplore immersive worlds\nlogic and skill puzzles","Scrabble\nturn-base board game\nspell words with lettered tiles\nlarger words earn more points", "Monopoly\nturn-base board game\nacquire wealth and property\nbankrupt opponents\nbuy, sell, trade develop and rent properties", "Age of Empires\nreal time strategy game\ncommand armiesin battle\nconquer foes to acquire new territory\nlead a civilization through increasing technological developement", "Portal\nfirst-person puzzle game\nsue a teleportation gun to overcome obstacles\nexcape from scientific laboratory", "Manhunt\nthird-person stealth game\navoid detection while eliminationg enemies\nuse variety of weapons to brutally kill", "World of Warcraft\nmassively multiplayer online role playing game\ncreate a hero or villain and work in groups to complete quests\nearn money and upgrade weapons, equipment and skills", "The Sims\nstrategic life-simulation game\nmanage daily lives of avatars\nkeeps Sims happy and fullfilled by balancing work, recreation and romance", "Donkey Kong\nplatform game\njump over barrels while ascending series of ramps and ladders", "Grand Theft Auto\nsandbox-style action adventure game\ncomplete missions involving criminal activity in an open, non-linear world to increase your status\nuse a variety of weapons and unarmed combat\ncomplete various side mission", "Guitar Hero\nmusic game\nmanipulate a guitar-style controller to match on-screen cues\nkeep the crowd excited by playing accurately", "Sonic the Hedgehog\nside-scrolling platform game\nhigh-speed gameplay\nrun through levels avoiding obstacles\necological theme", "Katamari Damacy\nthird-person puzzle action game\ncollect objects by rolling them together into a ball\ncollect objects to create clusters of a certain size in the time limit"};
String[] trees = new String[]{"Accountability", "Autonomy", "Community", "Confidence", "Creativity", "Democracy", "Dignity", "Efficiency", "Egalitarianism", "Freedom", "Generosity", "Happiness", "Humility", "Humor", "Individualism", "Justice", "Liberty", "Openmindedness", "Peace", "Preserverance", "Privacy", "Respect", "Style", "Sustainability", "Sympathy", "Status", "Tenacity", "Tradition", "Trust", "Wealth"};

public void shuffle(String[] arr) {
  for (int i=0;i<arr.length;i++) {
    int a = i;
    int b = (int)(random(arr.length-1));
    String help = arr[a];
    arr[a] = arr[b];
    arr[b] = help;
  }
}

String[] hammer, pillar, game, tree;
int hammer_idx, pillar_idx, game_idx, tree_idx;

public void setup() {
  
  shuffle(hammers);
  shuffle(pillars);
  shuffle(games);
  shuffle(trees);
  
  hammer_idx = (int)random(hammers.length);
  pillar_idx = (int)random(pillars.length);
  game_idx = (int)random(games.length);
  tree_idx = (int)random(trees.length);
  
  hammer = hammers[hammer_idx].split("\n");
  pillar = pillars[pillar_idx].split("\n");
  game = games[game_idx].split("\n");
  tree = trees[tree_idx].split("\n");
  
  fill(0);
  rectMode(CORNERS);
  textAlign(CENTER);
  stroke(0);
  strokeWeight(5);
}

public void draw() {
  background(255);

  line(width/2, 0, width/2,height);
  line(0,height/2,width,height/2);
  
  textSize(32);
  text(hammer[0],10,10,width/2-10,height/2-10);
  text(pillar[0],width/2+10,10,width-10,height/2-10);
  text(game[0],10,height/2+10,width/2-10,height-10);
  text(tree[0],width/2+10,height/2+10,width-10,height-10);
  
  textSize(15);
  for(int i=1;i<hammer.length;i++) {
    text(hammer[i],10,10+40+i*40,width/2-10,height/2-10);
  }
  for(int i=1;i<pillar.length;i++) {
    text(pillar[i],width/2+10,10+40+i*60,width-10,height/2-10);
  }
  for(int i=1;i<game.length;i++) {
    text(game[i],10,height/2+10+40+i*40,width/2-10,height-10);
  }
  for(int i=1;i<tree.length;i++) {
    text(tree[i],width/2+10,height/2+10+40+i*40,width-10,height-10);
  }
  
}

public void mousePressed() {
  if (!changed) {
    boolean x = mouseX<width/2;
    boolean y = mouseY<height/2;
    if (x&&y) {
      int idx = (int)random(hammers.length);
      while (idx == hammer_idx) idx = (int)random(hammers.length);
      hammer_idx = idx;
      hammer = hammers[hammer_idx].split("\n");
    }
    else if (x&&!y) {
      int idx = (int)random(games.length);
      while (idx == game_idx) idx = (int)random(games.length);
      game_idx = idx;
      game = games[game_idx].split("\n");
    }
    else if (!x&&y) {
      int idx = (int)random(pillars.length);
      while (idx == pillar_idx) idx = (int)random(pillars.length);
      pillar_idx = idx;
      pillar = pillars[pillar_idx].split("\n");
    }
    else {
      int idx = (int)random(trees.length);
      while (idx == tree_idx) idx = (int)random(trees.length);
      tree_idx = idx;
      tree = trees[tree_idx].split("\n");
    }
    changed = true;
  }
}
  public void settings() {  size(800,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "GAG" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
