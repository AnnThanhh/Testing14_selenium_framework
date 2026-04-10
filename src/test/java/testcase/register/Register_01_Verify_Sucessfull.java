package testcase.register;

import Pages.CommonDialog;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.UUID;

public class Register_01_Verify_Sucessfull {
    //gõ snippet: test -> 1 annotation
    //assert -> hard assert và soft assert
    @Test(description = "Kiểm tra đăng ký thành công với dữ liệu hợp lệ")
    public void testValidRegister() {
        String account = UUID.randomUUID().toString();
        String email = account + "@gmail.com";

        //b1: khởi tạo chromeOption và chromeDriver
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //b2: truy cập vào https://demo1.cybersoft.edu.vn/
        driver.get("https://demo1.cybersoft.edu.vn/");

        //khởi tạo page
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CommonDialog commonDialog = new CommonDialog(driver);
        //đi vào trang đăng ký
        homePage.getNavbarComponent().NavigateToRegisterPage();

        //nhập dữ liệu vào form đăng ký
        registerPage.inputUserName(account);
        registerPage.inputPassword("Cybersoft@123", 5);
        registerPage.inputConfirmPassword("Cybersoft@123", 5);
        registerPage.inputHoTen("Trịnh An Thành", 8);
        registerPage.inputEmail(email, 10);
        registerPage.clickBtnRegister(10);

        //VP1 (verfy point 1): kiểm tra đăng ký thành công:

        String recordMesssageRegister = commonDialog.getTitleDialog();

        //khai báo hard assert
        //cú pháp: Assert.assertEquals(actual, expected, message)
        //actual: giá trị thực tế sau khi chạy test
        //expected: giá trị mong đợi (đã được định nghĩa trước)
        //message: thông báo khi test case thất bại (không bắt buộc)
        //THÀNH CÔNG
        Assert.assertEquals(recordMesssageRegister, "Đăng ký thành công", "VP1: Đăng ký thành công - MESSAGE DOES NOT MATCH");
        //THẤT BẠI
//        Assert.assertEquals(recordMesssage, "Đăng ký thành công!", "VP1: Đăng ký thành công! - MESSAGE DOES NOT MATCH");


        //SOFT ASSERT
        //khai báo soft assert lưu ý bắt buộc phải đóng ở cuối cùng để tổng hợp kết quả
//        SoftAssert softAssert = new SoftAssert();
        //cú pháp: softAssert.assertEquals(actual, expected, message)
        //actual: giá trị thực tế sau khi chạy test
        //expected: giá trị mong đợi (đã được định nghĩa trước)
        //message: thông báo khi test case thất bại (không bắt buộc)
//        softAssert.assertEquals(recordMesssage, "Đăng ký thành công", "VP1: Đăng ký thành công - MESSAGE DOES NOT MATCH");

//        softAssert.assertAll();//quan trọng

        commonDialog.clickBtnCloseDialog();

        //VP2: Check login thành công sau khi đăng ký
        homePage.getNavbarComponent().NavigateToLoginPage();

        //nhập dữ liệu vào form login
        loginPage.inputLoginUserName(account);
        loginPage.inputLoginPassword("Cybersoft@123");
        loginPage.clickBtnLogin();

        String recordLoginMessage = commonDialog.getTitleDialog();
        Assert.assertEquals(recordLoginMessage, "Đăng nhập thành công", "VP2: Đăng nhập thành công - MESSAGE DOES NOT MATCH");

        driver.quit();

    }

//    @Test (description = "Kiểm tra đăng ký thất bại với dữ liệu không hợp lệ")
//    public void testInvalidRegister() {
//        //test case đăng ký thất bại
//    }

}
