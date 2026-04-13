package Driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    //race condition

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    //ThreadLocal: mỗi thread sẽ có một bản sao của biến này,
    //đảm bảo rằng mỗi thread sẽ có một instance riêng biệt của WebDriver, tránh xung đột khi nhiều thread cùng truy cập và sử dụng WebDriver.

    public static WebDriver getDriverThreadLocal(){
        return driverThreadLocal.get();
    }

    public static void setDriverThreadLocal(WebDriver driver){
        driverThreadLocal.set(driver);
    }

    public static void removeDriverThreadLocal(){
        driverThreadLocal.remove();
    }
}
