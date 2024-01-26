# TP5

**Auteurs:**
- PICARD Florian
- ECKENSCHWILLER Hugo

## PageObject

J'ai écrit dans la classe ci-jointe le page object correspondant à l'application. J'ai ainsi pu créer une liaison entre l'application et mon code qui va pouvoir se lier aux boutons, input... Je vais pouvoir tester le bon fonctionnement des boutons de la page de l'interface ainsi que le bon fonctionnement des input.

## findABug

Un des bugs que j'ai trouvé est que l'appui sur le bouton "next" de la page avec le choix de la date ne fait rien. Pour ma part, le poll semble toujours null, ce qui peut expliquer que le clic sur ce bouton marche bien. J'en déduis donc que le bouton marche correctement, mais que simplement la méthode associée au `onClick` du bouton ne semble pas marcher.

