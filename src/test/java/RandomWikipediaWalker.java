import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RandomWikipediaWalker {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.wikipedia.org/");

        Actions action = new Actions(driver);
        PointerInput mouse = new PointerInput(PointerInput.Kind.MOUSE, "mouse");

        for (int i = 0; i < 10; i++) {
            List<WebElement> links = driver.findElements(By.tagName("a"));

            WebElement randomLink = getRandomElement(links);

            while (!randomLink.isDisplayed()) {
                randomLink = getRandomElement(links);
            }

            scrollToElement(driver, randomLink);

            action.click(randomLink).perform();
            System.out.println("Click on : " + randomLink.getAttribute("href"));

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Take a snapshot of the current page
        // You can use WebDriver's TakesScreenshot interface.
        takeSnapshot(driver, "last_page");

        driver.quit();
    }

    private static WebElement getRandomElement(List<WebElement> elements) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(elements.size());
        return elements.get(randomIndex);
    }

    private static void scrollToElement(WebDriver driver, WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void takeSnapshot(WebDriver driver, String fileName) {
         TakesScreenshot screenshot = (TakesScreenshot) driver;
         File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
         File destinationFile = new File("exercises/Snapshots/" + fileName + ".png");

         try {
             FileUtils.copyFile(sourceFile, destinationFile);
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
}
