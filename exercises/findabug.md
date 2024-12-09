## Find a bug

Clone the [Simba Organizer repository](https://github.com/selabs-ur1/doodle) and follow the instructions to run the application on your machine.

Find a bug in the application. 

With the help of Selenium and the Page Object Model desing pattern write a simple test that fails for this bug.

Optionally make a pull request to the project.

Include in this document the code of the test and, if you did it, the link to the pull request.

## Answer

```java
import { PollPage } from "./poll-page";

describe("Page du sondage", () => {
let pollPage: PollPage;

    // Initialiser la page avant chaque test
    beforeEach(() => {
        pollPage = new PollPage();
        pollPage.navigateTo(); // Naviguer vers la page du sondage
    });

    it("affiche le nombre correct de votes pour chaque option", () => {
        // Cliquer sur la première option
        pollPage.clickOption("Option 1");

        // Soumettre le vote
        pollPage.clickSubmit();

        // Vérifier que le nombre de votes pour l'option sélectionnée est correct
        expect(pollPage.getOptionVotes("Option 1")).toBe(1);
    });
});
``` 


