package cristian;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public class Nationalities {
    public Nationalities(WebDriver driver) {
        this.driver = driver;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    private WebDriver driver;
    private static String PAGE_URL = "https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login";

    @FindBy(id = "menu_admin_viewAdminModule")
    private WebElement adminButton;
    @FindBy(id = "menu_admin_nationality")
    private WebElement nationalitiesButton;

    @FindBy(id = "ohrmList_chkSelectRecord_1")
    private WebElement nationalAfghan;
    @FindBy(id = "ohrmList_chkSelectRecord_2")
    private WebElement nationalAlbanian;
    @FindBy(id = "ohrmList_chkSelectRecord_3")
    private WebElement nationalAlgerian;
    @FindBy(id = "ohrmList_chkSelectRecord_4")
    private WebElement nationalAmerican;
    @FindBy(id = "ohrmList_chkSelectRecord_5")
    private WebElement nationalAndorran;
    @FindBy(id = "ohrmList_chkSelectRecord_6")
    private WebElement nationalAngolan;
    @FindBy(id = "ohrmList_chkSelectRecord_7")
    private WebElement nationalAntiguans;
    @FindBy(id = "ohrmList_chkSelectRecord_8")
    private WebElement nationalArgentinean;
    @FindBy(id = "ohrmList_chkSelectRecord_9")
    private WebElement nationalArmenian;
    @FindBy(id = "ohrmList_chkSelectRecord_10")
    private WebElement nationalAustralian;
    @FindBy(id = "ohrmList_chkSelectRecord_11")
    private WebElement nationalAustrian;
    @FindBy(id = "ohrmList_chkSelectRecord_12")
    private WebElement nationalAzerbaijani;

    @FindBy(id = "btnDelete")
    private WebElement deleteButton;
    @FindBy(id = "btnAdd")
    private WebElement addButton;

    @FindBy(xpath = "//*[@id=\"deleteConfModal\"]/div[2]")
    private WebElement deleteConfirmationRequired;
    @FindBy(id = "dialogDeleteBtn")
    private WebElement deleteDialogButton;

    @FindBy(id = "nationality_name")
    private WebElement nameNationalityField;
    @FindBy(id = "btnSave")
    private WebElement saveNationalityButton;

    @FindBy(xpath = "//*[@id=\"search-results\"]/div[2]")
    private WebElement nationalitiesList;


    public void goToNationalitiesCategory() {
        Actions action = new Actions(driver);
        action.moveToElement(adminButton).click(nationalitiesButton).build().perform();
    }

    public void deleteNationalitiesStartingWithA() {
        getNationalAfghan().click();
        getNationalAlbanian().click();
        getNationalAlgerian().click();
        getNationalAmerican().click();
        getNationalAndorran().click();
        getNationalAngolan().click();
        getNationalAntiguans().click();
        getNationalArgentinean().click();
        getNationalArmenian().click();
        getNationalAustralian().click();
        getNationalAustrian().click();
        getNationalAzerbaijani().click();
        getDeleteButton().click();
        getDeleteDialogButton().click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search-results\"]/div[1]")));

    }

    public void addThreeNewNationalities() {
        String nationality1 = "Bulgar";
        String nationality2 = "Ceh";
        String nationality3 = "Danez";
        getAddButton().click();
        getNameNationalityField().sendKeys(nationality1);
        getSaveNationalityButton().click();
        getAddButton().click();
        getNameNationalityField().sendKeys(nationality2);
        getSaveNationalityButton().click();
        getAddButton().click();
        getNameNationalityField().sendKeys(nationality3);
        getSaveNationalityButton().click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"frmList_ohrmListComponent\"]/script")));

    }

    public boolean checkIfNationalitiesExist() {
        String nationality = driver.findElement(By.xpath("//tbody/tr[1]//a")).getText();
        if (nationality.startsWith("A")) {
            return true;
        }
        return false;
    }

}


