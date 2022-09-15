package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormConsult {
    @FindBy(id="form-consultation")
    WebElement form;

    @FindBy(id="input-name-consultation")
    WebElement nameElement;

    @FindBy(id="input-email-consultation")
    WebElement emailElement;

    @FindBy(id="input-tel-consultation")
    WebElement telElement;

    public boolean isEnabledForm(){
        return form.isEnabled();
    }

    public void sendTextToForm(String name, String email, String tel){
        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        telElement.sendKeys(tel);
    }


}
