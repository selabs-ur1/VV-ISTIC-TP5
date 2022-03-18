package fr.istic.m2.vv.brianddurand.tp5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimbaPollCreationPage{

    private WebDriver webDriver;

    @FindBy(id = "titre")
    private WebElement titre;

    @FindBy(xpath = "/html/body/app-root/app-create-poll-component/div/div[1]/p-steps/div/ul/li[3]/a")
    private WebElement boutonResume;

    public SimbaPollCreationPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getTitre(){
        return this.titre.getText();
    }

    public WebElement getChampTitre(){
        return this.titre;
    }

    public void clickResumeBouton(){
        this.boutonResume.click();
    }

}
