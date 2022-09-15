package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    @FindBy(xpath = "//nav[@class=\"header-bar_left\"]")
    WebElement listHeader;

    @FindBy(xpath = "//p[@class=\"section-content_descriptor\"]")
    WebElement mTitle;
    @FindBy(className = "section-content_logo")
    WebElement logoElement;
    @FindBy(id="btn-consultation-hero")
    public WebElement button;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean getLogoLink(String linkLogo) {
        return logoElement.getAttribute("xmlns").equals(linkLogo);
    }
    public String getButtonText(){
        return button.getText();
    }

    public String getMTitleText() {
        return mTitle.getText();
    }

    public List<String> checkHeaderTitles(List<String> stringList){
        List<WebElement> titleList=listHeader.findElements(By.tagName("a"));
        List<String> listNotEquals=new ArrayList<>();
        for(WebElement element:titleList){
            if(!stringList.contains(element.getText().replaceAll(" ",""))){
                listNotEquals.add(element.getText());
            }
        }
        return listNotEquals;
    }
}
