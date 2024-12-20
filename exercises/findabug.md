## Find a bug

Clone the [Simba Organizer repository](https://github.com/selabs-ur1/doodle) and follow the instructions to run the application on your machine.

Find a bug in the application. 

With the help of Selenium and the Page Object Model desing pattern write a simple test that fails for this bug.

Optionally make a pull request to the project.

Include in this document the code of the test and, if you did it, the link to the pull request.

## Answer

Setup (problème personnel survenu)
- front
    - ```bash
        export NODE_OPTIONS=--openssl-legacy-provider
        ```
        J'ai du effectué en plus cette commande avant le npm start
        autrement j'éprouvais des problèmes de version sur certaines dependances

- api
    - le docker ne se lançait pas correctement
    image: etherpad/etherpad:stable -> image: etherpad/etherpad

    - 
        ```bash
        systemctl stop mysql 
        ```
        (autrement il ne permet pas au docker le lancement de api-db)


J'ai pas réussi à accéder à la page simba-poll, j'ai une des erreurs qui empêchait la création de poll via l'api. Malgré le fait que j'ai essayé plusieurs heures de résoudre ce problème, je n'ai pas réussi pour le moment.
 
j'ai donc effectué ce code à "l'aveugle" et je ne sais pas s'il fonctionne. Il insère juste le nom et le mail puis submit.

```Java
WebDriver driver = new ChromeDriver();

driver.get("https://www.selenium.dev/selenium/web/web-form.html");

driver.getTitle();

driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

WebElement textBox = driver.findElement(By.name("my-text"));
WebElement submitButton = driver.findElement(By.cssSelector("button"));

textBox.sendKeys("Selenium");
submitButton.click();

WebElement message = driver.findElement(By.id("message"));
message.getText();

driver.quit();
```