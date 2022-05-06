package Client.a3;

import net.java.games.input.Component;
import net.java.games.input.Event;
import org.joml.Vector3f;
import tage.Camera;
import tage.Engine;
import tage.GameObject;
import tage.input.InputManager;
import tage.input.action.AbstractInputAction;

public class CameraOrbit3D
{
    private Engine engine;
    private Camera camera;		//the camera being controlled
    private GameObject avatar;	//the target avatar the camera looks at
    private float cameraAzimuth;	//rotation of camera around target Y axis
    private float cameraElevation;	//elevation of camera above target
    private float cameraRadius;	//distance between camera and target
    private myGame game;

    public CameraOrbit3D(Camera cam, GameObject av, String gpName, Engine e, myGame g)
    {	engine = e;
        camera = cam;
        avatar = av;
        cameraAzimuth = 0.0f;		// start from BEHIND and ABOVE the target
        cameraElevation = 20.0f;	// elevation is in degrees
        cameraRadius = 4.0f;		// distance from camera to avatar
        game = g;
        //returns OnDolphin boolean
        //If we're on the dolphin, we want this class to control camera movement.
        setupInputs(gpName);
        updateCameraPosition();

    }

    private void setupInputs(String gp)
    {	CameraOrbit3D.OrbitAzimuthAction azmAction = new CameraOrbit3D.OrbitAzimuthAction();
        CameraOrbit3D.OrbitRadiusAction radiusAction = new OrbitRadiusAction();
        CameraOrbit3D.OrbitElevationAction elevationAction  = new OrbitElevationAction();
        CameraOrbit3D.OrbitZoomIn zoomIn  = new OrbitZoomIn();
        InputManager im = engine.getInputManager();
               //Change to X rotation, should be left right on the right stick.
        im.associateAction(gp,
                Component.Identifier.Axis.Z,
                azmAction, InputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);
                
                //Change to Rotation Y should be up/down right stick
        im.associateAction(gp,
                Component.Identifier.Axis.RZ,
                elevationAction, InputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);
                
               //Maps to B on the Xbox controller.
        im.associateAction(gp,
                Component.Identifier.Button._2,
                radiusAction, InputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);
                //Maps to A on the Xbox controller.
        im.associateAction(gp,
                Component.Identifier.Button._1,
                zoomIn, InputManager.INPUT_ACTION_TYPE.REPEAT_WHILE_DOWN);



    }

    // Updates the camera position by computing its azimuth, elevation, and distance
    // relative to the target in spherical coordinates, then converting those spherical
    // coords to world Cartesian coordinates and setting the camera position from that.

    public void updateCameraPosition()
    {	Vector3f avatarRot = avatar.getWorldForwardVector();
        double avatarAngle = Math.toDegrees((double)avatarRot.angleSigned(new Vector3f(0,0,-1), new Vector3f(0,1,0)));
        float totalAz = cameraAzimuth - (float)avatarAngle;
        double theta = Math.toRadians(totalAz);	// rotation around target
        double phi = Math.toRadians(cameraElevation);	// altitude angle
        float x = cameraRadius * (float)(Math.cos(phi) * Math.sin(theta));
        float y = cameraRadius * (float)(Math.sin(phi));
        float z = cameraRadius * (float)(Math.cos(phi) * Math.cos(theta));
        camera.setLocation(new Vector3f(x,y,z).add(avatar.getWorldLocation()));
        camera.lookAt(avatar);
    }

    //Method that adjusts rotation of camera around target. Requirement: 1.1
    private class OrbitAzimuthAction extends AbstractInputAction
    {
        public void performAction(float time, Event event)
        {
            //Speed of rotation
            float rotAmount;
            if (event.getValue() < -0.2) {	rotAmount=0.3f; }
            else {
                    if (event.getValue() > 0.2) {rotAmount=-0.3f; }
                    else {	rotAmount=0.0f; }
            }
            cameraAzimuth += rotAmount;
            cameraAzimuth = cameraAzimuth % 360;
            updateCameraPosition();
        }
    }
    //Method that adjusts distance between camera and target aka. zoom. Requirement: 1.4
    private class OrbitRadiusAction extends AbstractInputAction
    { //Zooms out
        public void performAction(float time, Event event)
        {
            float radAmount; //Speed of zoom out
            if (event.getValue() > 0.2) { radAmount = -0.009f; }
            else { radAmount = 0.0f; }
            cameraRadius += radAmount;
            cameraRadius = cameraRadius % 360;
            updateCameraPosition();
        }
    }
    private class OrbitZoomIn extends AbstractInputAction
    { //Zooms in
        public void performAction(float time, Event event)
        {
            float radAmount; //Speed of zoom in
            if (event.getValue() > 0.2) { radAmount = 0.009f; }
            else { radAmount = 0.0f; }
            cameraRadius += radAmount;
            cameraRadius = cameraRadius % 360;
            updateCameraPosition();
        }
    }

    //Method that adjusts elevation of camera above target. Requirement: 1.3
    private class OrbitElevationAction extends AbstractInputAction
    {
        public void performAction(float time, Event event)
        {
            float elevAmount;
            if (event.getValue() < -0.2 && cameraElevation > 0)
            {	elevAmount=-0.2f; }
            else {
                if (event.getValue() > 0.2 && cameraElevation < 89.0f)
                {
                    elevAmount=0.2f;
                }
                else {	elevAmount=0.0f; }
            }
            cameraElevation += elevAmount;
            cameraElevation = cameraElevation % 360;

            updateCameraPosition();
        }
    }
}

