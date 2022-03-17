package fr.benjamindanlos;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WebDriverManager.chromedriver().setup();
        Walker walker = new Walker(new ChromeDriver(), "https://en.wikipedia.org/wiki/Special:Random");
        walker.startWalk();
    }
}
