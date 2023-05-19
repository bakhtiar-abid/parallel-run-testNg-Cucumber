package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;


    private By navigateToRegPage =By.xpath("//a[normalize-space()='Register']");

    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");

    private By email = By.id("Email");

    private By emailError = By.id("Email-error");
    private By phoneNumber = By.id("Phone");

    private By faxNumber = By.id("Fax");

    private By passWord = By.id("Password");

    private By confirmPass = By.id("ConfirmPassword");

    private By buttonClick = By.id("register-button");

    private By fieldValidation = By.xpath("//span[@class='field-validation-error']");

    private By passWordError = By.id("Password-error");

    private By confirmPassWordError = By.id("ConfirmPassword-error");

    private By existError = By.xpath("//li[normalize-space()='The specified email already exists']");

    private By successMessage = By.xpath("//div[@class='result']");






   // Defining Constructor
   //2. Constructor of the page class
   public  RegistrationPage(WebDriver driver){
       this.driver = driver;
   }


    //Defining Methods

    public  void  goToRegPage(){
//        driver.get("https://localhost:44369/login");

        driver.navigate().to("https://localhost:44369/register");
    }
    public void navigateToRegistrationPage(){
        driver.navigate().to("https://localhost:44369");
        driver.findElement(navigateToRegPage).click();
    }


    public  void setFirstName(String fstName){
       driver.findElement(firstName).sendKeys(fstName);
    }
    public void setLastName(String lsName){
       driver.findElement(lastName).sendKeys(lsName);
    }

    public void setEmail(String emailID){
       driver.findElement(email).sendKeys(emailID);
    }

    public String setEmailError(){
     return  driver.findElement(emailError).getText();
    }
    public void setPhoneNumber(String phnNum){
       driver.findElement(phoneNumber).sendKeys(phnNum);
    }

    public void setFaxNumber(String faxNum){
        driver.findElement(faxNumber).sendKeys(faxNum);
    }

    public void setPassWord(String pssWrd){
       driver.findElement(passWord).sendKeys(pssWrd);
    }

    public void setConfirmPassWord(String cnfPassWord){
        driver.findElement(confirmPass).sendKeys(cnfPassWord);
    }

    public void setButtonClick(){
       driver.findElement(buttonClick).click();
    }

    public String errorValidation(){
       return driver.findElement(fieldValidation).getText();
    }

    public String setPasswordError(){
        return driver.findElement(passWordError).getText();
    }

    public String setConfirmPassError(){
        return driver.findElement(confirmPassWordError).getText();
    }

    public String setExistUserError(){
        return driver.findElement(existError).getText();
    }

    public String setSuccessMessage(){
        return driver.findElement(successMessage).getText();
    }
}
