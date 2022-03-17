package fr.benjamindanlos;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Walker class.
 */
public class Walker {
    private WebDriver driver;

    public Walker(WebDriver driver, String firstUrl) {
        this.driver = driver;
        this.driver.get(firstUrl);
    }

    /**
     * randomly visits a link on the current page 10 times
     */
    public void startWalk(){
        for(int counter=0; counter<10; counter++) {
            try {
                //let the page load
                sleep(3);

                //find all <a> elements (links)
                List<WebElement> links = this.driver.findElements(new By.ByTagName("a"));

                if (!links.isEmpty()) {

                    //choose a link by a random number within the size of the list
                    Random random = new Random();
                    int n = random.nextInt(links.size());

                    //get the link element and click on it
                    WebElement selected = links.get(n);
                    selected.click();

                } else {
                    System.out.println("no links, exiting");
                    counter = 10;
                }
            }
            catch (ElementNotInteractableException e){
                System.err.println("could not click on element: "+e.getMessage());
                counter--;
            }
            catch (InterruptedException e){
                System.err.println("Failed to sleep");
                e.printStackTrace();
                counter--;
            }
        }
        //when 10th link was clicked, take a screenshot of the page
        takeScreenshot();
    }

    /**
     * take a screenshot of the current page and save it in ./screenshot.png
     */
    public void takeScreenshot(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) this.driver;
        File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File savedFile = new File("./screenshot2.png");
        try {
            FileUtils.copyFile(screenshot, savedFile);
        }
        catch (IOException e){
            System.err.println("Could not save screenshot : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
