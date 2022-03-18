import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import static org.junit.Assert.assertNull;

public class TestPageObjectModelSimba {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get("https://doodle.diverse-team.fr");
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void testCreatePoll() throws InterruptedException {
        PageObjectModelSimba p = new PageObjectModelSimba(driver);
        p.createPoll();
        p.buttonResume();
        p.buttonChoixDeLaDate();
        p.next();
        Thread.sleep(1000);
        assertNull(driver.findElement(By.partialLinkText("https://doodle.diverse-team.fr/answer/")));
    }
}
