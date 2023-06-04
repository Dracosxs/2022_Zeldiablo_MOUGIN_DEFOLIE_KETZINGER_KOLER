package gameLaby.laby;



import moteurJeu.MoteurJeu;

import java.io.IOException;

public class MainLaby {

    public static void main(String[] args) throws IOException {

        int fps = 10;

        LabyJeu l = new LabyJeu("labySimple/laby2.txt");
        int largeur = l.getLabyrinthe().getLength()*50;
        int hauteur = l.getLabyrinthe().getLengthY()*50;

        //vérification dans le terminal que la laby est bien chargé
        for (int y = 0; y < l.getLabyrinthe().getLengthY(); y++) {
            // affiche la ligne
            for (int x = 0; x < l.getLabyrinthe().getLength(); x++) {
                if (l.getLabyrinthe().getMur(x, y))
                    System.out.print('X');
                else if ((l.getLabyrinthe().getJoueur().getX()==x) && (l.getLabyrinthe().getJoueur().getY()==y)) {
                    System.out.print('P');
                }else if (l.getLabyrinthe().getM(x, y)) {
                    System.out.print("M");
                }
                else {
                    System.out.print(".");
                }
            }
            // saut de ligne
            System.out.println();
        }

        LabyDessin ld = new LabyDessin();

        MoteurJeu.setFPS(fps);
        MoteurJeu.setTaille(largeur, hauteur);
        MoteurJeu.launch(l, ld);

    }
}