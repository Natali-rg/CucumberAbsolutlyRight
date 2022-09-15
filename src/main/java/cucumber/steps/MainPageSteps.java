package cucumber.steps;

import cucumber.BaseCucumber;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.FormConsult;
import pages.MainPage;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainPageSteps extends BaseCucumber {
    static MainPage mainPage=null;
    static final String mainURL="https://dnipro.ithillel.ua/";

    @When("^I open site \"([^\"]*)\"$")
    public void iOpenSite(String siteURL) throws Throwable {
        driver.get(siteURL);
        switch (siteURL){
            case mainURL:
                mainPage=new MainPage(driver);
                break;
        }
    }

    @Then("^Text description button must equals \"([^\"]*)\"$")
    public void textDescriptionButtonMustEquals(String mExTitle) throws Throwable {
        Assert.assertEquals(mainPage.getMTitleText(), mExTitle);
    }

    @Then("^Check titles on buttons$")
    public void checkTitlesOnButtons(List<String> list) {
        System.out.println(mainPage.checkHeaderTitles(list));
    }

    @And("^Click button consultation$")
    public void clickButtonConsultation() {
        mainPage.button.click();
    }

    @And("^Sent text$")
    public void sentText(DataTable dataTable) {
        FormConsult formConsult= PageFactory.initElements(driver,FormConsult.class);
        List<Map<String,String>> table=dataTable.asMaps(String.class,String.class);
        int i=new Random().nextInt(table.size());
        formConsult.sendTextToForm(table.get(i).get("Name"),table.get(i).get("email"),table.get(i).get("telephone"));
    }

    @Then("^Sleep$")
    public void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @And("^Send \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void send(String name, String email, String tel) throws Throwable {
        FormConsult formConsult= PageFactory.initElements(driver,FormConsult.class);
        formConsult.sendTextToForm(name,email,tel);
    }
}
