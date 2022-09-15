package appium.pages;

import appium.BaseAppiumSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;


public class QaAutomationPage extends BaseAppiumSteps {//HomeWork


    public QaAutomationPage(WebDriver driver) {
        PageFactory.initElements(driver, QaAutomationPage.class);
    }

    public static void getListTeachers() {
        WebElement element = driver.findElement(By.xpath("//div[contains(@class,'swiper-slider_pagination') and contains(@class, 'swiper-pagination-clickable') and contains(@class,'swiper-pagination-bullets') and contains(@class,'swiper-pagination-bullets-dynamic')]"));
        List<WebElement> list = element.findElements(By.tagName("span"));
        for (int i = 1; i < list.size(); i++) {
            try {
                list.get(i).click();
                List<WebElement> webElementList = driver.findElements(By.className("coach-card_group"));

                for (WebElement t : webElementList) {
                    String str = t.findElement(By.tagName("span")).getText();
                    if (!str.equals("")) {
                        System.out.println(str);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
