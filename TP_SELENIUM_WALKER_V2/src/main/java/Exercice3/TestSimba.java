package Exercice3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestSimba {

    private static WebDriver webiDriverou;
    private static String startUrl;
    private static String nextUrl;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriverManager.chromedriver().setup();
        webiDriverou = new ChromeDriver();

    }
    @AfterAll
    static void TearDown(){
        webiDriverou.quit();
    }

    @Test
    public void testNextStageWithEmpty() {
        startUrl = "http://localhost:4200/create";
        webiDriverou.get(startUrl);
        SimbaPageObject simbaPage = new SimbaPageObject(webiDriverou);

        List<WebElement> myLinks = webiDriverou.findElements(new By.ByTagName("a"));
        WebElement button2 = null;
        // Check if input are empty
        boolean inStep1 = (simbaPage.getTitleInputString().trim().isEmpty()&&simbaPage.getPlaceInputString().trim().isEmpty()
                &&simbaPage.getDescriptionInputString().trim().isEmpty());
        for (WebElement theElementImcheckingBecauseIwantToCallItThisWayLolDontDecreaseMyMarkPlease : myLinks) {
            //System.out.println("");
            if (theElementImcheckingBecauseIwantToCallItThisWayLolDontDecreaseMyMarkPlease.getText().trim().contains("2")) {
                button2 = theElementImcheckingBecauseIwantToCallItThisWayLolDontDecreaseMyMarkPlease;
                theElementImcheckingBecauseIwantToCallItThisWayLolDontDecreaseMyMarkPlease.click();
                break;
            }
        }
        if (button2 != null && inStep1) {
            WebElement span2 = webiDriverou.findElement(By.xpath("//span[contains(text(), '2')]"));
            System.out.println(span2.getCssValue("background-color"));
            assertNotEquals("rgba(0, 123, 255, 1)", span2.getCssValue("background-color"));
        } else {
            fail("Inputs not empty");
        }
    }
}
