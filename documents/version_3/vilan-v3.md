Affichage avec des sprites :

 La fenêtre n'affiche plus des gures de base (rond, ...) mais des sprites représentant les personnages et les objets (http://fr.wikipedia.org/wiki/Sprite_%28jeu_vid%C3%A9o%29). Critères de validation 

• Les sprites concernent les murs, les monstres et le héros. • Ils sont chargés une fois pour toute au lancement de l'application et ils peuvent être affichés dans le JPanel grâce à la méthode drawImage. 

• Vous pourrez utiliser l'image http://www.qcfdesign.com/?p=354 qui est un ensemble de sprites pour le jeu Desktop Dungeons. Ces sprites sont disposés régulièrement dans l'image et sont donc facile à extraire à partir de l'Image. 

• Il est possible de charger une image (de type BufferedImage en mémoire grâce à la classe ImageIO et la méthode statique read).



Fonction réussie, en effet nous avons un classe Sprite qui implémente dans des attributs les images et on va se servir de cette classe pour dessiner les images voulu



Fin du jeu : victoire du héros  : 

 Une fois que le héros a pris toute les pièces, il peut retourner à l'entrée du labyrinthe et remporter le jeu. COO- TD - Projet Zeldiabolo - Liste des fonctionnalités 16 

Critères de validation 

• Lorsque le héros possède l'amulette et qu'il retourne à l'entrée du labyrinthe, le jeu s'arrête et un message est aché dans la console. 

• Lorsque le héros ne possède pas l'amulette, le jeu ne s'arrête pas même si le héros retourne à l'entrée.



Une fois toute les pièces récupérés (donc on compte le nombre de pièces totaux et une fois qu'elles sont toutes récupérés) on affiche la porte, et si on emprunte la porte alors la fin du jeu est dessiné à l'aide labyDesin.





Gestion d'un labyrinthe multi-étages 

 Le labyrinthe est constitué de plusieurs étages. Chaque étage correspond à un niveau particulier. Des escaliers permettent de passer d'un étage à un autre. 

Critères de validation • Les escaliers sont des cases traversables par le héros et les monstres. • Lorsque le héros se trouve sur un escalier, il peut l'activer et il change alors de niveau. • Les monstres du niveau où le héros se trouvait avant l'escalier n'apparaissent pas dans l'étage supérieur/inférieur. Ils restent à leur position et conservent leur points de vie. • De nouveaux monstres peuvent être présents à l'étage supérieur en fonction du descriptif du niveau. • Le Héros arrive aux mêmes coordonnées dans l'étage supérieur/inférieur après avoir emprunté les escaliers. • Les escaliers peuvent être de deux types : un escalier qui monte ou un escalier qui descend. • Les escaliers sont empruntables dans les deux sens : un escalier qui monte vers un étage possède un escalier qui descend à la même position dans l'étage supérieur (et inversement).



Ici au lieu de charger un seul fichier txt on charge une liste de fichiers, dès qu'on en utilise un (lecture dans labyrinthe). Dès que le joueur est sur la sortie, alors on fini le jeu, et ainsi on en charge un nouveau. Dès qu'il n'y en a plus le jeu s'arrête avec un message de fin.

