package raul;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobPage {
    private WebDriver driver;

    public JobPage(WebDriver driver) {
        this.driver = driver;
    }


    public void navigateToWorkShiftsPage(){
        Actions actions = new Actions(driver);
        WebElement adminButton = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]"));
        actions.moveToElement(adminButton);
        actions.click().build().perform();

        WebElement jobButton = driver.findElement(By.xpath("//*[@id=\"menu_admin_Job\"]"));
        actions.moveToElement(jobButton);

        WebElement workShiftsButton = driver.findElement(By.xpath("//*[@id=\"menu_admin_workShift\"]"));
        actions.moveToElement(workShiftsButton);
        actions.click().build().perform();
    }

    public void clickAddShiftButton(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='btnAdd']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnAdd']")));
        driver.findElement(By.xpath("//*[@id='btnAdd']")).click();
    }

    public void setShiftName(String expectedShiftName){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("workShift_name")));
        driver.findElement(By.id("workShift_name")).sendKeys(expectedShiftName);

    }

    public void selectHoursFrom(String expectedHours){
        Select hoursFrom = new Select(driver.findElement(By.id("workShift_workHours_from")));
        hoursFrom.selectByValue(expectedHours);
    }

    public void selectHoursTo(String expectedHours){
        Select hoursTo = new Select(driver.findElement(By.id("workShift_workHours_to")));
        hoursTo.selectByValue(expectedHours);
    }

    public void clickAvailableEmployee(){
        Select availableEmployee = new Select(driver.findElement(By.name("workShift[availableEmp][]")));
        availableEmployee.selectByValue("1");
    }

    public void clickAssignEmployee(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAssignEmployee")));
        driver.findElement(By.id("btnAssignEmployee")).click();
    }

    public void clickSaveButton(){
        driver.findElement(By.id("btnSave")).click();
    }

    public void checkAddFunction(String expectedName){
        String temp = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]/a")).getText();
        Assert.assertTrue(temp.equals(expectedName));
    }

    public void clickExistingWorkShift(){
        driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]/a")).click();
    }

    public void editShiftName(String expectedShiftName){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("workShift_name")));
        driver.findElement(By.id("workShift_name")).clear();
        driver.findElement(By.id("workShift_name")).sendKeys(expectedShiftName);
    }

    public void deleteShift(){
        driver.findElement(By.xpath("//*[@class=\"odd\"]/td/input")).click();
        driver.findElement(By.id("btnDelete")).click();

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialogDeleteBtn")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("dialogDeleteBtn")));
        driver.findElement(By.id("dialogDeleteBtn")).click();
    }

    public void checkIfElementWasDeleted(){
        String temp = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td")).getText();
        Assert.assertTrue(temp.equals("No Records Found"));
    }

}
