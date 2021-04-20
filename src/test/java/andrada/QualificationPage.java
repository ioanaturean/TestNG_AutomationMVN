package andrada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QualificationPage {
    private WebDriver driver;
    //private static String PAGE_URL = "https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login";

    public QualificationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"menu_admin_viewAdminModule\"]/b")
    private WebElement adminButton;

    @FindBy(id="menu_admin_Qualifications")
    private WebElement qualificationButton;

    @FindBy(id="menu_admin_viewSkills")
    private WebElement skillsButton;

    @FindBy(id="menu_admin_viewEducation")
    private WebElement educationButton;

    @FindBy(id="menu_admin_viewLicenses")
    private WebElement licenseButton;

    @FindBy(id="menu_admin_viewLanguages")
    private WebElement languageButton;

    @FindBy(id="menu_admin_membership")
    private WebElement membershipButton;

    @FindBy(id = "btnAdd")
    private WebElement addButton;

    @FindBy(id = "btnDel")
    private WebElement deleteButton;

    @FindBy(id = "btnSave")
    private WebElement saveButton;

    @FindBy(id = "skill_name")
    private WebElement skillNameField;

    @FindBy(id="education_name")
    private WebElement educationField;

    @FindBy(id="license_name")
    private WebElement licenseField;

    @FindBy(id="language_name")
    private WebElement languageField;

    @FindBy(id="membership_name")
    private WebElement membershipField;

    public void selectQualificationFromAdminMeniu() {
        adminButton.click();
        qualificationButton.click();
    }

    public void addThreeSkill(String skill1,String skill2,String skill3) {
        skillsButton.click();
        addButton.click();
        skillNameField.sendKeys(skill1);
        saveButton.click();

        addButton.click();
        skillNameField.sendKeys(skill2);
        saveButton.click();

        addButton.click();
        skillNameField.sendKeys(skill3);
        saveButton.click();
    }
    public void addThreeEducation(String ed1,String ed2,String ed3){
        educationButton.click();
        addButton.click();
        educationField.sendKeys(ed1);
        saveButton.click();
        educationButton.click();

        addButton.click();
        educationField.sendKeys(ed2);
        saveButton.click();
        educationButton.click();

        addButton.click();
        educationField.sendKeys(ed3);
        saveButton.click();
    }
    public void addThreeLicense(String lic1,String lic2,String lic3){
        licenseButton.click();
        addButton.click();
        licenseField.sendKeys(lic1);
        saveButton.click();

        addButton.click();
        licenseField.sendKeys(lic2);
        saveButton.click();

        addButton.click();
        licenseField.sendKeys(lic3);
        saveButton.click();
    }
    public void addThreeLanguages(String lang1,String lang2,String lang3){
        languageButton.click();
        addButton.click();
        languageField.sendKeys(lang1);
        saveButton.click();

        addButton.click();
        languageField.sendKeys(lang2);
        saveButton.click();

        addButton.click();
        languageField.sendKeys(lang3);
        saveButton.click();
    }
    public void addThreeMembership(String memb1,String memb2,String memb3){
        membershipButton.click();
        addButton.click();
        membershipField.sendKeys(memb1);
        saveButton.click();

        addButton.click();
        membershipField.sendKeys(memb2);
        saveButton.click();

        addButton.click();
        membershipField.sendKeys(memb3);
        saveButton.click();
    }

    public void clickOnAddButton() {
        addButton.click();
    }

    public void clickOnDeleteButton() {
        deleteButton.click();
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }
}
