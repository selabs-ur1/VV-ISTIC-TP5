import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InformationPageTest {
    WebDriver driver;

    @BeforeEach
    void setUp(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
        driver.findElement(By.className("Home_CreateLink")).click();

    }
    @Test
    void testTitle() {
        InformationPage page = new InformationPage(driver);
        page.setTitle("Test title");
        assertEquals("Test title",page.getTitle());
    }
    @Test
    void testPlace() {
        InformationPage page = new InformationPage(driver);
        page.setPlace("Test place");
        assertEquals("Test place",page.getPlace());
    }
    @Test
    void testDescription()  {
        InformationPage page = new InformationPage(driver);
        page.setDescription("Test description");
        assertEquals("Test place",page.getDescription());
    }
    @Test
    void testMealTrue() throws InterruptedException {
        InformationPage page = new InformationPage(driver);
        page.setMeal(true);
        synchronized (driver){
            driver.wait(1000);
        }

        // NOT WORKING
        assertTrue(page.getMeal());
    }

    @AfterEach
    void quitDriver(){
        driver.quit();
    }
}
