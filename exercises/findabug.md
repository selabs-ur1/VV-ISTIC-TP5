## Find a bug

Clone the [Simba Organizer repository](https://github.com/barais/doodlestudent/) and follow the instructions to run the application on your machine.

Find a bug in the application. 

With the help of Selenium and the Page Object Model desing pattern write a simple test that fails for this bug.

Optionally make a pull request to the project.

Include in this document the code of the test and, if you did it, the link to the pull request.

## Answer

L'api et le front fonctionnent bien. Cependant, au moment de créer un poll après avoir sélectionné les dates, le bouton de création du poll ne fonctionne pas. Dans la console du navigateur, on recoit une erreur 500 de l'api. Le code de l'api semble fonctionner, c'est donc un problème de communication avec le service docker etherpad.