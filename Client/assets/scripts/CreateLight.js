var JavaPackages = new JavaImporter(
	Packages.tage.Light,
	Packages.org.joml.Vector3f
  );

// actually creates a world object - in this case a light
with (JavaPackages)
{	var light = new Light();
	light.setLocation(new Vector3f(5.0, 4.0, 2.0));
    print("Light created through Javascript!");
//	var plight = sm.createLight("testLamp1", Light.Type.POINT);
//	plight.setAmbient(new Color(.3, .3, .3));
//	plight.setDiffuse(new Color(.7, .7, .7));
//	plight.setSpecular(new Color(1.0, 1.0, 1.0));
//	plight.setRange(5);
}
