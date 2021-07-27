package runner;

import org.junit.After;

import base.Base;

public class Final {
	@After
	public void tearDown(){
		
		Base.quit();
		
	}
}
