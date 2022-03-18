import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class InformationPage {

    WebDriver driver;

    public InformationPage(WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getTitle() {
        return driver.findElement(By.id("titre")).getAttribute("value");
    }
    public void setTitle(String value) {
        driver.findElement(By.id("titre")).sendKeys(value);
    }
    public String getPlace() {
        return driver.findElement(By.id("lieu")).getAttribute("value");
    }
    public void setPlace(String value) {
        driver.findElement(By.id("lieu")).sendKeys(value);
    }
    public String getDescription() {
        return driver.findElement(By.id("desc")).getAttribute("value");
    }
    public void setDescription(String value) {
        driver.findElement(By.id("desc")).sendKeys(value);
    }
    public boolean getMeal() {
        String value = driver.findElement(By.xpath("//input[@aria-labelledby='repas']")).getAttribute("aria-checked");
        return value.compareTo("True") == 0;
    }
    public void setMeal(boolean value) {
        if(value && !driver.findElement(By.id("repas")).isSelected()){
            driver.findElement(By.id("repas")).click();
        }
        if(!value && driver.findElement(By.id("repas")).isSelected()){
            driver.findElement(By.id("repas")).click();
        }

    }
    public InformationPage clickOnNext(){
        driver.findElement(By.cssSelector("p-button[label=Next]")).click();
        return this;
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","tpSelenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080");
        driver.findElement(By.className("Home_CreateLink")).click();

        InformationPage page = new InformationPage(driver);

        page.setMeal(true);

        synchronized (driver){
            driver.wait(1000);
        }

        System.out.println("1 "+page.getMeal());
        /*System.out.println("2 "+element.getText());*/
        driver.quit();
    }

}
