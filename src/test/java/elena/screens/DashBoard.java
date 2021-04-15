package elena.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DashBoard {
    private WebDriver driver;
    private static String PAGE_URL = "https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login";

    @FindBy(xpath = "//*[@id='menu_admin_viewAdminModule']")
    private WebElement admin;
    @FindBy(id = "btnAdd")
    private static WebElement add;
    @FindBy(id = "systemUser_employeeName_empName")
    private static WebElement employeeName;
    @FindBy(id = "systemUser_userName")
    private static WebElement username;
    @FindBy(id = "systemUser_password")
    private static WebElement password;
    @FindBy(id = "systemUser_confirmPassword")
    private static WebElement confirmPass;
    @FindBy(id = "btnSave")
    private static WebElement saveButton;
    @FindBy(xpath = "//*[@id='systemUser-information']/div[1]")
    private WebElement head;


    public DashBoard(WebDriver driver) {
        this.driver = driver;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }


    public void goToAddUserPage(){
        Actions actions = new Actions(driver);
        WebElement admin = driver.findElement(By.xpath("//*[@class='menu']/ul/li/a"));
        actions.moveToElement(admin);
        actions.click().build().perform();
        WebElement userManagment = driver.findElement(By.xpath("//*[@class='selected']/a"));
        actions.moveToElement(userManagment);
        WebElement usersButton = driver.findElement(By.xpath("//*[@class='selected']/ul/li/a"));
        actions.moveToElement(usersButton);
        actions.click().build().perform();
    }
    public static void completeUser1Details(){
        add.click();
        employeeName.clear();
        employeeName.sendKeys("opensourcecms opensourcecms");
        username.clear();
        username.sendKeys("Mihai");
        password.clear();
        password.sendKeys("Password1*");
        confirmPass.clear();
        confirmPass.sendKeys("Password1*");
        saveButton.click();
    }

    public boolean isPageOpen() {
        return head.getText().contains("System Users");
    }


    public static void completeUser2Details(){
        add.click();
        DashBoard.employeeName.clear();
        employeeName.sendKeys("opensourcecms opensourcecms");
        username.clear();
        username.sendKeys("Marcel");
        password.clear();
        password.sendKeys("Password1*");
        confirmPass.clear();
        confirmPass.sendKeys("Password1*");
        saveButton.click();
    }

    public static void completeUser3Details(){
        add.click();
        DashBoard.employeeName.clear();
        employeeName.sendKeys("opensourcecms opensourcecms");
        username.clear();
        username.sendKeys("Ariana");
        password.clear();
        password.sendKeys("Password1*");
        confirmPass.clear();
        confirmPass.sendKeys("Password1*");
        saveButton.click();

    }


}
