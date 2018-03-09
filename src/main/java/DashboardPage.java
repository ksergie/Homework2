import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class DashboardPage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By avatarIcon = By.className("employee_avatar_small");
    private By logoutLink = By.id("header_logout");
    private By catalogLink = By.id("subtab-AdminCatalog");
    private By categoriesLink = By.id("subtab-AdminCategories");
    private By createCategoryLink = By.id("page-header-desc-category-new_category");
    private By categoryNameField = By.id("name_1");
    private By categorySubmitButton = By.id("category_form_submit_btn");
    private By resultAddField = By.xpath("//div[@class='bootstrap']/div[starts-with(@class, 'alert')]");
    private By sortUpIcon = By.xpath("//span[@class='title_box active']//a[1]");
    private By myCategory = By.xpath("//td[contains(text(), 'My own category')]");

    public DashboardPage clickAvatarIcon(){
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(visibilityOfElementLocated(avatarIcon)).click();
        return this;
    }

    public DashboardPage moveToCatalog(){
        Actions actions = new Actions(driver);
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(visibilityOfElementLocated(catalogLink));
        WebElement catalog = driver.findElement(catalogLink);
        actions.moveToElement(catalog).build().perform();
        return this;
    }

    public DashboardPage clickCategoryLink(){
        driver.findElement(categoriesLink).click();
        return this;
    }

    public DashboardPage createNewCategory(){
        String categoryName = "My own category";
        driver.findElement(createCategoryLink).click();
        driver.findElement(categoryNameField).sendKeys(categoryName);
        driver.findElement(categorySubmitButton).click();
        return this;
    }

    public String getAddCategoryResult(){
        return driver.findElement(resultAddField).getText();
    }

    public DashboardPage clickSortCategories(){
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        driver.findElement(sortUpIcon).click();
        wait.until(visibilityOfElementLocated(myCategory));
        return this;
    }

    public void leavePage() {
        driver.findElement(logoutLink).click();
    }
}
