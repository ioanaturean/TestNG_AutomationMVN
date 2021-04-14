package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class dashBoard {
    private WebDriver driver;
    private static String PAGE_URL = "https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login";

    @FindBy(xpath = "//*[@id=\"menu_admin_viewAdminModule\"]")
    private WebElement admin;
    @FindBy(id = "btnAdd")
    private WebElement add;
    @FindBy(id = "systemUser_employeeName_empName")
    private WebElement employeeName;
    @FindBy(id = "systemUser_userName")
    private WebElement username;
    @FindBy(id = "systemUser_password")
    private WebElement password;
    @FindBy(id = "systemUser_confirmPassword")
    private WebElement confirmPass;
    @FindBy(id = "btnSave")
    private WebElement saveButton;

    public dashBoard(WebDriver driver) {
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
    public void completeUserDetails(){
        add.click();
        employeeName.clear();
        employeeName.sendKeys("opensourcecms opensourcecms");
        username.clear();
        username.sendKeys("Ioana");
        password.clear();
        password.sendKeys("Ioana45*");
        confirmPass.clear();
        confirmPass.sendKeys("Ioana45*");
        saveButton.click();
    }
}
