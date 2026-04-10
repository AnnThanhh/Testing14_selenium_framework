package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonDialog extends BasePage {
    private By titleDialog = By.id("swal2-title");
    private By btnCloseDialog = By.xpath("//button[text()=\"Đóng\"]");

    public CommonDialog (WebDriver driver){
        super(driver);
    }

    public String getTitleDialog(){
        return getTextElement(titleDialog);
    }

    public void clickBtnCloseDialog(){
        clickBtn(btnCloseDialog);
    }
}
