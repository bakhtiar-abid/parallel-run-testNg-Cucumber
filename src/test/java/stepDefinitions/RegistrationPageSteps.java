package stepDefinitions;

import com.github.javafaker.Faker;
import com.pages.RegistrationPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class RegistrationPageSteps {


    Faker faker = new Faker();

//    String name = faker.name().fullName(); // Miss Samanta Schmidt
    String firstNamee = faker.name().firstName(); // Emory
    String lastNamee = faker.name().lastName(); // Barton


    private RegistrationPage registrationPage = new RegistrationPage(DriverFactory.getDriver());
    private static String errorMessage;
    @Given("user is on registration page")
    public void user_is_on_registration_page() {
        registrationPage.goToRegPage();
    }


    @When("user click on my registration page")
    public void user_click_on_my_registration_page() {
        registrationPage.navigateToRegistrationPage();
    }

    @Then("user enters first name as {string}")
    public void user_enters_first_name_as(String firstName) {
        firstName = firstNamee;
    registrationPage.setFirstName(firstName);
    }

    @Then("user enters last name {string}")
    public void user_enters_last_name(String lastName) {
        lastName = lastNamee;
        registrationPage.setLastName(lastName);
    }

    @Then("user enters email as {string}")
    public void user_enters_email_as(String emailAddress) {
        emailAddress = (firstNamee + lastNamee + "@gmail.com").toString();
        registrationPage.setEmail(emailAddress);
    }

    @Then("user enters wrong email as {string}")
    public void user_enters_wrong_email_as(String wrongEmailAddress) {
        registrationPage.setEmail(wrongEmailAddress);

    }

    @Then("user enters exist email as {string}")
    public void user_enters_exist_email_as(String existEmail) {
        registrationPage.setEmail(existEmail);
    }
    @Then("user enters phone number {string}")
    public void user_enters_phone_number(String phoneNumber) throws InterruptedException {
        Thread.sleep(1000);
        registrationPage.setPhoneNumber(phoneNumber);
    }

    @Then("user enters fax number {string}")
    public void user_enters_fax_number(String faxNum) throws InterruptedException {
        Thread.sleep(1000);
        registrationPage.setFaxNumber(faxNum);
    }

    @Then("user enters password for registration page {string}")
    public void user_enters_password_for_registration_page(String psswrd) throws InterruptedException {
        Thread.sleep(1000);
        registrationPage.setPassWord(psswrd);
    }

    @Then("user enters confirm password for registration page {string}")
    public void user_enters_confirm_password_for_registration_page(String cnfrmPass) throws InterruptedException {
        Thread.sleep(1000);
        registrationPage.setConfirmPassWord(cnfrmPass);
    }

    @Then("user click on registration button")
    public void user_click_on_registration_button() throws InterruptedException {
        Thread.sleep(5000);
        registrationPage.setButtonClick();
    }


    @Then("user see error message {string}")
    public void user_see_error_message(String exptdError) {
        errorMessage = registrationPage.errorValidation();
        Assert.assertTrue(errorMessage.contains(exptdError));
    }

    @Then("user see mismatch error message {string}")
    public void user_see_mismatch_error_message(String exptdError) {
        errorMessage = registrationPage.errorValidation().replace("\n","");
        Assert.assertTrue(errorMessage.contains(exptdError));
    }
    @Then("user see password error message {string}")
    public void user_see_password_error_message(String exptdPassErrMsg) {
        errorMessage = registrationPage.setPasswordError();
        Assert.assertTrue(errorMessage.contains(exptdPassErrMsg));
    }

    @Then("user see confirm password error message {string}")
    public void user_see_confirm_password_error_message(String exptdConfPassErr) {
        errorMessage = registrationPage.setConfirmPassError();
        Assert.assertTrue(errorMessage.contains(exptdConfPassErr));
    }


    @Then("user should see existing error message {string}")
    public void user_should_see_existing_error_message(String exptdExistError) {
        errorMessage = registrationPage.setExistUserError();
        Assert.assertTrue(errorMessage.contains(exptdExistError));
    }

    @Then("user should see success message as {string}")
    public void user_should_see_success_message_as(String successMessage) {
        errorMessage = registrationPage.setSuccessMessage();
        Assert.assertTrue(errorMessage.contains(successMessage));
    }







}
