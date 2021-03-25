package com.sdet.testNGTests;

import org.testng.annotations.Test;

public class DemoOne{
	
	    @Test(groups = {"HeaderTests"})
	    public void firstTestCase() {
	        System.out.println("I'm in first test case from demoOne Class");
	    }

	    @Test
	    public void secondTestCase() {
	        System.out.println("I'm in second test case from demoOne Class");
	    }
	
}
