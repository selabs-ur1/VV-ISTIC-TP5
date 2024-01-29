package fr.istic.ydewilde;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App {
    private static String SCREENSHOT_PATH = "./exo1_wikipedia_screenshot.png";

    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        String currentUrl = "https://www.wikipedia.org/";
        driver.get(currentUrl);
        System.out.println(driver.getTitle());

        for (int i = 0; i < 10; i++) {
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

            System.out.println("======= " + (i + 1) + " ==========");
            List<WebElement> links = driver.findElements(By.xpath("//a"));
            for (WebElement l : links) {
                System.out.println("Possible link\t" + l.getAttribute("href"));
            }
            WebElement nextLink = links.get((int) Math.floor(Math.random() * links.size()));
            currentUrl = nextLink.getAttribute("href");
            System.out.println("\n\n");
            // System.out.println(currentUrl + "\n" + nextLink.getAttribute("href"));
            System.out.println("Next link: " + currentUrl);
            driver.get(currentUrl);
        }

        System.out.println("===================\nLast page: " + currentUrl);

        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get(SCREENSHOT_PATH), screenshot);

        driver.quit();

        System.exit(0);
    }
}
