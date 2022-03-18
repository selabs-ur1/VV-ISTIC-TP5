import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

class ResumePageTest {
    WebDriver driver;

    @BeforeEach
    void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:80");
        driver.findElement(By.className("Home_CreateLink")).click();
        InformationPage infoPage = new InformationPage(driver);

        infoPage.setTitle("Titre");
        infoPage.setPlace("Ici");
        infoPage.setDescription("ici");

        synchronized (driver){
            driver.wait(1000);
        }

        driver.findElement(By.cssSelector("p-button[label=Next]")).click();


        synchronized (driver){
            driver.wait(1000);
        }
        // Because "driver.findElement(By.cssSelector("p-button[label=Next]")).click();" not working for date choice page :)
        driver.findElement(By.cssSelector(".p-card-footer:nth-child(2) .float-right > .p-button")).click();
        synchronized (driver){
            driver.wait(1000);
        }
    }

    @Test
    void testParticipationLink() throws InterruptedException {
        ResumePage page = new ResumePage(driver);
        System.out.println(page.getParticipationLink());
        driver.get(page.getParticipationLink());
        assertNotEquals("404 Not Found",driver.getTitle());
    }
    @Test
    void testAdminLink() {
        ResumePage page = new ResumePage(driver);
        driver.get(page.getAdminLink());
        assertNotEquals("404 Not Found",driver.getTitle());
    }
    @Test
    void testPadLink() {
        ResumePage page = new ResumePage(driver);
        driver.get(page.getPadLink());
        assertNotEquals("404 Not Found",driver.getTitle());
    }
    @Test
    void testDiscussionLink() {
        ResumePage page = new ResumePage(driver);
        driver.get(page.getDiscussionLink());
        assertNotEquals("404 Not Found",driver.getTitle());
    }

    @AfterEach
    void quitDriver(){
        driver.quit();
    }
}
