package com.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.YourAccount_Page;

public class TC2_SearchProduct extends Base {

	@Test
	public void checkSearchProduct() {

		Base.initilizePage(new YourAccount_Page(driver));

		YourAccount_Page.loginAccount("rpc1@gmai.com", "qwertyui");
		YourAccount_Page.searchProduct("Mobile");
		Assert.assertEquals(YourAccount_Page.search_Result(),"No products found");
	}
}
