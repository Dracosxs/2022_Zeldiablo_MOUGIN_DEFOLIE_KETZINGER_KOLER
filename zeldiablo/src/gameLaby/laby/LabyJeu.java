package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;


import java.io.IOException;

public class LabyJeu implements Jeu {

    public final static int tailleCase = 50;
    public static int TotalPiece;

    private Labyrinthe labyrinthe;

    public LabyJeu(String nomFichier) throws IOException {
        this.labyrinthe = new Labyrinthe(nomFichier);
        TotalPiece = this.labyrinthe.ListePiece.size();
    }

    @Override
    public void update(double secondes, Clavier clavier) throws IOException {
        // deplace le personnage en fonction des touches
        if ((!etreFini()) && (TotalPiece != this.labyrinthe.joueur.getPiecesRammassees())) {
            if (clavier.droite) {
                this.labyrinthe.deplacerPerso("Droite");
            }

            if (clavier.gauche) {
                this.labyrinthe.deplacerPerso("Gauche");

            }
            if (clavier.haut) {
                this.labyrinthe.deplacerPerso("Haut");
            }

            if (clavier.bas) {
                this.labyrinthe.deplacerPerso("Bas");

            }
            for (int i = 0; i < this.getLabyrinthe().ListeMosntre.size(); i++) {
                this.labyrinthe.deplacerMonstre(i);
            }
        } else if (TotalPiece == this.labyrinthe.joueur.getPiecesRammassees()) {


        }
    }

    @Override
    public void init() {
    }

    @Override
    public boolean etreFini() {
        boolean fin = false;
        for (int i = 0; i < this.getLabyrinthe().ListeMosntre.size(); i++) {
            if ((this.getLabyrinthe().joueur.getX() == this.getLabyrinthe().ListeMosntre.get(i).getX()) && (this.getLabyrinthe().joueur.getY() == this.getLabyrinthe().ListeMosntre.get(i).getY())) {
                fin = true;
            }
        }
        return fin;
    }

    public Labyrinthe getLabyrinthe() {
        return this.labyrinthe;
    }
}
