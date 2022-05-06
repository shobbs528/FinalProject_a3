
var JavaPackages = new JavaImporter(
	Packages.tage.Light
);

with (JavaPackages)
{
	function updateAmbientColor(thisLight)
	{
	    var randomLight = Math.random();
	    print("randomLight "+randomLight);
	    thisLight.setAmbient(randomLight, randomLight, randomLight);
	}
}
