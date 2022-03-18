# Bug trouvé : 

Nous avons trouvé un bug de navigation sur le site. En effet nous avons remarqué qu'il était possible de passer à l'étape
2 du formulaire sans passer par le remplissage des inputs de l'étape 1. Chose qui est normalement interdite en passant par
le bouton "Next". Notre test vérifie si il est possible de passer à l'étape 2 sans remplire les input de l'étape 1. 
Pour ce faire nous avons fait une vérification de la couleur des boutons démontrant un changement de step. Si la couleur
passe au bleu alors on a changé d'étape ce qui ne devrait pas être possible. 