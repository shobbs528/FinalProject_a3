package tage.nodeControllers;

import org.joml.Vector3f;
import tage.Engine;
import tage.GameObject;
import tage.NodeController;


public class BounceController extends NodeController {

    private Vector3f curLocation;
    private float bounceSpeed;

    private float scaleRate = 0.0003f;
    private float cycleTime = 4000.0f;
    private float totalTime = 0.0f;
    private float direction = 10.0f;

    private Engine engine;


    /** Creates a bounce controller on the vertical axis */
     public BounceController() { super(); }

    /** Creates a bounce controller on the vertical axis and speed as specified. */
    public BounceController(Engine e, float cycle) {
        super();
        bounceSpeed = .0003f;
        cycleTime = cycle;
        engine = e;
    }

    /** sets the bounce speed when the controller is enabled */
    public void setSpeed(float s) { bounceSpeed = s; }

    /**
     * This is called automatically by the RenderSystem (via SceneGraph) once per frame
     * during display().  It is for engine use and should not be called by the application.
     */
    public void apply(GameObject go)
    {
        float elapsedTime = super.getElapsedTime();
        totalTime += elapsedTime/1000.0f;
        if (totalTime > cycleTime) //This creates the bouncing affect where it goes up and down
        {
            direction = -direction;
            totalTime = 0.0f;
        }
        curLocation = go.getLocalLocation();
        Vector3f verticalDirection = go.getLocalUpVector();
        float bounceAmt = direction * bounceSpeed * elapsedTime;
        Vector3f newLocation = curLocation.add(verticalDirection.x(), verticalDirection.y()*bounceAmt, verticalDirection.z());
        go.setLocalLocation(newLocation);
    }
}