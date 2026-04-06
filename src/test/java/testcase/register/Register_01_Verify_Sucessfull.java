package testcase.register;

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

        //b3: ấn vào nút đăng ký
        By byBtnRegister = By.xpath("//h3[text()=\"Đăng Ký\"]");
        WebElement btnRegister = wait.until(ExpectedConditions.elementToBeClickable(byBtnRegister));
        btnRegister.click();

        //b4: truy cập vào tài khoản và nhập dữ liệu
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputUserName(account);
        registerPage.inputPassword("Cybersoft@123");
        registerPage.inputConfirmPassword("Cybersoft@123");
        registerPage.inputHoTen("Trịnh An Thành");
        registerPage.inputEmail(email);
        registerPage.clickBtnRegister();

        //VP1 (verfy point 1): kiểm tra đăng ký thành công:
        By byLBLSuccess = By.id("swal2-title");
        WebElement lblSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(byLBLSuccess));
        String recordMesssage = lblSuccess.getText();
//        if(lblSuccess.getText().equals("Đăng ký thành công!")){
//            System.out.println("VP1: Đăng ký thành công - PASSED");
//        }else {
//            System.out.println("VP1: Đăng ký không thành công - FAILED");
//        }
        //khai báo hard assert
        //cú pháp: Assert.assertEquals(actual, expected, message)
        //actual: giá trị thực tế sau khi chạy test
        //expected: giá trị mong đợi (đã được định nghĩa trước)
        //message: thông báo khi test case thất bại (không bắt buộc)
        //THÀNH CÔNG
//        Assert.assertEquals(recordMesssage, "Đăng ký thành công", "VP1: Đăng ký thành công - MESSAGE DOES NOT MATCH");
        //THẤT BẠI
//        Assert.assertEquals(recordMesssage, "Đăng ký thành công!", "VP1: Đăng ký thành công! - MESSAGE DOES NOT MATCH");


        //SOFT ASSERT
        //khai báo soft assert lưu ý bắt buộc phải đóng ở cuối cùng để tổng hợp kết quả
        SoftAssert softAssert = new SoftAssert();
        //cú pháp: softAssert.assertEquals(actual, expected, message)
        //actual: giá trị thực tế sau khi chạy test
        //expected: giá trị mong đợi (đã được định nghĩa trước)
        //message: thông báo khi test case thất bại (không bắt buộc)
        softAssert.assertEquals(recordMesssage, "Đăng ký thành công", "VP1: Đăng ký thành công - MESSAGE DOES NOT MATCH");

        softAssert.assertAll();//quan trọng

        By byBtnClose = By.xpath("//button[text()=\"Đóng\"]");
        WebElement btnClose = wait.until(ExpectedConditions.elementToBeClickable(byBtnClose));
        btnClose.click();

        //VP2: Check login thành công sau khi đăng ký
        By byBtnLogin = By.xpath("//h3[text()=\"Đăng Nhập\"]");
        WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(byBtnLogin));
        btnLogin.click();

        By byInputTaikhoan = By.id("taiKhoan");
        WebElement inputTaikhoan = wait.until(ExpectedConditions.visibilityOfElementLocated(byInputTaikhoan));
        inputTaikhoan.sendKeys(account);

        By byInputMatKhau = By.id("matKhau");
        WebElement inputMatKhau = wait.until(ExpectedConditions.visibilityOfElementLocated(byInputMatKhau));
        inputMatKhau.sendKeys("Cybersoft@123");

        By byBtnLoginSubmit = By.xpath("//span[text()=\"Đăng nhập\"]");
        WebElement btnLoginSubmit = wait.until(ExpectedConditions.elementToBeClickable(byBtnLoginSubmit));
        btnLoginSubmit.click();

        By byLBLLoginSuccess = By.id("swal2-title");
        WebElement lblLoginSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(byLBLLoginSuccess));
        String recordLoginMessage = lblLoginSuccess.getText();
        //        if(lblLoginSuccess.getText().equals("Đăng nhập thành công")){
//            System.out.println("VP2: Đăng nhập thành công - PASSED");
//        }else {
//            System.out.println("VP2: Đăng nhập không thành công - FAILED");
//        }
        Assert.assertEquals(recordLoginMessage, "Đăng nhập thành công", "VP2: Đăng nhập thành công - MESSAGE DOES NOT MATCH");


        driver.quit();

    }

//    @Test (description = "Kiểm tra đăng ký thất bại với dữ liệu không hợp lệ")
//    public void testInvalidRegister() {
//        //test case đăng ký thất bại
//    }

}
