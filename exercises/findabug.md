## Find a bug

Clone the [Simba Organizer repository](https://github.com/barais/doodlestudent/) and follow the instructions to run the application on your machine.

Find a bug in the application. 

With the help of Selenium and the Page Object Model desing pattern write a simple test that fails for this bug.

Optionally make a pull request to the project.

Include in this document the code of the test and, if you did it, the link to the pull request.

## Answer
[Page object class](../code/pageObject/src/test/java/fr/benjamindanlos/pageobject/MainPage.java)
```java
public class MainPage {
    public SelenideElement step2Button = $x("//span[contains(@class, 'p-steps-number') and text() = '2']");
    public SelenideElement nextButton = $x("//span[contains(@class, 'p-button-label') and text()='Next']").parent();
}
```

[Tests class](../code/pageObject/src/test/java/fr/benjamindanlos/pageobject/MainPageTest.java)
```java
@Test
public void testNextStepDisabled() {
    mainPage.step2Button.click();

    mainPage.nextButton.shouldBe(Condition.disabled);
}
```

Bug explanation :  
The bug is that when the user lands on the `/create` page and does not fill any fields, they should not be able to change page. 
This restriction is possible by deactivating the "next" button
