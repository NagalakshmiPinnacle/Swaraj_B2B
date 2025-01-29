package com.swaraj.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DDTloginPage {
	 private WebDriver driver;
	    private WebDriverWait wait;

	    @FindBy(id = "username")
	    private WebElement usernameField;

	    @FindBy(id = "password")
	    private WebElement passwordField;

	    @FindBy(id = "loginButton")
	    private WebElement loginButton;

	    @FindBy(id = "errorMessage")
	    private WebElement errorMessage;

	    public DDTloginPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }

	    public void enterUsername(String username) {
	        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
	    }

	    public void clickLogin() {
	        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	    }

	    public String getErrorMessage() {
	        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
	    }

	    public void login(String username, String password) {
	        enterUsername(username);
	        enterPassword(password);
	        clickLogin();
	    }
	}



