package scripts;

import org.tribot.api.General;
import org.tribot.api.input.Mouse;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSObject;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;

public class cutTree {
public static int[] Yew = { 9709 }; //The ID of the Yew, on the next updates we will no longer be using ID's to find Objects or NPC's
public static int rand1 = General.random(500, 1000); //This is almost pointless as we can use sleep(int, int) to grab a random but it saved about 10 seconds so I used it.

		  
    public static void chop() {
     RSObject[] tree = Objects.findNearest(7, Yew); //finds the nearest Yew in which we had earlier set the ID of
      if (tree.length > 0)
            if (tree[0].isOnScreen()) { //if tree is on the screen it will move onto clickObject which will be called from the rMouse class.			   
			   Mouse.setSpeed(rMouse.mouseSpeed);
				rMouse.clickObject(7, "Yew", "Chop down"); //finds/clicks the an interactive object with the name Yew
					General.sleep(1500 + rand1);

            }else{
			    Mouse.setSpeed(rMouse.mouseSpeed);
                Walking.walkTo(tree[0].getPosition());
                while (Player.isMoving())
                    General.sleep(800 + rand1);
            }
		
    }
}