package com.hdfcapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginPage {
	
	private AppiumDriver<MobileElement> driver;
    public LoginPage() {
    }
    public LoginPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @iOSFindBy(xpath = "")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='ALLOW']")
	public MobileElement allowBtn;
	
    @iOSFindBy(xpath = "")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='No']")
	public MobileElement noBtn;
	
    @iOSFindBy(xpath = "")
	@AndroidFindBy(xpath = "//android.view.View[@text='Customer ID / User ID']")
	public MobileElement custIdBtn;
	
    @iOSFindBy(xpath = "")
	@AndroidFindBy(id = "fldLoginUserId")
	public MobileElement custIDTxtBox;
	
    @iOSFindBy(xpath = "")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Continue']")
	public MobileElement continueBtn;
	
    @iOSFindBy(xpath = "")
	@AndroidFindBy(id = "upass")
	public MobileElement passwordTxtBox;
	
    @iOSFindBy(xpath = "")
	@AndroidFindBy(id = "chkLogin")
	public MobileElement checkBox;
	
    @iOSFindBy(xpath = "")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Login']")
	public MobileElement loginBtn;
	
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
