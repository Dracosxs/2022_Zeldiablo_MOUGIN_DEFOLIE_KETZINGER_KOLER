Versions 1.

Pour le versions 1 de notre projet nous avons décidé de prendre 3 itérations :

Collision avec les Murs : 

Lorsque le joueur demande à déplacer le personnage en direction d'un mur, le personnage reste bloqué et ne se déplace pas. 

Critères de validation 

• La collision fonctionne dans les 4 directions ; 

• Si la case est vide, le personnage avance.

Fonctions réussi, nous utilisons un tableaux à double entrée pour référer tout les murs présent dans le niveau. Avec la méthode deplacerPerso(String) qui prend un déplacement en paramètre, on va regarder si l'endroit ou on veut se déplacer est mur, si ce n'est pas le cas, alors le personnage peut avancer sans soucis.

Nous avons implémenter des petits monstres dans notre jeu, ils utilisent la même méthode pour empêcher les collisions avec les murs.

Collision avec un monstre :

 Lorsque le joueur demande au personnage de se déplacer vers une case contenant un monstre, le personnage ne se déplace pas. 

Critères de validation 

• La collision fonctionne dans les 4 directions. • Si la case est vide, le personnage avance. • Le monstre se déplace à chaque fois après le joueur.

Fonctions réussi, ici le système reste le même, on regarde la prochaine case, si c'est un monstre alors, on ne peut pas de mouvoir.



Monstre aléatoire: 

Régulièrement, le jeu demande aux monstres de se déplacer dans une direction aléatoire. 

Critères de validation 

• A chaque évolution du jeu, que le joueur se déplace ou non, les monstres se déplacent. 

• Les monstres sont bloqués par les obstacles. S'ils ont choisi de se diriger vers un obstacle (mur, joueur, ...), leur mouvement est alors annulé (sauf s'il s'agit de fantômes). 

• Deux monstres ou un monstre et un joueur ne peuvent pas se trouver sur la même case (Si la tache Collision entre monstre est fonctionnelle). 

• A chaque évolution, tous les monstres tentent de se déplacer. • L'interface graphique se met à jour en fonction des déplacements des Monstres

Fonctions réussi (elle sera modifié par la suite ), ici on prend les coordonnées du monstre dans la fonction déplacer monstre, et à chaque update on ajoute un déplacement de 1, aléatoirement entre le haut, le bas, la gauche et la droite. Evidemment le principe de collision entre murs et monstre reste toujours actif.