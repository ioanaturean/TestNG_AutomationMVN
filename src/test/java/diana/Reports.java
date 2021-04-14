package diana;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Reports {
    private WebDriver driver;
    private static String PAGE_URL = "https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login";

    @FindBy(id = "menu_pim_viewPimModule")
    WebElement pim;
    @FindBy(id = "menu_core_viewDefinedPredefinedReports")
    WebElement reports;
    @FindBy(id = "btnAdd")
    WebElement addButton;
    @FindBy(id = "report_report_name")
    WebElement inputReportName;
    @FindBy(id = "report_criteria_list")
    WebElement selectionCriteriaList;
    @FindBy(id = "btnAddConstraint")
    WebElement addSelectionCriteria;
    @FindBy(id = "report_include_comparision")
    WebElement includeSelectionCriteria;
    @FindBy(id = "employee_name_empName")
    WebElement inputEmployeeName;
    @FindBy(id = "report_pay_grade")
    WebElement payGrade;
    @FindBy(id = "report_employment_status")
    WebElement employeeStatus;
    @FindBy(id = "report_education")
    WebElement education;
    @FindBy(id = "service_period_comparision")
    WebElement servicePeriod;
    @FindBy(id = "joined_date_comparision")
    WebElement joinDate;
    @FindBy(id = "report_job_title")
    WebElement jobTitle;
    @FindBy(id = "report_language")
    WebElement language;
    @FindBy(id = "report_skill")
    WebElement skill;
    @FindBy(id = "age_group_comparision")
    WebElement ageGroup;
    @FindBy(id = "report_sub_unit")
    WebElement subUnit;
    @FindBy(id = "report_gender")
    WebElement gender;
    @FindBy(id = "location")
    WebElement location;
    @FindBy(id = "report_display_groups")
    WebElement displayFieldsdGroup;
    @FindBy(id = "btnAddDisplayGroup")
    WebElement addDisplayFieldsGroup;
    @FindBy(id = "report_display_field_list")
    WebElement displayFields;
    @FindBy(id = "btnAddDisplayField")
    WebElement addDisplayFields;
    @FindBy(id = "display_group_1")
    WebElement checkDisplay;
    @FindBy(id = "btnSave")
    WebElement saveButton;

    public Reports(WebDriver driver) {
        this.driver = driver;
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }



    public void addReport(){
        pim.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(reports);
        actions.click().build().perform();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        addButton.click();
        inputReportName.sendKeys("Report 1");
        selectionCriteriaList.click();
    }
}
