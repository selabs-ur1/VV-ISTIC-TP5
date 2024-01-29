package fr.istic.ydewilde.model;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CreatePollPage {
    private WebDriver driver;

    // pour tester si l'étape est un lien
    private By step1LinkBy;

    private By step2LinkBy;

    private By step3LinkBy;

    public CreatePollPage(WebDriver d) {
        driver = d;
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        step1LinkBy = By.xpath("/html/body/app-root/app-create-poll-component/div/div[1]/p-steps/div/ul/li[1]/a");
        step2LinkBy = By.xpath("/html/body/app-root/app-create-poll-component/div/div[1]/p-steps/div/ul/li[2]/a");
        step3LinkBy = By.xpath("/html/body/app-root/app-create-poll-component/div/div[1]/p-steps/div/ul/li[3]/a");
    }

    public boolean canGoToStep1() {
        try {
            driver.findElement(step1LinkBy);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean canGoToStep2() {
        try {
            driver.findElement(step2LinkBy);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean canGoToStep3() {
        try {
            driver.findElement(step3LinkBy);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Rest of the page...
}
