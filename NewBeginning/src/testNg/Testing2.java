package testNg;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Testing2 
{
	
	@Test(groups = "un")
	public void E()
	{
	Reporter.log("E method is running", true);
	}
	@Test(groups = "funds")
	public void F()
	{
	Reporter.log("F method is running", true);
	}
	@Test(groups = "un")
	public void G()
	{
	Reporter.log("G method is running", true);
	}
	@Test(groups = "funds")
	public void H()
	{
	Reporter.log("H method is running", true);
	}

}
