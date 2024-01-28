package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AnswerPageTest {
    private AnswerPage answerPage;
    private WebDriver driver;
    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.get("http://localhost:4200/answer/LnujJwjqDnr5wJD35TKgboWE");
        this.answerPage = new AnswerPage(driver);
    }

    @After
    public void after() throws Exception {
        this.driver.quit();
    }

    @Test
    public void atTheStartCalendarVisible() {
        Assert.assertTrue(answerPage.isCalendarVisible());
    }

    @Test
    public void atTheStartTableauNotVisible() {
        Assert.assertFalse(answerPage.isTableVisible());
    }

    @Test
    public void calendarNotVisibleIfClickOnButtonVueTableau() {
        Assert.assertTrue(answerPage.isCalendarVisible());
        Assert.assertFalse(answerPage.isTableVisible());
        answerPage.clickButtonVueTableau();
        Assert.assertFalse(answerPage.isCalendarVisible());
        Assert.assertTrue(answerPage.isTableVisible());
        answerPage.clickButtonVueCalendrier();
        Assert.assertTrue(answerPage.isCalendarVisible());
        Assert.assertFalse(answerPage.isTableVisible());
    }

    @Test
    public void buttonVueCalendrierText() {
        Assert.assertEquals("Vue calendrier", answerPage.getButtonVueCalendrierText());
    }

    @Test
    public void buttonVueTableauText() {
        Assert.assertEquals("Vue tableau", answerPage.getButtonVueTableauText());
    }
}
