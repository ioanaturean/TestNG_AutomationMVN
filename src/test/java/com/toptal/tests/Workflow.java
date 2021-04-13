package com.toptal.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webpages.LoginPage;
import cristian.Nationalities;
import webpages.dashBoard;

import java.util.concurrent.TimeUnit;

public class Workflow {
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
    public void addUser() {
        //Create object of HomePage Class
        LoginPage loginPage = new LoginPage(driver);
        //Fill up data
        loginPage.setUserEmail("opensourcecms");
        loginPage.setUserPassword("opensourcecms");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isPageOpened()); //Check if page is opened
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        dashBoard dashb = new dashBoard(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        dashb.goToAddUserPage();
        dashb.completeUserDetails();
    }

}
