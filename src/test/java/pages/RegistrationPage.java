package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Page Object for Registration Page
 */
public class RegistrationPage {
    WebDriver driver = new FirefoxDriver();

    private WebElement firstNameField = driver.findElement(By.id("first-name"));
    private WebElement lastNameField = driver.findElement(By.id("last-name"));
    private WebElement emailField = driver.findElement(By.id("join-email"));
    private WebElement passwordField = driver.findElement(By.id("join-password"));
    private WebElement joinNowButton = driver.findElement(By.className("btn btn-primary join-btn"));
    private WebElement alertText = driver.findElement(By.cssSelector(".uno-alert.error.hidden>p>strong"));

    public void open() {
        driver.get("https://www.linkedin.com/");
    }

    /**
     * Fill registration form
     * @param firstName - user First Name
     * @param lastName - user Last Name
     * @param email - user email
     * @param password - user password
     */
    public void fillRegistrationForm ( String firstName, String lastName, String email, String password) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    public void clickJoinNowButton (){
        joinNowButton.click();
    }

    public void fillAndSubmitRegistrationForm (String firstName, String lastName, String email, String password){
        fillRegistrationForm(firstName, lastName, email, password);
        clickJoinNowButton();
    }

    public String getAlertText () {
        return alertText.getText();
    }
}
