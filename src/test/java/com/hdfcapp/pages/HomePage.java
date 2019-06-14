package com.hdfcapp.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HomePage {
	
	private AppiumDriver<MobileElement> driver;
	public HomePage(){
	}
	public HomePage(AppiumDriver<MobileElement> driver){
		this.driver = driver;
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSFindBy(xpath = "")
	@AndroidFindBy(xpath = "//android.view.View[@text='Account Summary'][1]")
	public MobileElement accountSummary;
	
	@iOSFindBy(xpath = "")
	@AndroidFindBy(xpath = "//android.view.View[@text='Statement Inquiry']")
	public MobileElement statementInquiry;
	
	@iOSFindBy(xpath = "")
	@AndroidFindBy(xpath = "//android.view.View[@text='Open Fixed Deposit < Rs 5 Cr']")
	public MobileElement openFixed 	;
	
	@iOSFindBy(xpath = "")
	@AndroidFindBy(xpath = "//android.view.View[@text='Third Party Funds Transfer']")
	public MobileElement thirdPartyFundTransfer;
	
	@iOSFindBy(xpath = "")
	@AndroidFindBy(xpath = "//android.view.View[@text='Credit Card Payment']")
	public MobileElement creditCardPayment;
	
	@iOSFindBy(xpath = "")
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='wrapper']/android.view.View/android.view.View[3]")
	public MobileElement balance;

	public void verifyTheBalanace() {
		accountSummary.click();
		String balanceInAccount = balance.getText();
		System.out.println("Balance in account is: "+balanceInAccount);
	}
	
	/*@iOSFindBy(xpath = "")
	@AndroidFindBy(xpath = "//*[@text='Credit Cards']/")
	public MobileElement accountSummary;*/
}
