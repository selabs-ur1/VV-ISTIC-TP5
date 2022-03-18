# Random Wikipedia walker

Using Selenium, create a small program that, starting from the main page https://www.wikipedia.org/, walks trough a sequence of random links and takes a snapshot of the last page.
The process is as follows:

 1. Navigate to the main page https://www.wikipedia.org/
 2. Select a random link in the page
 3. Navigate to the link
 4. Repeat steps 2 to 3 until you have visited 10 different pages
 5. Take a snapshot of the current page and save it

Include the code of the walker and the snapshot in this document.

## Answer

```

public class WikipediaWalker {

    public static void main(String[] args) {

        
        WebDriverManager.chromedriver().setup();
        WebDriver chrome = new ChromeDriver();
        chrome.get("https://en.wikipedia.org/wiki/Gravity_of_Mars");
        
        String url;
        
        for(int i = 0; i<10;i++) {
        	List<WebElement> listLinks = chrome.findElements(By.xpath("//main//a[@href]"));
        	int chosenValue = new Random().nextInt(listLinks.size());
            url = listLinks.get(chosenValue).getAttribute("href");
            chrome.get(url);
        }

        // SCREENSHOT TO DO

        chrome.quit();
    }

}
```
