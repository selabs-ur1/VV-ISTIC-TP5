import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectModelSimba {

    private WebDriver driver;

    public PageObjectModelSimba(WebDriver driver) {
        this.driver = driver;
    }

    public void createPoll() {
        driver.findElement(By.xpath("/html/body/app-root/app-home-component/div/div/div[2]/a")).click();
    }

    public void buttonChoixDeLaDate() {
        driver.findElement(By.xpath("/html/body/app-root/app-create-poll-component/div/div[1]/p-steps/div/ul/li[2]/a/span[1]")).click();
    }

    public void buttonResume() {
        driver.findElement(By.xpath("/html/body/app-root/app-create-poll-component/div/div[1]/p-steps/div/ul/li[3]/a/span[1]")).click();
    }

    public void next() {
        driver.findElement(By.xpath("/html/body/app-root/app-create-poll-component/div/div[3]/p-card/div/div/div[2]/div/p-button[2]/button/span[2]")).click();
    }

}