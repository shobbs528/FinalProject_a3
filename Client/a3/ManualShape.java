package Client.a3;

import tage.*;
import tage.shapes.*;

public class ManualShape extends ManualObject
{
    private float[] vertices = new float[]//(x,y,z)
            {       -1.0f, 0.0f, 1.0f,     1.0f, 0.0f, 1.0f,      0.0f, 1.0f, 0.0f, //front
                    1.0f, 0.0f, 1.0f,     1.0f, 0.0f, -1.0f,    0.0f, 1.0f, 0.0f, //right
                    1.0f, 0.0f, -1.0f,    -1.0f, 0.0f, -1.0f,   0.0f, 1.0f, 0.0f, //back
                    -1.0f, 0.0f, -1.0f,   -1.0f, 0.0f, 1.0f,    0.0f, 1.0f, 0.0f, //left

                    -1.0f, 0.0f, 1.0f,     1.0f, 0.0f, 1.0f,      0.0f, -1.0f, 0.0f, //front
                    1.0f, 0.0f, 1.0f,     1.0f, 0.0f, -1.0f,    0.0f, -1.0f, 0.0f, //right
                    1.0f, 0.0f, -1.0f,    -1.0f, 0.0f, -1.0f,   0.0f, -1.0f, 0.0f, //back
                    -1.0f, 0.0f, -1.0f,   -1.0f, 0.0f, 1.0f,    0.0f, -1.0f, 0.0f, //left
            };

    private float[] texcoords = new float[] //(x,y)
            {       0.0f, 0.0f,    1.0f, 0.0f,   0.5f, 1.0f,
                    0.0f, 0.0f,    1.0f, 0.0f,   0.5f, 1.0f,
                    0.0f, 0.0f,    1.0f, 0.0f,   0.5f, 1.0f,
                    0.0f, 0.0f,   1.0f, 0.0f,    0.5f, 1.0f,
                    0.0f, 0.0f,   1.0f, 1.0f,   0.0f, 1.0f,
                    1.0f, 1.0f,   0.0f, 0.0f,   1.0f, 0.0f,

                    0.0f, 0.0f,    1.0f, 0.0f,   0.5f, 1.0f,
                    0.0f, 0.0f,    1.0f, 0.0f,   0.5f, 1.0f,
                    0.0f, 0.0f,    1.0f, 0.0f,   0.5f, 1.0f,
                    0.0f, 0.0f,   1.0f, 0.0f,    0.5f, 1.0f,
                    0.0f, 0.0f,   1.0f, 1.0f,   0.0f, 1.0f,
                    1.0f, 1.0f,   0.0f, 0.0f,   1.0f, 0.0f,
            };

    private float[] normals = new float[]
            {        0.0f, 1.0f, 1.0f,    0.0f, 1.0f, 1.0f,    0.0f, 1.0f, 1.0f,
                    1.0f, 1.0f, 0.0f,     1.0f, 1.0f, 0.0f,    1.0f, 1.0f, 0.0f,
                    0.0f, 1.0f, -1.0f,    0.0f, 1.0f, -1.0f,   0.0f, 1.0f, -1.0f,
                    -1.0f, 1.0f, 0.0f,    -1.0f, 1.0f, 0.0f,   -1.0f, 1.0f, 0.0f,
                    0.0f, -1.0f, 0.0f,    0.0f, -1.0f, 0.0f,   0.0f, -1.0f, 0.0f,
                    0.0f, -1.0f, 0.0f,    0.0f, -1.0f, 0.0f,   0.0f, -1.0f, 0.0f,

                    0.0f, 1.0f, 1.0f,    0.0f, 1.0f, 1.0f,    0.0f, 1.0f, 1.0f,
                    1.0f, 1.0f, 0.0f,     1.0f, 1.0f, 0.0f,    1.0f, 1.0f, 0.0f,
                    0.0f, 1.0f, -1.0f,    0.0f, 1.0f, -1.0f,   0.0f, 1.0f, -1.0f,
                    -1.0f, 1.0f, 0.0f,    -1.0f, 1.0f, 0.0f,   -1.0f, 1.0f, 0.0f,
                    0.0f, -1.0f, 0.0f,    0.0f, -1.0f, 0.0f,   0.0f, -1.0f, 0.0f,
                    0.0f, -1.0f, 0.0f,    0.0f, -1.0f, 0.0f,   0.0f, -1.0f, 0.0f,
            };


    /*                    -1.0f, -1.0f, 1.0f,     1.0f, -1.0f, 1.0f,     0.0f, -1.0f, 0.0f, //front bottom
                    1.0f, -1.0f, 1.0f,      1.0f, -1.0f, -1.0f,    0.0f, -1.0f, 0.0f, //right
                    1.0f, -1.0f, -1.0f,    -1.0f, -1.0f, -1.0f,    0.0f, -1.0f, 0.0f, //back
                    -1.0f, -1.0f, -1.0f,   -1.0f, -1.0f, 1.0f,     0.0f, -1.0f, 0.0f, //left*/
    public ManualShape()
    {	super();
        setNumVertices(36);
        setVertices(vertices);
        setTexCoords(texcoords);
        setNormals(normals);
        setMatAmb(Utils.goldAmbient());
        setMatDif(Utils.goldDiffuse());
        setMatSpe(Utils.goldSpecular());
        setMatShi(Utils.goldShininess());
    }
}