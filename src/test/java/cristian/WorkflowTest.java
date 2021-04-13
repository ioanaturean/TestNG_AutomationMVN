package cristian;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webpages.LoginPage;

import java.util.concurrent.TimeUnit;

public class WorkflowTest {
    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void close() {
        driver.close();
    }

    @Test
    public void Login() {
        //Create object of HomePage Class
        LoginPage loginPage = new LoginPage(driver);

        //Fill up data
        loginPage.setUserEmail("opensourcecms");
        loginPage.setUserPassword("opensourcecms");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isPageOpened()); //Check if page is opened
    }

    @Test
    public void deleteNationalities() throws InterruptedException {
        Login();

        Nationalities nationalities = new Nationalities(driver);
        nationalities.goToNationalitiesCategory();
        nationalities.deleteNationalitiesStartingWithA();
        Thread.sleep(3000);
    }

    @Test
    public void addNationalities() throws InterruptedException {
        Login();

        Nationalities nationalities = new Nationalities(driver);
        nationalities.goToNationalitiesCategory();
        nationalities.addThreeNewNationalities();
        //nationalities.waitForInvisibilityArabianNationality();
        Thread.sleep(3000);
    }
}
