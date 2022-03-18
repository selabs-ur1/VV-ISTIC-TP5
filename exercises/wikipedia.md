# Random Wikipedia walker

Using Selenium, create a small program that, starting from the main page https://www.wikipedia.org/, walks trough a sequence of random links and takes a snapshot of the last page.
The process is as follows:

 1. Navigate to the main page https://www.wikipedia.org/
 2. Select a random link in the page
 3. Navigate to the link
 4. Repeat steps 2 to 3 until you have visited 10 different pages
 5. Take a snapshot of the current page and save it

Include the code of the walker and the snapshot in this document.

## Answer
 Test Selenium:
```java
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TestSelenium {

    private static WebDriver webDriver;
    private static Set<String> pageList;

    @BeforeEach
    public void setUp(){
        pageList = new HashSet<>();
        System.setProperty("webdriver.gecko.driver", "E:\\Bibliothèques\\Documents\\Cours\\V&V\\eckodriver-v0.30.0-win64\\geckodriver.exe");
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
        // Define browser resolution
        webDriver.manage().window().setSize(new Dimension(1024, 768));
    }

    @Test
    public void testSelenium(){
        // Open wikipedia
        String newUrl = "https://fr.wikipedia.org/";
        String lastUrl = "";
        webDriver.navigate().to(newUrl);

        // Random number
        Random rand = new Random();

        while (pageList.size() < 10){
            try{
                List<WebElement> allLinks = webDriver.findElements(By.tagName("a"));
                if(!allLinks.isEmpty()){
                    int randomNumber = rand.nextInt(allLinks.size() + 1);
                    WebElement randomElement = allLinks.get(randomNumber);
                    String url = randomElement.getAttribute("href");
                    randomElement.click();
                    pageList.add(url);
                    lastUrl = newUrl;
                    newUrl = url;
                }else{
                    webDriver.navigate().to(lastUrl);
                    newUrl = lastUrl;
                }
            }catch(ElementNotInteractableException e){
                System.out.println("Element not interactable");
            }
        }

        // Take screenshot
        File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("E:\\Bibliothèques\\Documents\\Cours\\V&V\\VV-ISTIC-TP5\\wikiscreen.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        webDriver.quit();
    }
}
```

Screenshot:
![](./wikiscreen.jpg)