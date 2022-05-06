var JavaPackages = new JavaImporter(
	Packages.a3.GhostAvatar,
	Packages.org.joml.Vector3f
);

with (JavaPackages)
{
	var ghost = new GhostAvatar();
	ghost.setLocation(new Vector3f(5.0, 4.0, 2.0));
}