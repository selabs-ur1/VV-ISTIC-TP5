package com.vv.tp5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        /*System.setProperty("webdriver.gecko.driver",
                "/home/etudiant/VV/geckoDriver/geckodriver-v0.35.0-linux64/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/home/etudiant/firefox/firefox-133.0.3/firefox/firefox");*/
        System.setProperty("webdriver.gecko.driver",
                "/home/ylaineodic/VV/geckoDriver/geckodriver-v0.35.0-linux64/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/home/ylaineodic/VV/firefox/firefox-133.0.3/firefox/firefox");
        WebDriver driver = new FirefoxDriver(options);
        //driver.manage().window().setSize(new Dimension(1080,1920));
        driver.get("http://localhost:4200/create");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        assertTrue(new SimbaPageObject(driver).clickMenu().clickNext().checkCurrentMenuOn3());
    }

    public static void main(String[] args) {
        new AppTest().testApp();
    }
}
