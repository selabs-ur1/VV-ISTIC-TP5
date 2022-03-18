import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;

public class TestPageObjectModelSimba {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get("https://doodle.diverse-team.fr/answer/qtfTLgYx5wDLPN9LCiBrDwET"); // avec repas
        //driver.get("https://doodle.diverse-team.fr/answer/8HZtd9oxnEt3znPaR4pSafcD"); // sans repas
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testAjoutNomParticipant() {
        PageObjectModelSimba p = new PageObjectModelSimba(driver) ;
        p.nomParticipant("Floriane");
        // Screenshot of the last page
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/screenshots/screenshotNomParticipant.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testAjoutEmail() {
        PageObjectModelSimba p = new PageObjectModelSimba(driver) ;
        p.emailParticipant("Floriane@gmail.com");
        // Screenshot of the last page
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/screenshots/screenshotEmail.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAjoutCommentDescription() {
        PageObjectModelSimba p = new PageObjectModelSimba(driver) ;
        p.commentDescription("Ajout description");
        // Screenshot of the last page
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/screenshots/screenshotCommentaireDescription.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSoumettreVoeux() {
        PageObjectModelSimba p = new PageObjectModelSimba(driver) ;
        p.soumettreVoeux();
        // Screenshot of the last page
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/screenshots/screenshotSoumettreVoeux.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFluxICS() {
        PageObjectModelSimba p = new PageObjectModelSimba(driver) ;
        p.fluxICS();
        // Screenshot of the last page
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/screenshots/screenshotFluxICS.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFluxICSURL() {
        PageObjectModelSimba p = new PageObjectModelSimba(driver) ;
        p.fluxICS();
        p.fluxICSURL("test.com");
        // Screenshot of the last page
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/screenshots/screenshotFluxICSURL.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testComment() {
        PageObjectModelSimba p = new PageObjectModelSimba(driver) ;
        p.comment("Test ajout commentaire");
        // Screenshot of the last page
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/screenshots/screenshotCommentaireAuteur.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAjouterCommentaire() {
        PageObjectModelSimba p = new PageObjectModelSimba(driver) ;
        p.ajouterCommentaire();
        // Screenshot of the last page
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/screenshots/screenshotAjouterCommentaire.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testVueTableau() {
        PageObjectModelSimba p = new PageObjectModelSimba(driver) ;
        p.vueTableau();
        // Screenshot of the last page
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/screenshots/screenshotVueTableau.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testVueCalendrier() {
        PageObjectModelSimba p = new PageObjectModelSimba(driver) ;
        p.vueCalendrier();
        // Screenshot of the last page
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/screenshots/screenshotVueCalendrier.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testPreferencesAlimentaires() throws InterruptedException {
        PageObjectModelSimba p = new PageObjectModelSimba(driver) ;
        Thread.sleep(6000);
        p.preferencesAlimentaires();
        // Screenshot of the last page
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/screenshots/screenshotPreferencesAlimentaires.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testPreferencesAlimentairesDescription() throws InterruptedException {
        PageObjectModelSimba p = new PageObjectModelSimba(driver) ;
        Thread.sleep(4000);
        p.preferencesAlimentaires();
        p.preferencesAlimentairesDescription("Test preference alimentaire description");
        // Screenshot of the last page
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/screenshots/screenshotPreferencesAlimentaireDescription.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
