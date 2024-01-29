# Find a bug

Yoann DEWILDE\
Enora DANILO\
M2 ILa - Groupe 1

Clone the [Simba Organizer repository](https://github.com/selabs-ur1/doodle) and follow the instructions to run the application on your machine.

Find a bug in the application. 

With the help of Selenium and the Page Object Model desing pattern write a simple test that fails for this bug.

Optionally make a pull request to the project.

Include in this document the code of the test and, if you did it, the link to the pull request.

## Answer

Sur la page de création de sondage, il est possible d'accéder aux étapes 2 et 3, en haut de la page, alors que l'étape 1 n'est même pas terminée.

### Reproduction du bug

- Se rendre sur http://localhost:4200/create.
- Cliquer sur le bouton "Informations pour le rendez-vous" : la page ne change pas.
- Cliquer sur le bouton "Choix de la date" : **bug : ne devrait pas être possible**.
- Cliquer sur le bouton "Résumé" : **bug : ne devrait pas être possible**.

### Page Object Model

Pour simplifier le test, seul le Page Model Object de la barre avec les boutons d'étapes a été implémenté.
Le code est disponible [ici](../code/exo-3-bug/src/test/java/fr/istic/ydewilde/model/CreatePollPage.java).

### Test

Le cas de test concerne le scénario où l'utilisateur est à la première étape.
[Le voici](../code/exo-3-bug/src/test/java/fr/istic/ydewilde/CreatePollTest.java).

### Correction

Cette barre utilise le composant `p-steps` de la bibliothèque PrimeNG. Le problème ne vient donc pas de l'application.