package Base;

import Constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    //các thuộc tính
    protected WebDriver driver;
    //constructor khởi tạo
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    //phương thức
    public WebElement waitForElementVisible(By locator, long timeOutInSec){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(timeOutInSec));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }
    public WebElement waitForElementClickable(By locator, long timeOutInSec){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(timeOutInSec));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    public void inputText(By locator, String value, long timeOutInSec){;
        WebElement element = waitForElementVisible(locator, timeOutInSec);
        element.sendKeys(value);
    }
    public void inputText(By locator, String value){
        inputText(locator, value, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public void clickBtn (By locator, long timeOutInSec){
        WebElement element = waitForElementClickable(locator, timeOutInSec);
        element.click();
    }
    public void clickBtn (By locator){
        clickBtn(locator, TimeOutConstant.TIME_OUT_DEFAULT);
    }

    public String getTextElement(By locator, long timeOutInSec){
        WebElement element = waitForElementVisible(locator, timeOutInSec);
        return element.getText();
    }
    public String getTextElement(By locator){
        return getTextElement(locator, TimeOutConstant.TIME_OUT_DEFAULT);}
}
