import cucumber.BaseCucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import driverConfig.BROWSER;
import driverConfig.DriverFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/cucumber/features",
        glue = "cucumber.steps",
        tags = "@TestCertificate",
        dryRun = false,
        strict = false,
        snippets = SnippetType.UNDERSCORE)

public class RunnerCucumber {


    @BeforeClass
    public static void start() {
        BaseCucumber.driver = DriverFactory.getDriver(BROWSER.CHROME);
    }

    @AfterClass
    public static void end(){
        BaseCucumber.driver.quit();
    }
}
