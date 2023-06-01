package gameLaby.laby;

import javafx.animation.Timeline;
import moteurJeu.Clavier;
import moteurJeu.Jeu;
import moteurJeu.MoteurJeu;


import java.io.IOException;
import java.util.Timer;

public class LabyJeu implements Jeu {

    public final static int tailleCase = 50;
    public static int pieceTot ;

    private Labyrinthe l ;

    public LabyJeu(String nomFichier) throws IOException {
        this.l = new Labyrinthe(nomFichier);
        pieceTot = this.l.p.size();
    }

    @Override
    public void update(double secondes, Clavier clavier) throws IOException {
        // deplace le personnage en fonction des touches
        if ((!etreFini()) && (pieceTot != this.l.j.getPiecesRammassees())) {
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
            for (int i = 0; i < this.getL().m.size(); i++) {
                this.l.deplacerMonstre(i);
            }
        } else if (pieceTot == this.l.j.getPiecesRammassees()) {



        }
    }




    @Override
    public void init() {

    }

    @Override
    public boolean etreFini() {
        boolean fin = false;
        for (int i = 0 ; i < this.getL().m.size() ; i++){
            if ((this.getL().j.getX() == this.getL().m.get(i).getX()) && (this.getL().j.getY() == this.getL().m.get(i).getY())){
                fin = true;
            }
        }

        return fin;
    }

    public Labyrinthe getL(){
        return this.l;
    }
}
