Versions 2.

Ici représente la plus grosse version ajouté a notre projet. Nous avons pour cela choisi les itérations suivantes : 



Monstres au comportement intelligent : A chaque fois que les monstres se déplacent, ils se rapprochent dans la direction du héros en prenant en compte la présence des murs. 

Critères de validation 

• Avant son déplacement, le monstre détermine le meilleur chemin pour atteindre le héros. • Le monstre prend en compte les obstacles qui le concernent pour trouver le meilleur chemin. 

• lorsqu'il se déplace, le monstre suit instinctivement le meilleur chemin et parvient jusqu'au héros même s'il y a des obstacles. 



Fonctions réussi, et c'est d'ailleurs l'une des fonctionnalités les plus intéressante de notre projet. En effet nous avons implémenté l'algorithme de Djikstra, récupéré dans la SaE 2.02. Donc pour cela nous avons importer les méthodes Djikstra et Valeur, et notre package Graphe, qui inclut les classes Arc, GrapheListe, Noeud et l'interface Graphe.

Pour changer la méthode de déplacement du monstre nous avons donc créer un graphe de la taille du labyrinthe, et implémenter la méthode getProchaineAction qui nous permet à chaque update, de recalculer le meilleurs chemin pour que le monstre poursuive le joueur. On fais déplacer le monstre dans la même méthode.

Cependant note à prendre en compte, et que vous constaterez surement pendant l'utilisation du jeu, le monstre est assez rapide. Même si les niveaux sont assez facile avec quelques essais, il reste que ce n'est pas toujours simple de jouer. Le problème à été étudié mais nous avons manqué de temps pour pouvoir le résoudre. En effet le problème viens de notre fonction Update, qui met à jour à chaque mouvement le jeu. Nous avons essayé de mettre un timer dans l'exécution du monstre, mais cela n'a rien changé à notre problème car le joueur et le monstre sont exécuté à la suite dans la classes update, ainsi si nous mettons en place un sleep pour DeplacerMonstre cela va aussi impacter Update et en conséquences le problème sera toujours présent car le Joueur ne pourra pas prendre de l'avance sur le monstre. La solution à notre problème serait sans doute de mettre en place un deuxième update, uniquement pour le monstre.





Acquisition de l'amulette : 

Dès que le joueur demande à déplacer le héros sur l'amulette, le héros se déplace et prend l'amulette. 

Critères de validation 

• L'amulette n'est plus sur le plateau (et n'est plus achée). 

• Le Héros possède l'amulette. 

• Un monstre ne récupère pas l'amulette.



Fonction réussie, en effet nous avons mis en place un liste de pièces (qui marche comme des amulettes). Dans la fonction déplacerPerso nous mettons en place le fait que si un joueur passe sur une pièce il la ramasse. Le nombre de pièce ramassé est calculé, et pour chaque niveau il y un nombre de pièces à ramasser. Ceci fais un lien avec la suite du projet qui permet la fin du jeu, si toutes les pièces sont récupérés.

Par ailleurs ce n'est pas spécifié ici, mais les pièces ont été mise en place, de la même façon que les murs). Ici les pièces ne faisait pas partie de la classe Perso. C'est d'ailleurs un regret de conception, nous nous sommes rendu qu'on compte, que le création d'une classe parents Cases, comme Perso, mais cette dernière aurait pu être en lien avec tout les éléments labyrinthes, et non pas seulement avec Monstre et Joueur comme avec Perso. En effet chaque éléments du labyrinthe possède plusieurs caractéristiques communes.



Ouverture de Passages secrets  :

 Lorsque une entité (héros ou monstre) arrive sur une case d'ouverture, le labyrinthe se modifie et la porte liée à cette case (située à un autre endroit dans le labyrinthe) s'ouvre. Les portes peuvent donc constituer des pièges cachés puisque une case peut ouvrir les portes qui protègent le héros d'une horde de monstres. 

Critères de validation 

• Une porte est un type de case particulière. Une porte n'a pas d'orientation et occupe toute une case. 

• Une porte peut être fermée ou ouverte. Une porte fermée bloque le trajet et une porte ouverte est traversable. 

• La porte s'ouvre au passage du personnage sur la case qui déclenche son ouverture. • Une fois la porte ouverte, elle reste ouverte. 



Alors dans notre projet, il existe bien un passage secret mais différents des attentes. En effet une porte va s'afficher (elle est invisible normalement) quand le joueur aura récolter toutes les pièces d'un niveau. Ainsi nous avons implémenter une porte, dans une classe Sortie, qui est invisible si la condition n'est pas atteinte. En réalité, c'est un point d'amélioration de notre code, mais la porte est toujours présente elle n'est juste pas dessiné (malgré cela aucune interaction est possible). Il y a donc une méthode etreAffiche qui autorise ou non à afficher la porte.

