import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.FormConsult;
import pages.MainPage;

public class TestMainPage extends Base{
    static final String MAIN_URL = "https://ithillel.ua/";
    static MainPage mainPage;

    @Before
    public void openMainPage() {
        if (!driver.getCurrentUrl().equals(MAIN_URL)) {
            driver.get(MAIN_URL);
        }
        if (mainPage == null) {
            mainPage = new MainPage(driver);
        }
    }
    @After
    public void nenuznuyMetod(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void logoTest() {
        Assert.assertTrue(mainPage.getLogoLink("http://www.w3.org/2000/svg"));
    }
    @Test
    public void aformEnabled() {
        mainPage.button.click();
        FormConsult formConsult= PageFactory.initElements(driver, FormConsult.class);
        Assert.assertTrue(formConsult.isEnabledForm());
        driver.navigate().refresh();
    }
    @Test
    public void textButtonTest(){
        Assert.assertEquals("kgkjgkjg",mainPage.getButtonText());
    }
}
