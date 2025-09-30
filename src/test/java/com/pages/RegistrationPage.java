package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage implements Pages {

	 public RegistrationPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		@FindBy(name="title") private  static WebElement txtTitle;
		@FindBy(name="first_name") private static WebElement txtFirstname;
		@FindBy(name="last_name") private static WebElement txtLastname;
		@FindBy(id="email") private static WebElement txtEmail;
		@FindBy(id="phone") private static WebElement txtPhoneNo;
		@FindBy(id="mobile") private static WebElement txtMobile;
		@FindBy(id="password") private static WebElement txtPassword;
		@FindBy(id="passconf") private static WebElement txtCNFPassword;
		@FindBy(name="terms_agree") private static WebElement checkTerms;
		@FindBy(name="mailing_list") private static WebElement checkMails;
		@FindBy(id="register_submit") private static WebElement btnRegister;
		
		@FindBy(xpath="//*[@id=\"main_content\"]/div[1]/ul/li") static WebElement successtext;
		
		@FindBy(id="email-error")static WebElement errorEmail;

		
	
		public static void checkRegister(String title,String firstname, String lastname,String email, String phone_no,String mobile,
				String password, String confirmpassword)
		{
			txtTitle.sendKeys(title);
			txtFirstname.sendKeys(firstname);
			txtLastname.sendKeys(lastname);
			txtEmail.sendKeys(email);
			txtPhoneNo.sendKeys(phone_no);
			txtMobile.sendKeys(mobile);
			txtPassword.sendKeys(password);
			txtCNFPassword.sendKeys(confirmpassword);
			checkTerms.click();
			checkMails.click();
			btnRegister.click();
		}
		
		public static String sucessText()
		{
			return successtext.getText();
		}
		
}
