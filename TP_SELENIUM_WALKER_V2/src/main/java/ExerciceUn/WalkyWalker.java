package ExerciceUn;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WalkyWalker {
    WebDriver driver;
    String initLink;

    public WalkyWalker(WebDriver webyDriverou,String initLink ){
        this.driver= webyDriverou;
        this.initLink=initLink;
        this.driver.get(this.initLink);
    }

    public void walk(int amountOfJumps) throws IOException {
        Random randomito = new Random();
        for(int i = 0; i<amountOfJumps; i++){
                List<WebElement> allLinks = driver.findElements(new By.ByTagName("a"));
                int int_random = randomito.nextInt(allLinks.size());
                WebElement myLink =allLinks.get(int_random);
                try{
                    myLink.click();

                }catch (ElementNotInteractableException e){
                    i--;
                }
        }
        takeScreenShot();
    }

    public void takeScreenShot() throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./screenshot.png"));
    }
}
