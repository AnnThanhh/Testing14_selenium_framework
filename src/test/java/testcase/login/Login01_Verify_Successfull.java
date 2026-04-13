package testcase.login;

import Base.BaseTest;
import Driver.DriverFactory;
import Pages.CommonDialog;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login01_Verify_Successfull extends BaseTest {
    @Test(description = "Verify that user can login successfully with valid credentials")
    public void testValidLogin() {
        String username = "testing141";
        String password = "Carson2309";

        WebDriver driver = DriverFactory.getDriverThreadLocal();
        driver.manage().window().maximize();
        driver.get("https://demo1.cybersoft.edu.vn/");

        //khởi tạo page
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CommonDialog commonDialog = new CommonDialog(driver);

        //truy cập vào login
        homePage.getNavbarComponent().NavigateToLoginPage();
        //nhập dữ liệu
        loginPage.inputLoginUserName(username);
        loginPage.inputLoginPassword(password);
        loginPage.clickBtnLogin();

        //VP1: kiểm tra đăng nhập thành công
        String recordMessageLogin = commonDialog.getTitleDialog();
        Assert.assertEquals(recordMessageLogin, "Đăng nhập thành công", "'Đăng Nhập Thành Công' message does not display !!!");
    }
}
