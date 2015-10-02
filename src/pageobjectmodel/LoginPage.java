package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import componenthelper.GenericHelper;

import baseclass.PageBase;

public class LoginPage extends PageBase {
	
	private WebDriver driver;
	public LoginPage(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;
	}

	@FindBy(id="username",how=How.ID)
	private WebElement username;
	
	@FindBy(id="password",how=How.ID)
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']",how=How.XPATH)
	private WebElement login;
	
	public HomePage LoginApplication(String urname,String pass) {
		Assert.assertTrue(isElementPresent(By.xpath("//div[@class='loginWrapper']")));
		username.sendKeys(urname);
		password.sendKeys(pass);
		login.click();
		GenericHelper.waitForElement(By.cssSelector(".homeProgramsNav"));
		return new HomePage(driver);
	}
	

}