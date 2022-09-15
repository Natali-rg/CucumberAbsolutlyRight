package cucumber.steps;

import cucumber.BaseCucumber;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.CertificatePage;

public class CerPageSteps extends BaseCucumber {

    CertificatePage certificatePage= PageFactory.initElements(driver,CertificatePage.class);

    @And("^Enter certificate code \"([^\"]*)\"$")
    public void enterCertificateCode(String cer) throws Throwable {
        certificatePage.getResultCertificate(cer);
        Thread.sleep(2000);
    }

    @Then("^Check result$")
    public void checkResult() throws InterruptedException {
        Assert.assertNotEquals(certificatePage.getMessage(),"Сертифікат не знайдено");

    }

}
