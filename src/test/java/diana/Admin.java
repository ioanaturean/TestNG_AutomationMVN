package diana;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin {
    private WebDriver driver;
    private static String PAGE_URL = "https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login";

    @FindBy(xpath = "//*[@class='menu']/ul/li/a")
    WebElement admin;
    @FindBy(id = "menu_admin_Job")
    WebElement adminJob;
    @FindBy(id = "menu_admin_viewPayGrades")
    WebElement adminPayGrades;
    @FindBy(id = "btnAdd")
    WebElement addButtonAdmin;
    @FindBy(id = "payGrade_name")
    WebElement inputNamePayG;
    @FindBy(id = "btnSave")
    WebElement saveButtonAdmin;
    @FindBy(id = "menu_admin_Qualifications")
    WebElement quantifications;
    @FindBy(id = "menu_admin_viewEducation")
    WebElement education;
    @FindBy(id = "education_name")
    WebElement inputEducation;
    @FindBy(id = "menu_admin_viewLanguages")
    WebElement language;
    @FindBy(id = "language_name")
    WebElement inputLanguage;
    @FindBy(id = "menu_admin_viewSkills")
    WebElement skills;
    @FindBy(id = "skill_name")
    WebElement inputSkillName;
    @FindBy(id = "skill_description")
    WebElement inputTextAreaSkill;


    public Admin(WebDriver driver) {
        this.driver = driver;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void addPayGrades(){
        Actions actions = new Actions(driver);
        WebElement admin = driver.findElement(By.xpath("//*[@class='menu']/ul/li/a"));
        actions.moveToElement(admin);
        actions.click().build().perform();
        actions.moveToElement(adminJob);
        actions.click().build().perform();
        adminJob.click();
        actions.moveToElement(adminPayGrades);
        actions.click().build().perform();
        addButtonAdmin.click();
        inputNamePayG.sendKeys("grade1");
        saveButtonAdmin.click();
    }

    public void addEducation(){
        Actions actions = new Actions(driver);
        WebElement admin = driver.findElement(By.xpath("//*[@class='menu']/ul/li/a"));
        actions.moveToElement(admin);
        actions.click().build().perform();
        quantifications.click();
        actions.moveToElement(education);
        actions.click().build().perform();
        addButtonAdmin.click();
        inputEducation.sendKeys("high school");
        saveButtonAdmin.click();
    }

    public void addLanguage(){
        Actions actions = new Actions(driver);
        WebElement admin = driver.findElement(By.xpath("//*[@class='menu']/ul/li/a"));
        actions.moveToElement(admin);
        actions.click().build().perform();
        quantifications.click();
        actions.moveToElement(language);
        actions.click().build().perform();
        addButtonAdmin.click();
        inputLanguage.sendKeys("english");
        saveButtonAdmin.click();
    }

    public void addSkill(){
        Actions actions = new Actions(driver);
        WebElement admin = driver.findElement(By.xpath("//*[@class='menu']/ul/li/a"));
        actions.moveToElement(admin);
        actions.click().build().perform();
        quantifications.click();
        actions.moveToElement(skills);
        actions.click().build().perform();
        addButtonAdmin.click();
        inputSkillName.sendKeys("communication");
        inputTextAreaSkill.sendKeys("performant");
        saveButtonAdmin.click();

    }
}
