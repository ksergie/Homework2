import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class MyTests {
    public static void main(String[] args) {

        WebDriver driver = initChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        String userEmail = "webinar.test@gmail.com";
        String userPasswd = "Xcg7299bnSmMuRLp9ITw";

        loginPage.open();
        loginPage.typeEmail(userEmail);
        loginPage.typePasswd(userPasswd);
        loginPage.clickSubmit();
        dashboardPage.moveToCatalog();
        dashboardPage.clickCategoryLink();
        dashboardPage.createNewCategory();
        if (dashboardPage.getAddCategoryResult().contains("Создано")){
            System.out.println("New Category creates success!");
        } else {
            System.out.println("New Category DID NOT create!");
        }
        dashboardPage.clickSortCategories();
        dashboardPage.clickAvatarIcon();
        dashboardPage.leavePage();

        driver.quit();
    }


    public static WebDriver initChromeDriver(){
        System.setProperty("webdriver.chrome.driver", MyTests.class.getResource("chromedriver.exe").getFile());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        EventFiringWebDriver driver = new EventFiringWebDriver(new ChromeDriver(options));
        return driver.register(new EventHandler());
    }
}
