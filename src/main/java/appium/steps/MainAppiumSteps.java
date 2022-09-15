package appium.steps;

import appium.BaseAppiumSteps;
import appium.pages.QaAutomationPage;
import appium.util.AppiumUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainAppiumSteps extends BaseAppiumSteps {
    @When("^Open site \"([^\"]*)\"$")
    public void openSite(String url) throws Throwable {
        driver.get(url);
        Thread.sleep(5000);
    }

    @Then("^Get title$")
    public void getTitle() {
        System.out.println(driver.getTitle());
    }


    @Then("^Print list teachers$")
    public void printListTeachers() {
        By itList = By.id("swiper-coaches");
        AppiumUtil.scrollToElementVisibilityOf(driver, itList);
        QaAutomationPage.getListTeachers();
    }


}
