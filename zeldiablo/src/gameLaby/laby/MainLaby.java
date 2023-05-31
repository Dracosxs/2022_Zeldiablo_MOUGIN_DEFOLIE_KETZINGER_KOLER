package gameLaby.laby;

import javafx.scene.paint.Color;
import moteurJeu.MoteurJeu;

import java.io.IOException;

public class MainLaby {

    public static void main(String[] args) throws IOException {

        int fps = 10;
        LabyJeu l = new LabyJeu("labySimple/laby1.txt");
        int largeur = l.getL().getLength()*80;
        int hauteur = l.getL().getLengthY()*80;
        //vérification dans le terminal que la laby est bien chargé
        for (int y = 0; y < l.getL().getLengthY(); y++) {
            // affiche la ligne
            for (int x = 0; x < l.getL().getLength(); x++) {
                if (l.getL().getMur(x, y))
                    System.out.print('X');
                else if ((l.getL().getPj().getX()==x) && (l.getL().getPj().getY()==y)) {
                    System.out.print('P');
                }else if (l.getL().getM(x, y)) {
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
