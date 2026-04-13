package testcase.register;

import Base.BaseTest;
import Driver.DriverFactory;
import ExtentReport.ExtentReportManager;
import Pages.CommonDialog;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class Register_01_Verify_Sucessfull extends BaseTest {
    //gõ snippet: test -> 1 annotation
    //assert -> hard assert và soft assert
    @Test(description = "Kiểm tra đăng ký thành công với dữ liệu hợp lệ")
    public void testValidRegister() {
        String account = UUID.randomUUID().toString();
        String email = account + "@gmail.com";

        WebDriver driver = DriverFactory.getDriverThreadLocal();
        driver.manage().window().maximize();

        //b2: truy cập vào https://demo1.cybersoft.edu.vn/
        ExtentReportManager.info("Truy cập vào trang https://demo1.cybersoft.edu.vn/");
        LOG.info("Truy cập vào trang https://demo1.cybersoft.edu.vn/");
        driver.get("https://demo1.cybersoft.edu.vn/");

        //khởi tạo page
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CommonDialog commonDialog = new CommonDialog(driver);
        ExtentReportManager.info("Truy cập vào trang đăng ký");
        LOG.info("Truy cập vào trang đăng ký");
        //đi vào trang đăng ký
        homePage.getNavbarComponent().NavigateToRegisterPage();

        //nhập dữ liệu vào form đăng ký
        ExtentReportManager.info("Nhập dữ liệu hợp lệ vào form đăng ký");
        ExtentReportManager.info("Nhập dữ liệu hợp lệ vào username: " + account);
        LOG.info("Nhập dữ liệu hợp lệ vào username: " + account);
        registerPage.inputUserName(account);

        ExtentReportManager.info("Nhập dữ liệu hợp lệ vào password: Cybersoft@123");
        LOG.info("Nhập dữ liệu hợp lệ vào password: Cybersoft@123");
        registerPage.inputPassword("Cybersoft@123", 5);

        ExtentReportManager.info("Nhập dữ liệu hợp lệ vào confirm password: Cybersoft@123");
        LOG.info("Nhập dữ liệu hợp lệ vào confirm password: Cybersoft@123");
        registerPage.inputConfirmPassword("Cybersoft@123", 5);

        ExtentReportManager.info("Nhập dữ liệu hợp lệ vào họ tên: Trịnh An Thành");
        LOG.info("Nhập dữ liệu hợp lệ vào họ tên: Trịnh An Thành");
        registerPage.inputHoTen("Trịnh An Thành", 8);

        ExtentReportManager.info("Nhập dữ liệu hợp lệ vào email: " + email);
        LOG.info("Nhập dữ liệu hợp lệ vào email: " + email);
        registerPage.inputEmail(email, 10);

        ExtentReportManager.info("Nhấn vào nút đăng ký");
        LOG.info("Nhấn vào nút đăng ký");
        registerPage.clickBtnRegister(10);

        //VP1 (verfy point 1): kiểm tra đăng ký thành công:
        ExtentReportManager.info("VP1: Kiểm tra đăng ký thành công với message hiển thị trên dialog");
        LOG.info("VP1: Kiểm tra đăng ký thành công với message hiển thị trên dialog");
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
        ExtentReportManager.info("VP2: Kiểm tra đăng nhập thành công sau khi đăng ký với message hiển thị trên dialog");
        LOG.info("VP2: Kiểm tra đăng nhập thành công sau khi đăng ký với message hiển thị trên dialog");
        homePage.getNavbarComponent().NavigateToLoginPage();

        //nhập dữ liệu vào form login
        ExtentReportManager.info("Nhập dữ liệu hợp lệ vào form đăng nhập");
        LOG.info("Nhập dữ liệu hợp lệ vào form đăng nhập");
        loginPage.inputLoginUserName(account);
        loginPage.inputLoginPassword("Cybersoft@123");
        loginPage.clickBtnLogin();

        String recordLoginMessage = commonDialog.getTitleDialog();
        Assert.assertEquals(recordLoginMessage, "Đăng nhập thành công!", "VP2: Đăng nhập thành công - MESSAGE DOES NOT MATCH");
    }

//    @Test (description = "Kiểm tra đăng ký thất bại với dữ liệu không hợp lệ")
//    public void testInvalidRegister() {
//        //test case đăng ký thất bại
//    }

}
