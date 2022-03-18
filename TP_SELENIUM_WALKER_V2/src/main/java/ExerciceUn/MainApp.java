package ExerciceUn;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


public class MainApp {



    public static void main (String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        WalkyWalker myWalker = new WalkyWalker(new ChromeDriver(),"https://fr.wikipedia.org/wiki/Wikip%C3%A9dia:Accueil_principal");
        myWalker.walk(10);
    }


}
