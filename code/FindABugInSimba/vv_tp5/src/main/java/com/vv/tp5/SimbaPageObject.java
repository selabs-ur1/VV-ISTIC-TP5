package com.vv.tp5;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimbaPageObject {

    private WebDriver driver;

    public SimbaPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public SimbaPageObject clickMenu() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.xpath("//span[text()=\"2\"]")).click();
        return this;
    }

    public SimbaPageObject clickNext() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = driver.findElement(
                By.xpath("//div[@class=\"stepsdemo-content ng-star-inserted\"]//p-button[@label=\"Next\"]"));
        System.out.println("\n\n\n>>> " + element);

        System.out.println(element.isDisplayed() + " " + element.isEnabled() + " " + element.getSize());
        // ((JavascriptExecutor)
        // driver).executeScript("arguments[0].scrollIntoView(true);", element);
        //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,900)", "");
        //new Actions(driver).moveToElement(element, 0, 0).click().build().perform();

        element.click();

        // /*WebElement element =
        // */wait.until(ExpectedConditions.elementToBeClickable(/*By.id("signupModalProductButton")));
        // driver.findElement(*/By.xpath("//div[@class=\"p-card-footer
        // ng-star-inserted\"]"/*"//p-button[@label=\"Next\"]"*/))).click();

        return this;
    }

    public boolean checkCurrentMenuOn3() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        WebElement we = driver.findElement(By.id(
                "//li[@class=\"p-element p-steps-item ng-star-inserted p-highlight p-steps-current\"]/a/span[text()=\"3\"]"));

        return we != null;
    }

}
