## Find a bug

Clone the [Simba Organizer repository](https://github.com/barais/doodlestudent/) and follow the instructions to run the application on your machine.

Find a bug in the application. 

With the help of Selenium and the Page Object Model desing pattern write a simple test that fails for this bug.

Optionally make a pull request to the project.

Include in this document the code of the test and, if you did it, the link to the pull request.

## Answer

### Bug trouvé :

Nous avons trouvé un bug de navigation sur le site. En effet nous avons remarqué qu'il était possible de passer à l'étape
2 du formulaire sans passer par le remplissage des inputs de l'étape 1. Chose qui est normalement interdite en passant par
le bouton "Next". Notre test vérifie si il est possible de passer à l'étape 2 sans remplire les input de l'étape 1.
Pour ce faire nous avons fait une vérification de la couleur des boutons démontrant un changement de step. Si la couleur
passe au bleu alors on a changé d'étape ce qui ne devrait pas être possible.

[Mes réponses](../TP_SELENIUM_WALKER_V2/src/main/java/Exercice3/Answer.md)

[Le code](../TP_SELENIUM_WALKER_V2/src/main/java/Exercice3)

