package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
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
        this.driver = driver;
    }

    //các phương thức tương tác với page (hành vi của lớp đối tượng)
    public void inputUserName (String username){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        WebElement inputUserName = wait.until(ExpectedConditions.visibilityOfElementLocated(byInputUserName));
        inputUserName.sendKeys(username);
    }

    public void inputPassword (String password){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        WebElement inputPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(byInputPassword));
        inputPassword.sendKeys(password);
    }

    public void inputConfirmPassword (String confirmPassword){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        WebElement inputConfirmPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(byConfirmPassword));
        inputConfirmPassword.sendKeys(confirmPassword);
    }

    public void inputHoTen (String hoTen){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        WebElement inputHoTen = wait.until(ExpectedConditions.visibilityOfElementLocated(byInputHoTen));
        inputHoTen.sendKeys(hoTen);
    }

    public void inputEmail (String email){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        WebElement inputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(byInputEmail));
        inputEmail.sendKeys(email);
    }

    public void clickBtnRegister (){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        WebElement btnRegisterClick = wait.until(ExpectedConditions.elementToBeClickable(btnClickRegister));
        btnRegisterClick.click();
    }
}
