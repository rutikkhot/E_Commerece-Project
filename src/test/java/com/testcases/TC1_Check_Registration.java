package com.testcases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.RegistrationPage;

public class TC1_Check_Registration extends Base {


	@Test
	public static void Check() {
		Base.initilizePage(new RegistrationPage(driver));
		
	
		
		
		RegistrationPage.checkRegister("Mr", "rutik", "patil", "rpc1@gmai.com", "9876543210", "1234567890", "qwertyui", "qwertyui");
		String text = RegistrationPage.sucessText();
		Assert.assertEquals(text, "Your email address has been added to our mailing list.");
		
	
	}
	
	
}
