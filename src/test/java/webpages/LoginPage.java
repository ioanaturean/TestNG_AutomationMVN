package webpages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {
    private WebDriver driver;

    //Page URL
    private static String PAGE_URL = "https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login";

    //Locators
    @FindBy(xpath = "//*[@id=\"welcome\"]")
    private WebElement heading;

    @FindBy(id = "txtUsername")
    WebElement userEmail;

    @FindBy(id = "txtPassword")
    WebElement userPassword;

    @FindBy(id = "btnLogin")
    WebElement loginButton;

    //Constructor
    public LoginPage(WebDriver driver) {

        this.driver = driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void setUserEmail(String email) {
        userEmail.clear();
        userEmail.sendKeys(email);
    }

    public void setUserPassword(String password) {
        userPassword.clear();
        userPassword.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean isPageOpened() {
        return heading.getText().contains("Welcome");
    }
}
