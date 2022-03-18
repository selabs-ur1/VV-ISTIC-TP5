import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectModelSimba {
    private WebDriver driver ;

    public PageObjectModelSimba(WebDriver driver){
        this.driver = driver ;
    }

    public void nomParticipant(String value) {
        driver.findElement(By.id("nom")).sendKeys(value);
    }
    public void emailParticipant(String value) {
        driver.findElement(By.id("mail")).sendKeys(value);
    }

    public void commentDescription(String value) {
        driver.findElement(By.id("commentdesc")).sendKeys(value);
    }
    public void soumettreVoeux() {
       driver.findElement(By.xpath("/html/body/app-root/app-answer-poll/div/p-card/div/div/div[3]/div[2]/div[6]/p-button/button")).click();
    }
    public void comment(String value) {
        driver.findElement(By.xpath("//*[@id=\"comment\"]")).sendKeys(value);
    }
    public void fluxICS() {
        driver.findElement(By.xpath("/html/body/app-root/app-answer-poll/div/p-card/div/div/div[3]/div[2]/div[3]/p-inputswitch/div/span")).click();
    }

    public void fluxICSURL(String value) {
        driver.findElement(By.xpath("//*[@id=\"ics\"]")).sendKeys(value);
    }
    public void ajouterCommentaire() {
        driver.findElement(By.xpath("/html/body/app-root/app-answer-poll/div/p-card/div/div/div[4]/div/div[3]/p-button/button")).click();
    }

    public void vueTableau() {
        driver.findElement(By.xpath("/html/body/app-root/app-answer-poll/div/p-card/div/div/div[3]/div[2]/div[4]/p-selectbutton/div/div[2]")).click();
    }
    public void vueCalendrier() {
        driver.findElement(By.xpath("/html/body/app-root/app-answer-poll/div/p-card/div/div/div[3]/div[2]/div[4]/p-selectbutton/div/div[1]")).click();
    }

    public void preferencesAlimentaires() {
        driver.findElement(By.xpath("/html/body/app-root/app-answer-poll/div/p-card/div/div/div[3]/div[2]/div[4]/p-inputswitch/div/span")).click();
    }
    public void preferencesAlimentairesDescription(String value) {
        driver.findElement(By.xpath("//*[@id=\"desc\"]")).sendKeys(value);
    }


}