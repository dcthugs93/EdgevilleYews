package scripts;

import org.tribot.api.General;
import org.tribot.api.input.Mouse;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;

import java.awt.*;

public class rMouse {

public static int mouseSpeed = General.random(85, 125); //Here we are creating an integer called mouseSpeed, it will produce a random speed between 85 and 125 if you would like it faster you can make the numbers a bit higher.


public static boolean checkActions(RSObject object, String action) {
		if (object != null) {
			for (String s : object.getDefinition().getActions())
				return s.contains(action);
		}
		return false;
	}
//This whole class is meant to randomize our mouse movements a bit, including clicking.
  public static void clickObject(int distance, String objects, String option) {
        RSObject[] object = Objects.findNearest(100, objects);
        if (object != null) {
            int x = (int) object[0].getModel().getEnclosedArea().getBounds()
                    .getCenterX();
            int y = (int) object[0].getModel().getEnclosedArea().getBounds()
                    .getCenterY();
            Point p = new Point(x + General.random(-5, 8), y
                    + General.random(-4, 4));
            if (object[0].getPosition().isOnScreen()) {
                Mouse.move(p);
                if (Game.getUptext().contains(option)
                        && (checkActions(object[0], option))) {
                    Mouse.click(1);
                }
                if (!Game.getUptext().contains(option)) {
                    Mouse.click(3);
                    if (ChooseOption.isOpen()
                            && ChooseOption.isOptionValid(option))
                        ChooseOption.select(option);
                    if (ChooseOption.isOpen()
                            && !ChooseOption.isOptionValid(option))
                        Camera.turnToTile(object[0].getPosition());
                }
            } else {
                if (Player.getPosition().distanceTo(object[0].getPosition()) > 2)
                    WebWalking.walkTo(object[0].getPosition());
                if (!object[0].getPosition().isOnScreen())
                    Camera.turnToTile(object[0].getPosition());
                while (Player.isMoving()) {
                    General.sleep(50, 80);
                }
            }
        }
    }
}