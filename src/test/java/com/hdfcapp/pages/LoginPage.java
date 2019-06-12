package com.hdfcapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	
	private AndroidDriver<AndroidElement> driver;
    public LoginPage() {
    }
    public LoginPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='ALLOW']")
	public AndroidElement allowBtn;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='No']")
	public AndroidElement noBtn;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Customer ID / User ID']")
	public AndroidElement custIdBtn;
	
	@AndroidFindBy(id = "fldLoginUserId")
	public AndroidElement custIDTxtBox;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Continue']")
	public AndroidElement continueBtn;
	
	@AndroidFindBy(id = "upass")
	public AndroidElement passwordTxtBox;
	
	@AndroidFindBy(id = "chkLogin")
	public AndroidElement checkBox;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Login']")
	public AndroidElement loginBtn;
	
	public void login(String user,String password){
		allowBtn.click();
		noBtn.click();
		custIdBtn.click();
		custIDTxtBox.sendKeys(user);
		continueBtn.click();
		passwordTxtBox.sendKeys(password);
		checkBox.click();
		loginBtn.click();
	}
	public void verifyThatHomePageDisplayed() {
		System.out.println("Inside then");
	}
}
