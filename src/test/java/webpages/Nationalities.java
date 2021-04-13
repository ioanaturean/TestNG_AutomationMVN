package webpages;

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
        WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        WebElement nationalities = driver.findElement(By.id("menu_admin_nationality"));
        action.moveToElement(admin).click(nationalities).build().perform();
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
    }
    public void addThreeNewNationalities(){
        String nationality1="African";
        String nationality2="Angolan";
        String nationality3="Arabian";
        getAddButton().click();
        getNameNationalityField().sendKeys(nationality1);
        getSaveNationalityButton().click();
        getAddButton().click();
        getNameNationalityField().sendKeys(nationality2);
        getSaveNationalityButton().click();
        getAddButton().click();
        getNameNationalityField().sendKeys(nationality3);
        getSaveNationalityButton().click();
    }

    public void waitForInvisibilityArabianNationality(){
        WebDriverWait wait=new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[3]")));
    }
}


