package Exercice3;

import ExerciceUn.WalkyWalker;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class SimbaPageObject {

        private final WebDriver driver;
        @FindBy(id = "titre")
        private WebElement titleInput;
        @FindBy(css ="p-button[label=Next]")
        private WebElement nextButton;
        @FindBy(id = "lieu")
        private WebElement placeInput;

    @FindBy(id = "desc")
        private WebElement descriptionInput;

    public String getTitleInputString() {
        return titleInput.getText();
    }

    public String getPlaceInputString() {
        return placeInput.getText();
    }

    public String getDescriptionInputString() {
        return descriptionInput.getText();
    }


        public SimbaPageObject(WebDriver driver) {
            Objects.requireNonNull(driver);
            //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }
        public String title() {
        return titleInput.getText();
        }

        public WebElement getNextButton(){
            return this.nextButton;
        }


}
