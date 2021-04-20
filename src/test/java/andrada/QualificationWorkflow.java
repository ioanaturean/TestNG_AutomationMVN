package andrada;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webpages.LoginPage;

import java.util.concurrent.TimeUnit;

public class QualificationWorkflow {
    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void close() {
        driver.close();
    }

    @Test
    public void AddQualification() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserEmail("opensourcecms");
        loginPage.setUserPassword("opensourcecms");
        loginPage.clickLogin();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        QualificationPage qualificationPage = new QualificationPage(driver);

        qualificationPage.selectQualificationFromAdminMeniu();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        qualificationPage.addThreeSkill("skill1","skill2","skill3");

        qualificationPage.selectQualificationFromAdminMeniu();
        qualificationPage.addThreeEducation("education1","education2","education3");

        qualificationPage.selectQualificationFromAdminMeniu();
        qualificationPage.addThreeLicense("license1","license2","license3");

        qualificationPage.selectQualificationFromAdminMeniu();
        qualificationPage.addThreeLanguages("language1","language2","language3");

        qualificationPage.selectQualificationFromAdminMeniu();
        qualificationPage.addThreeMembership("membership1","membership2","membership3");
    }
}
