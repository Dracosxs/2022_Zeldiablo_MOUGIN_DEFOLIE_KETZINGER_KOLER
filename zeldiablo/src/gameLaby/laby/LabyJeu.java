package gameLaby.laby;

import javafx.animation.Timeline;
import moteurJeu.Clavier;
import moteurJeu.Jeu;
import moteurJeu.MoteurJeu;


import java.io.IOException;
import java.util.Timer;

public class LabyJeu implements Jeu {

    public final static int tailleCase = 50;
    public static int deplacementTotal = 0;
    private Labyrinthe l ;

    public LabyJeu(String nomFichier) throws IOException {
        this.l = new Labyrinthe(nomFichier);
    }

    @Override
    public void update(double secondes, Clavier clavier) throws IOException {
        // deplace le personnage en fonction des touches
        if (!etreFini()) {
            if (clavier.droite) {
                this.l.deplacerPerso("Droite");
                deplacementTotal++;
            }

            if (clavier.gauche) {
                this.l.deplacerPerso("Gauche");
                deplacementTotal++;
            }
            if (clavier.haut) {
                this.l.deplacerPerso("Haut");
                deplacementTotal++;
            }

            if (clavier.bas) {
                this.l.deplacerPerso("Bas");
                deplacementTotal++;

            }
            for (int i = 0; i < this.getL().m.size(); i++) {
                this.l.deplacerMonstre(i);
            }
        } else {
        }
    }




    @Override
    public void init() {

    }

    @Override
    public boolean etreFini() {
        boolean fin = false;
        for (int i = 0 ; i < this.getL().m.size() ; i++){
            if ((this.getL().pj.getX() == this.getL().m.get(i).getX()) && (this.getL().pj.getY() == this.getL().m.get(i).getY())){
                fin = true;
            }
        }

        return fin;
    }

    public Labyrinthe getL(){
        return this.l;
    }
}
