package andrei;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webpages.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by atpop on 13 Apr 2021
 */

public class WorkflowAndrei {

    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
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
    public void completeThreePayGrades() {
        Login();
        Job jobPage = new Job(driver);
        jobPage.goToPayGradesPage();
        jobPage.clickPayGradesAddButton();
        jobPage.setPayGradesName("Andrei");
        jobPage.clickPayGradesAddAssignedCurrency();
        jobPage.setAddCurrency("EUR - Euro", "1300", "2500");

        jobPage.goToPayGradesPage();
        jobPage.clickPayGradesAddButton();
        jobPage.setPayGradesName("Cristian");
        jobPage.clickPayGradesAddAssignedCurrency();
        jobPage.setAddCurrency("CAD - Canadian Dollar", "3000", "5000");

        jobPage.goToPayGradesPage();
        jobPage.clickPayGradesAddButton();
        jobPage.setPayGradesName("Vlad");
        jobPage.clickPayGradesAddAssignedCurrency();
        jobPage.setAddCurrency("GBP - Pound Sterling", "500", "1000");
    }

    @Test
    public void deleteOneCurrencyFromPayGrades() {
        Login();
        Job jobPage = new Job(driver);
        jobPage.goToPayGradesPage();
        jobPage.deleteCurrency();
    }

    @Test
    public void changeMaxSalary() {
        Login();
        Job jobPage = new Job(driver);
        jobPage.goToPayGradesPage();
        jobPage.editCurrency("7000");
    }
}
