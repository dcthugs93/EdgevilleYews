package scripts;


import org.tribot.api.General;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;
import org.tribot.api.input.Mouse;
import org.tribot.api2007.types.RSNPC;
import org.tribot.api2007.Player;
import org.tribot.api2007.WebWalking;

	public class Ent{
   
	public static void runAway() {
	 while(Ent()) {
	 getOut();} if (!Ent()) { 
	   walkBack();
	   }
	 }
	 
	 public static void getOut(){
	 	Mouse.setSpeed(rMouse.mouseSpeed);
		Movements.turnrunon();
        WebWalking.walkTo(Movements.bankTile);
        while (Player.isMoving())
            General.sleep(100);
    }
	
	public static void walkBack(){
	  while(!Ent()){
      WebWalking.walkTo(Movements.treeTile);
	  General.sleep(100, 400);
	  }
	}
	
	//This whole class is just looking for an NPC with the name "Yew". Since a tree is an object and an ent is an NPC. If the npc is within 3 tiles it will return true, otherwise false.
	public static boolean Ent() {
		RSNPC[] ent = NPCs.findNearest("Yew");
		if (ent.length > 0) {
			if (ent[0].getPosition().distanceTo(Player.getPosition()) < 3) {
				return true;
			}
		}
		return false;
	}
}