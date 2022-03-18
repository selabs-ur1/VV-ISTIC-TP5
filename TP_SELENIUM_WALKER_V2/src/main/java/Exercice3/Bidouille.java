package Exercice3;

import ExerciceUn.WalkyWalker;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class Bidouille {


    public static void main (String[] args) throws InterruptedException, IOException {
        ChromeDriver chrome = new ChromeDriver();
        SimbaPageObject simba = new SimbaPageObject(chrome);
        WebDriverManager.chromedriver().setup();
        open("http://localhost:4200/create");
        chrome.get("http://localhost:4200/create");
        Thread.sleep(5000);
        simba.getNextButton().click();
    }
}
