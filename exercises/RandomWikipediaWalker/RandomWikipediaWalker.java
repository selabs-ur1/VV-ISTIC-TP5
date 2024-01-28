package org.example.RandomWikipediaWalker;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RandomWikipediaWalker {

    private void takeScreenShoot(WebDriver driver, int numberTitle) {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("/img/"+ numberTitle +".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String selectRandomLink(WebDriver driver){
        List<WebElement> allAnchorElements = driver.findElements(By.tagName("a"));
        List<WebElement> anchorElements = allAnchorElements
                .stream()
                .filter(webElement -> !Objects.equals(webElement.getAttribute("href"), ""))
                .toList();
        Random random = new Random();
        return anchorElements.get(random.nextInt(anchorElements.size()-1)).getAttribute("href");
    }


    public void startRandomWikipediaWalker(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://fr.wikipedia.org/wiki/Wikip%C3%A9dia:Accueil_principal");

        for(int i = 0; i < 10; i++) {
            driver.get(selectRandomLink(driver));
            takeScreenShoot(driver, i);
        }

        driver.quit();
    }


}
