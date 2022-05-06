package Client.a3;
import tage.*;
import tage.input.action.AbstractInputAction;
import net.java.games.input.Event;
import org.joml.*;

public class TurnAction extends AbstractInputAction
{
	private myGame game;
	private GameObject av;
	private Camera cam;

	public TurnAction(myGame g) {	game = g; }

	@Override
	public void performAction(float time, Event e) {
		float keyValue = e.getValue();
		if (keyValue > -.3 && keyValue < .3) return;  // deadzone
		av = game.getPlayerModel();
		boolean onDolphin = game.getDolphinStatus();
		cam = game.getCam();
		//Right now the onDolphin is set to always true. As of 4/5/22
		if (onDolphin)
		{
			Matrix4f objectTurn = av.getLocalRotation();
			if(e.getValue() > -0.0f) {
				objectTurn.rotateY(-0.005f);
			}else{
				objectTurn.rotateY(0.005f);
			}
			av.setLocalRotation(objectTurn);

		} else {
			if (e.getValue() >= 0.0f) { cam.cameraYaw(-0.05f); }
			else { cam.cameraYaw(0.05f); }
		}
	}
}


