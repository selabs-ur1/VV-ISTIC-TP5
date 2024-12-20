package tp5.vv.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SimbaPageTest {

    public static void main(String[] args) {

        // Initialisation du WebDriver
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.get("http://localhost:4200");

        try {
            SimbaPoolPage pollPage = new SimbaPoolPage(driver);

            //Remplir le formulaire avec le nom et le mail
            driver.findElement(pollPage.nom).sendKeys("Jean Dupont");
            driver.findElement(pollPage.mail).sendKeys("jean.dupont@example.com");

            //Soumettre le formulaire
            driver.findElement(pollPage.submitButton).click();

            WebElement confirmation = driver.findElement(By.xpath("//p[contains(text(), 'Merci pour vos voeux')]"));
            assert confirmation.isDisplayed() : "Échec : le message de confirmation n'est pas affiché";

            System.out.println("Test réussi : Le formulaire a été soumis avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Test échoué : Un problème est survenu lors de la soumission du formulaire.");
        } finally {
            // Fermer le navigateur
            driver.quit();
        }
    }
}
