package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Users {
    private WebDriver driver;
    private  static String PAGE_URL = "https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/admin/viewSystemUsers";

    public Users(WebDriver driver){
        this.driver = driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id='menu_admin_viewAdminModule']")
    private WebElement admin;

    @FindBy(xpath = "//*[@id=\"menu_admin_UserManagement\"]")
    private WebElement userManagement;

    @FindBy(xpath = "//*[@id=\"menu_admin_viewSystemUsers\"]")
    private  WebElement users;

    @FindBy(xpath = "//*[@id=\"btnAdd\"]")
    private  WebElement AddBtn;


    @FindBy(xpath = "//*[@id=\"systemUser_userType\"]")
    private  WebElement UserRole;


    public void GoToUsers(){
        admin.click();
        userManagement.click();
        users.click();

    }
    public void AddNewUser(String username, String password){
        AddBtn.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        UserRole.sendKeys("Admin");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
