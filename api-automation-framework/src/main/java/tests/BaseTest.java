package tests;

import org.testng.annotations.BeforeSuite;

import rest.utils.RestUtils;

public class BaseTest {
	
	RestUtils oRestUtil = null;
	
	@BeforeSuite
	public void setUp() {
		oRestUtil = new RestUtils();
		
	}

}
