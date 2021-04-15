package elena.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInScreen {
    @FindBy(xpath = "//*[@id='systemUser-information']/div[1]")
    private WebElement head;

    //Page URL
    private static String PAGE_URL = "https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login";

    //Locators
    @FindBy(xpath = "//*[@id=\"welcome\"]")
    private WebElement heading;

    @FindBy(id = "txtUsername")
    static
    WebElement userEmail;

    @FindBy(id = "txtPassword")
    static
    WebElement userPassword;

    @FindBy(id = "btnLogin")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id='systemUser-information']/div[1]/h1")
    WebElement systemUsers;


    public static void setUserEmail(String email) {
        userEmail.clear();
        userEmail.sendKeys(email);
    }

    public static void setUserPassword(String password) {
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
