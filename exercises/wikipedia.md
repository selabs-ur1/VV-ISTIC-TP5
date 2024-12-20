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

Tout le code et la capture d'écran se trouvent dans le dossier code/wikiWanderer/vv\_tp5. La capture est à la racine, nommée "last_page.png" et le code est dans le dossier "src/main/java/com/vv/tp5".

Nous avons eu des soucis de driver dûs à notre installation de Firefox (via snap) qui généraient des erreurs, nous avons été obligés de coder en dur des chemins vers un geckoDriver et un "binary" de Firefox téléchargés et stockés sur nos machines. Donc les codes risquent de ne pas fonctionner (étant donné que les chemins ne seront plus valides).
