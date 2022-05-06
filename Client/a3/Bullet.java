package Client.a3;

import org.joml.Vector3f;
import tage.GameObject;
import tage.shapes.Sphere;

public class Bullet extends GameObject
{
    protected Bullet()
    {
        Vector3f test = new Vector3f(0,0,0);
        setShape(new Sphere());
        setLocalLocation(test);

    }
}
