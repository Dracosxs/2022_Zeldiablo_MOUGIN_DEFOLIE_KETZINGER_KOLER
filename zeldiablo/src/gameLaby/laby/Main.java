package gameLaby.laby;

import java.io.IOException;
import java.util.ArrayList;

/**
 * charge et affiche un labyrinthe
 */
public class Main {
    public static void main(String[] args) throws IOException {



        ArrayList<String> listeDeFichiers = new ArrayList<String>();
        listeDeFichiers.add("labySimple/laby0.txt");

        listeDeFichiers.add("labySimple/laby1.txt");

        listeDeFichiers.add("labySimple/laby2.txt");        // charge le labyrinthe

        Labyrinthe laby = new Labyrinthe(listeDeFichiers);

        //affiche le labyrinthe charge
        for (int y = 0; y < laby.getLengthY(); y++) {
            // affiche la ligne
            for (int x = 0; x < laby.getLength(); x++) {
                if (laby.getMur(x, y))
                    System.out.print('X');
                else if ((laby.getJoueur().getX() == x) && (laby.getJoueur().getY() == y))
                    System.out.print('P');
                else if ((laby.getJoueur().getX() == x) && (laby.getJoueur().getY() == y))
                    System.out.print('S');
                else {
                    System.out.print('.');
                }
            }
                // saut de ligne
                System.out.println();

        }
    }
}
