package Pages;

import Constants.TimeOutConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends CommonPage {
    //các locator của page (thuộc tính của lớp đối tượng)
    private By byInputUserName = By.id("taiKhoan");
    private By byInputPassword = By.id("matKhau");
    private By byConfirmPassword = By.id("confirmPassWord");
    private By byInputHoTen = By.id("hoTen");
    private By byInputEmail = By.id("email");
    private By btnClickRegister = By.xpath("//button[@type=\"submit\"]");

    private WebDriver driver;

    //constructor khởi tạo
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //các phương thức tương tác với page (hành vi của lớp đối tượng)
    public void inputUserName (String username){
        inputUserName(username, TimeOutConstant.TIME_OUT_DEFAULT);
    }
    public void inputUserName (String username, long timeOutInSec){
        inputText(byInputUserName, username, timeOutInSec);
    }

    public void inputPassword (String password){
        inputPassword(password, TimeOutConstant.TIME_OUT_DEFAULT);
    }
    public void inputPassword (String password, long timeOutInSec){
        inputText(byInputPassword, password, timeOutInSec);
    }

    public void inputConfirmPassword (String confirmPassword){
        inputConfirmPassword(confirmPassword, TimeOutConstant.TIME_OUT_DEFAULT);
    }
    public void inputConfirmPassword (String confirmPassword, long timeOutInSec){
        inputText(byConfirmPassword, confirmPassword, timeOutInSec);
    }

    public void inputHoTen (String hoTen){
        inputHoTen(hoTen, TimeOutConstant.TIME_OUT_DEFAULT);
    }
    public void inputHoTen (String hoTen, long timeOutInSec){
        inputText(byInputHoTen, hoTen, timeOutInSec);
    }

    public void inputEmail (String email){
        inputEmail(email, TimeOutConstant.TIME_OUT_DEFAULT);
    }
    public void inputEmail (String email, long timeOutInSec){
        inputText(byInputEmail, email, timeOutInSec);
    }

    public void clickBtnRegister (){
        clickBtnRegister(TimeOutConstant.TIME_OUT_DEFAULT);
    }
    public void clickBtnRegister (long timeOutInSec){
        clickBtn(btnClickRegister, timeOutInSec);
    }
}
