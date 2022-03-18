import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ResumePage {

    WebDriver driver;

    public ResumePage(WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Participation link
    // Admin link
    // discussion link
    // pad link
    public String getParticipationLink(){
        return driver.findElements(By.xpath("//a[@class='ng-star-inserted']")).get(0).getText();
    }
    public String getAdminLink(){
        return driver.findElements(By.xpath("//a[@class='ng-star-inserted']")).get(1).getText();
    }
    public String getDiscussionLink(){
        return driver.findElements(By.xpath("//a[@class='ng-star-inserted']")).get(2).getText();
    }
    public String getPadLink(){
        return driver.findElement(By.xpath("//span[@class='ng-star-inserted']/a")).getText();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","tpSelenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:80");
        driver.findElement(By.className("Home_CreateLink")).click();

        InformationPage infoPage = new InformationPage(driver);
        ResumePage resumePage = new ResumePage(driver);

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
        synchronized (driver){
            driver.wait(1000);
        }

        // Because "driver.findElement(By.cssSelector("p-button[label=Next]")).click();" not working for date choice page :)
        driver.findElement(By.cssSelector(".p-card-footer:nth-child(2) .float-right > .p-button")).click();

        synchronized (driver){
            driver.wait(1000);
        }


        System.out.println(resumePage.getDiscussionLink());
        System.out.println(resumePage.getAdminLink());
        System.out.println(resumePage.getParticipationLink());
        System.out.println(resumePage.getPadLink());


        synchronized (driver){
            driver.wait(1000);
        }

        /*System.out.println("2 "+element.getText());*/
        driver.quit();
    }

}
