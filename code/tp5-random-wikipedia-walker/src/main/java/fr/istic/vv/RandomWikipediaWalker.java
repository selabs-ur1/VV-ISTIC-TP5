package fr.istic.vv;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RandomWikipediaWalker {

    static final WebDriver driver = new ChromeDriver();

    public static void navigateTo(String url){
        if(url != null){
            driver.navigate().to(url);
        }
        
    }

    public static List<String> findAllLinksInPage(String url){
        List<String> links = new ArrayList<>();

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        for(WebElement link : allLinks){
            try {
                if(!link.getText().contains(".pdf")){
                    links.add(link.getAttribute("href"));
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        if(links.isEmpty()) {
            System.err.println("No more links !");
        }

        return links;

    }

    public static String getRandomLink(List<String> links){
        return links.get(new Random().nextInt(links.size()));
    }

    public static String goToRandomLinkInPage(String url){
        navigateTo(url);
        String nextUrl = getRandomLink(findAllLinksInPage(url));
        System.out.println(driver.getCurrentUrl() + " --> " + nextUrl);
        navigateTo(nextUrl);
        return nextUrl;
    }

    public static void takeAndSaveScreenshot(String path) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            System.err.println("File " + path + " not found");
        }
    }

    public static void randomWikipediaWalking(String startUrl, int numberOfPages){
        System.out.println("Start random wikipedia walking!");
        String url = startUrl;

        for(int i=1; i<numberOfPages; i++) {
            url = goToRandomLinkInPage(url);
        }

        takeAndSaveScreenshot("code/tp5-random-wikipedia-walker/wikipediaPage.png");
        System.out.println("End random wikipedia walking!");
    }

    public static void main(String[] args) {
        randomWikipediaWalking("https://www.wikipedia.org/", 10);
        driver.close();
    }
    
}
