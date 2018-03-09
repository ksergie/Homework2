import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class EventHandler extends AbstractWebDriverEventListener {
    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("We will open the " + url + " page.");
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("We opened the " + url + " page.");
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Should be " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Element found");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Should click " + element.getTagName());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked successfull");
    }


    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

    }
}
