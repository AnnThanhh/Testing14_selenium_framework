package Pages;

import Base.BasePage;
import Constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private By byInputUserName = By.id("taiKhoan");
    private By byInputPassword = By.id("matKhau");
    private By btnClickLogin = By.xpath("//button[@type=\"submit\"]");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //các phương thức tương tác với page (hành vi của lớp đối tượng)
    public void inputLoginUserName(String username){
        inputLoginUserName(username, TimeOutConstant.TIME_OUT_DEFAULT);
    }
    public void inputLoginUserName(String username, long timeOutInSec){
        inputText(byInputUserName, username, timeOutInSec);
    }

    public void inputLoginPassword (String password){
        inputLoginPassword(password, TimeOutConstant.TIME_OUT_DEFAULT);
    }
    public void inputLoginPassword (String password, long timeOutInSec){
        inputText(byInputPassword, password, timeOutInSec);
    }

    public void clickBtnLogin (){
        clickBtnLogin(TimeOutConstant.TIME_OUT_DEFAULT);
    }
    public void clickBtnLogin (long timeOutInSec){
        clickBtn(btnClickLogin, timeOutInSec);
    }
}
