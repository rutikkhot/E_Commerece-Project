package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccount_Page implements Pages{

	public YourAccount_Page(WebDriver driver) {
	 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"main_content\"]/p/a") private static WebElement login ;
	
	@FindBy(id = "login-username") private static WebElement username ;
	@FindBy(id = "login-password") private static WebElement password ;
	@FindBy(name = "submit") private static WebElement btnLogin ;	
	
	@FindBy(xpath = "//*[@id=\"top_header\"]/div[2]/div[2]/div/div/form/div/div[1]/input") private static WebElement search ;
	@FindBy(xpath = "//*[@id=\"top_header\"]/div[2]/div[2]/div/div/form/div/div[2]/button") private static WebElement btnSearch ;
	
	@FindBy(xpath = "//*[@id=\"ccScroll\"]/ul/li") private static WebElement searchResult ;
	
	
	public static void loginAccount(String Username , String Password) {
		login.click();
		username.sendKeys(Username);
		password.sendKeys(Password);
		btnLogin.click();
		
	}
	
	public static void searchProduct (String search_text) {
		search.sendKeys(search_text);
		btnSearch.click();
	}
	
	public static String search_Result () {
		return searchResult.getText();
	}
	

}
