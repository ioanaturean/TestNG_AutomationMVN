package raul;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webpages.LoginPage;

import java.util.concurrent.TimeUnit;

public class WorkFlowRaul {
    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /*@After
    public void close() {
        driver.close();
    }*/

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
    public void addWorkShifts() {
        //log in to page
        Login();

        //navigate to work shifts page
        JobPage jobPage = new JobPage(driver);
        jobPage.navigateToWorkShiftsPage();

        //shift1
        jobPage.clickAddShiftButton();
        jobPage.setShiftName("First Shift");
        jobPage.selectHoursFrom("01:00");
        jobPage.selectHoursTo("14:00");
        jobPage.clickAvailableEmployee();
        jobPage.clickAssignEmployee();
        jobPage.clickSaveButton();
        jobPage.checkAddFunction("First Shift");
    }

    @Test
    public void editWorkShift() {
        //log in to page
        Login();

        //navigate to work shifts page
        JobPage jobPage = new JobPage(driver);
        jobPage.navigateToWorkShiftsPage();

        //edit work shift
        jobPage.clickExistingWorkShift();
        jobPage.editShiftName("Edited first shift");
        jobPage.selectHoursFrom("05:00");
        jobPage.selectHoursTo("17:00");
        jobPage.clickSaveButton();
        jobPage.checkAddFunction("Edited first shift");
    }

    @Test
    public void deleteWorkShift() {
        //log in to page
        Login();

        //navigate to work shifts page
        JobPage jobPage = new JobPage(driver);
        jobPage.navigateToWorkShiftsPage();

        //delete work shift
        jobPage.deleteShift();
        jobPage.checkIfElementWasDeleted();
    }
}
