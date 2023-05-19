package com.pages;

import com.qa.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    /*
    we have to mention by locators, constructor, page Methods
     */

    private WebDriver driver;
    //1. By locators

    private By navigateToLogin = By.xpath("//a[normalize-space()='Log in']");
    private By emailId = By.id("Email");
    private By passwordByUser = By.id("Password");
    private By signInButton = By.xpath("//button[normalize-space()='Log in']");

    private By forgotPwdlink = By.linkText("Forgot password?");

    private By getErrorMessage = By.xpath("//div[@class='message-error validation-summary-errors']");

    private By getGetErrorMessage2 = By.id("Email-error");
    private By myAccountPage = By.xpath("//a[@class='ico-account']");



    //2. Constructor of the page class
    public  LoginPage(WebDriver driver){
        this.driver = driver;
    }





    //3. Page actions: features(behavior) of the page the form of methods:

    public void goToHomePage(){
        driver.navigate().to("https://localhost:44369/");
    }

    public void navigateToLoginPage(){
        driver.findElement(navigateToLogin).click();
    }

    public  void  goToLoginPage(){
//        driver.get("https://localhost:44369/login");

        driver.navigate().to("https://localhost:44369/login");
    }
    public String getLoginPageTitle(){
     return  driver.getTitle();
    }

//    public String getErr

    public boolean isForgotPwdLinkExist(){
       return driver.findElement(forgotPwdlink).isDisplayed();
    }


    public void enterUserName(String username){
        driver.findElement(emailId).sendKeys(username);

    }

    public void enterPassword(String pwd){
        driver.findElement(passwordByUser).sendKeys(pwd);

    }

    public String errorMessage(){
        return driver.findElement(getErrorMessage).getText();
    }

    public String errorMessage2(){
        return driver.findElement(getGetErrorMessage2).getText();
    }

    public void clickOnLogin(){
        driver.findElement(signInButton).click();
    }

    public void clickOnAccountPage(){
        driver.findElement(myAccountPage).click();
    }

    public AccountsPage doLogin(String un, String pwd){
        DriverFactory.getDriver().get("https://localhost:44369/login");
        System.out.println("Login with: "+ un + " and "+ pwd);
        driver.findElement(emailId).sendKeys(un);
        driver.findElement(passwordByUser).sendKeys(pwd);
        driver.findElement(signInButton).click();
        return new AccountsPage(driver);
    }
}
