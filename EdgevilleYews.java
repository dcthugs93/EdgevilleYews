package scripts;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.input.Mouse;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Painting;
import org.tribot.api.types.generic.Condition;


import javax.swing.*;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

@ScriptManifest(authors = { "dcthugs93" }, category = "Woodcutting", name = "EdgeVille Yews", description = "Beta Version, Chops Yew's in Edgeville and Banks.")
public class EdgevilleYews extends Script implements Painting{

    private static final long startTime = System.currentTimeMillis();
    private final Color color1 = new Color(0,255,0);
    private final Font font1 = new Font("Comic Sans MS", 1, 18);
    private int startLvl = Skills.getActualLevel("Woodcutting");
    private int startXP = Skills.getXP("Woodcutting");
    public static int rando;

    @Override
    public void run() {
        boolean infinite = true;
        Mouse.setSpeed(rMouse.mouseSpeed);
        while (infinite) {
		    LANAntiBan.useEvent(Events.EXAMINE_NPC, false); //Turns the Examine NPC Anti-Ban Off
		    LANAntiBan.startAntiBan(); //Turns the LAN Anti-Ban On
            if (loop() != 1)
              break;
        }
		    println("Stopping [LAN]AntiBan.");
			LANAntiBan.stopAntiBan();//Turns LAN Anti-Ban Off
    }


	
    public int loop() {
        if (Inventory.isFull()) {  //Checks to see if the inventory is full and if it is it actives bank()
            Movements.turnrunon();
            Movements.bank();
        } 
		if (Player.getPosition().distanceTo(Movements.treeTile) < 6) { //Checks to see if we are within 6 tiles to our set Tree Tile
		 while(!Ent.Ent() && !Movements.chopping()){ //Long as there isn't an Ent near by and we aren't already chopping something it will move to chop()
            cutTree.chop();
			if(Ent.Ent()){Ent.runAway();} //If there is an Ent it will activate runAway()
			}

        }
		

        return 1;
	}
	
	
	//Just the drawings.
	    @Override
    public void onPaint(Graphics g) {
        long timeRan = System.currentTimeMillis() - startTime;
        int currentLvl = Skills.getActualLevel("Woodcutting");
        int gainedLvl = currentLvl - startLvl;
        int gainedXP = Skills.getXP("Woodcutting") - startXP;
        int xpToLevel = Skills.getXPToNextLevel("Woodcutting");

        g.setFont(font1);
        g.setColor(color1);
        g.drawString("Time Ran:" + Timing.msToString(timeRan), 9, 25);
        g.drawString("Current Woodcutting Level: " + currentLvl + " (+" + gainedLvl + ")", 9, 45);
        g.drawString("XP Gained: " + gainedXP, 9, 65);
        g.drawString("XP Till Next Level: " + xpToLevel, 9, 85);
    }
}