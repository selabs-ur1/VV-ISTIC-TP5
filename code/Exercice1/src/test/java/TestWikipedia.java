import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.util.List;
import java.util.Random;

public class TestWikipedia {

    private WebDriver driver;
    private final long SLEEP_TIME = 1000;

    @Before
    public void setUp() {
        driver = new SafariDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void navigateThroughWikipedia() throws InterruptedException {
        // Home page of Wikipedia
        driver.get("https://www.wikipedia.org/");
        Thread.sleep(SLEEP_TIME);

        Random r = new Random();
        // Select a language
        List<WebElement> elements = driver.findElements(By.className("link-box"));
        elements.get(r.nextInt(elements.size())).click();
        Thread.sleep(SLEEP_TIME);

        // Navigate through href links of wikipedia
        for (int i = 0; i < 10; i++) {
            elements = driver.findElements(By.xpath("//a[contains(@href,'/wiki/')]"));
            try {
                elements.get(r.nextInt(elements.size())).click();
                Thread.sleep(SLEEP_TIME);
            } catch (Exception ignored) {}
        }

        // Screenshot of the last page
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("screenshot.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
