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
Le code est disponible [ici](./tp5/src/test/java/fr/istic/m2/vv/brianddurand/tp5/WikipediaWalker.java).
Le résultat de l'execution du walker est disponible ![ici](./images\wikipedia-2022-3-18-15-0-44.png). Les captures sont nommées avec la date de jeu. Aussi, les adresses visitées sont écrite dans la console si on souhaite reproduire le parcours.