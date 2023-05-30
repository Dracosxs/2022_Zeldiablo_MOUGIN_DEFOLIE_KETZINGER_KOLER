package gameLaby.laby;

import javafx.animation.Timeline;
import moteurJeu.Clavier;
import moteurJeu.Jeu;


import java.io.IOException;
import java.util.Timer;

public class LabyJeu implements Jeu {

    public final static int tailleCase = 50;
    private Labyrinthe l ;

    public LabyJeu(String nomFichier) throws IOException {
        this.l = new Labyrinthe(nomFichier);
    }

    @Override
    public void update(double secondes, Clavier clavier) {
        // deplace le personnage en fonction des touches
            if (clavier.droite) {

                this.l.deplacerPerso("Droite");
            }

            if (clavier.gauche) {
                this.l.deplacerPerso("Gauche");
            }
            if (clavier.haut) {
                this.l.deplacerPerso("Haut");
            }

            if (clavier.bas) {
                this.l.deplacerPerso("Bas");
            }
        }




    @Override
    public void init() {

    }

    @Override
    public boolean etreFini() {
        return false;
    }

    public Labyrinthe getL(){
        return this.l;
    }
}
