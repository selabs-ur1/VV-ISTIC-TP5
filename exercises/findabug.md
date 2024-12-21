## Find a bug

Clone the [Simba Organizer repository](https://github.com/barais/doodlestudent/) and follow the instructions to run the application on your machine.

Find a bug in the application. 

With the help of Selenium and the Page Object Model desing pattern write a simple test that fails for this bug.

Optionally make a pull request to the project.

Include in this document the code of the test and, if you did it, the link to the pull request.

## Answer

L'application ne fonctionnait pas avec Selenium sur nos machines, mais voici la manière dont nous comptions procéder :
- initialiser le webDriver
- aller jusqu'au créateur d'évènement
- remplir les données de manière automatique et aller sur suivant
- cliquer sur le calendrier à 2 endroits différents dans une même journée pour créer la plage horaire
- cliquer sur suivant de nouveau et voir que rien ne se produisait
