package scripts;

import org.tribot.api.General;
import org.tribot.api.input.Mouse;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;
import org.tribot.api2007.WebWalking;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;



public class Movements{  


  public static RSTile bankTile = new RSTile(3094, 3491);
  public static RSTile treeTile = new RSTile(3087, 3476);
  int bankbooth = 2196;
  static int[] Axe = { 1353, 1359 }; // I need all the current axe ID's to add them here.
	
	//This class holds most of our movements including banking. Most of which is self explanatory.
		public static void bank() {
        if (Player.getPosition().distanceTo(bankTile) > 1) {
            WebWalking.walkTo(bankTile);
			Mouse.setSpeed(rMouse.mouseSpeed);
            while (Player.isMoving())
			Mouse.setSpeed(rMouse.mouseSpeed);
            General.sleep(100);
            Banking.openBankBanker();
            General.sleep(100);
            Banking.depositAllExcept(Axe);
        } else {
            Banking.openBankBanker();
            General.sleep(100);
            Banking.depositAllExcept(Axe);
        }

    }
	    public static void turnrunon() {
        int x = (639 + General.random(-2, 2));
        int y = (425 + General.random(-2, 2));
        if (Game.getRunEnergy() > 25);
        if (!Game.isRunOn()) {
		    Mouse.setSpeed(rMouse.mouseSpeed);
            GameTab.open(GameTab.TABS.OPTIONS);
            General.sleep(100);
			Mouse.setSpeed(rMouse.mouseSpeed);
            Mouse.move(x, y);
			Mouse.setSpeed(rMouse.mouseSpeed);
            Mouse.clickBox(x, y, x, y, EdgevilleYews.rando);
            GameTab.open(GameTab.TABS.INVENTORY);

        }
    }
	
	    public static void walkToTrees() {
	    Mouse.setSpeed(rMouse.mouseSpeed);
        WebWalking.walkTo(treeTile);
        while (Player.isMoving())
            General.sleep(100);
    }	
	
	
  public static boolean chopping(){
		if(Player.getAnimation() == 877)
		  { return true; } else{
		  return false;}
		  } 

	
	
}