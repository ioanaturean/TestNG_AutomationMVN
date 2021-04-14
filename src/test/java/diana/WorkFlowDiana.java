package diana;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webpages.LoginPage;

import java.util.concurrent.TimeUnit;

public class WorkFlowDiana {
    WebDriver driver;
    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

//    @After
//    public void close() {
//        driver.close();
//    }

    @Test
    public void Login() {
        //Create object of HomePage
        LoginPage loginPage = new LoginPage(driver);

        //Fill up Data
        loginPage.setUserEmail("opensourcecms");
        loginPage.setUserPassword("opensourcecms");
        loginPage.clickLogin();
        //Check if page is opened
        Assert.assertTrue(loginPage.isPageOpened());
    }

    @Test
    public void addAReport(){
        //Create object of HomePage
        LoginPage loginPage = new LoginPage(driver);
        //Fill up Data
        loginPage.setUserEmail("opensourcecms");
        loginPage.setUserPassword("opensourcecms");
        loginPage.clickLogin();
        //Check if page is opened
        Assert.assertTrue(loginPage.isPageOpened());
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //Add Pay Grade from Admin Page
        Admin adm = new Admin(driver);
        adm.addPayGrades();
        adm.addEducation();
        adm.addLanguage();
        adm.addSkill();
    }

}
