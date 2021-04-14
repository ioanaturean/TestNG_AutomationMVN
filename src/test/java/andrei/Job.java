package andrei;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by atpop on 13 Apr 2021
 */

public class Job {

    private WebDriver driver;

    public Job(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPayGradesPage() {
        Actions actions = new Actions(driver);
        WebElement adminButton = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b"));
        actions.moveToElement(adminButton);
        actions.click().build().perform();

        WebElement jobButton = driver.findElement(By.xpath("//*[@id=\"menu_admin_Job\"]"));
        actions.moveToElement(jobButton);

        WebElement payGradesButton = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewPayGrades\"]"));
        actions.moveToElement(payGradesButton);
        actions.click().build().perform();
    }

    public void clickPayGradesAddButton() {
        driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();
    }

    public void setPayGradesName(String name) {
        driver.findElement(By.id("payGrade_name")).sendKeys(name);
        driver.findElement(By.id("btnSave")).click();
    }

    public void clickPayGradesAddAssignedCurrency() {
        driver.findElement(By.id("btnAddCurrency")).click();
    }

    public void setAddCurrency(String currency, String minSalary, String maxSalary) {
        WebElement currencyName = driver.findElement(By.id("payGradeCurrency_currencyName"));
        currencyName.sendKeys(currency);

        WebElement payGradeMinSalary = driver.findElement(By.id("payGradeCurrency_minSalary"));
        payGradeMinSalary.sendKeys(minSalary);


        WebElement payGradeMaxSalary = driver.findElement(By.id("payGradeCurrency_maxSalary"));
        payGradeMaxSalary.sendKeys(maxSalary);

        driver.findElement(By.id("btnSaveCurrency")).click();
    }


    public void deleteCurrency() {
        driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[1]/td[2]/a")).click();
        driver.findElement(By.id("currencyCheckAll")).click();
        driver.findElement(By.id("btnDeleteCurrency")).click();
    }

    public void editCurrency(String maxSalary) {
        driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[2]/td[2]/a")).click();
        driver.findElement(By.xpath("//*[@id='tblCurrencies']/tbody/tr/td[2]/a")).click();

        WebElement payGradeMaxSalary = driver.findElement(By.id("payGradeCurrency_maxSalary"));
        payGradeMaxSalary.sendKeys(Keys.chord(Keys.CONTROL, "a"), "");
        payGradeMaxSalary.sendKeys(maxSalary);

        driver.findElement(By.id("btnSaveCurrency")).click();
    }
}
