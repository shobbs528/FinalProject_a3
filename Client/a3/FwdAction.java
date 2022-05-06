package Client.a3;

import tage.*;
import tage.input.action.AbstractInputAction;
import net.java.games.input.Event;
import org.joml.*;

public class FwdAction extends AbstractInputAction
{
	private myGame game;
	private GameObject av;
	private Vector3f oldPosition, newPosition;
	private Vector4f fwdDirection;
	private Camera cam;
	private ProtocolClient protClient;

	public FwdAction(myGame g, ProtocolClient p)
	{	game = g;
		protClient = p;
	}

	@Override
	public void performAction(float time, Event e)
	{
		float keyValue = e.getValue();
		if (keyValue > -.3 && keyValue < .3) return;  // deadzone
		boolean onDolphin = game.getDolphinStatus();
		cam = game.getCam();

		av = game.getPlayerModel();

		if(onDolphin) 
      {
			if (e.getValue() >= 0.0f)
         {
				oldPosition = av.getWorldLocation();
				fwdDirection = new Vector4f(0f, 0f, -1f, -1f);
				fwdDirection.mul(av.getWorldRotation());
				fwdDirection.mul(0.008f);
				newPosition = oldPosition.add(fwdDirection.x(), fwdDirection.y(), fwdDirection.z());
				av.setLocalLocation(newPosition);
			} 
         else 
         {
				oldPosition = av.getWorldLocation();
				fwdDirection = new Vector4f(0f, 0f, 1f, 1f);
				fwdDirection.mul(av.getWorldRotation());
				fwdDirection.mul(0.008f);
				newPosition = oldPosition.add(fwdDirection.x(), fwdDirection.y(), fwdDirection.z());
				av.setLocalLocation(newPosition);
			}
		}
      else
      {
			if (e.getValue() >= 0.0f) { cam.moveFrontBack(-0.005f); }
			else { cam.moveFrontBack(0.005f); }
		}
      //Needed for networking, but broke the terrian. idk, figure it out.
     // System.out.println("ProtClient  "+protClient);
     // System.out.println("getWorldLocation "+av.getWorldLocation());
     // System.out.println("av " +av);
      
     // protClient.sendMoveMessage(av.getWorldLocation());
      
	}
}


