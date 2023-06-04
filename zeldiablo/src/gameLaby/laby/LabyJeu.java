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
        TotalPiece = this.labyrinthe.getListePiece().size();
    }

    @Override
    public void update(double secondes, Clavier clavier) throws IOException {
        // deplace le personnage en fonction des touches
        if ((!etreFini()) && (TotalPiece != this.labyrinthe.getJoueur().getPiecesRammassees())) {
            deplacementClavier(clavier);
            for (int i = 0; i < this.getLabyrinthe().getListeMonstre().size(); i++) {
                this.labyrinthe.deplacerMonstre(i);
            }
        } else if ((TotalPiece == this.labyrinthe.getJoueur().getPiecesRammassees()) && (!this.labyrinthe.getFin())) {
            for (int i = 0; i < this.getLabyrinthe().getListeMonstre().size(); i++){
                this.labyrinthe.getListeMonstre().remove(this.labyrinthe.getListeMonstre().get(i));
            }
            this.labyrinthe.getSortie().afficherSortie();
            deplacementClavier(clavier);
            this.labyrinthe.etreFini();

        }
        else {
            // implémente la fin du jeu/ou le niveau suivant
        }
    }

    public void deplacementClavier(Clavier clavier) {
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
    }

    @Override
    public void init() {
    }

    @Override
    public boolean etreFini() {
        boolean fin = false;
        for (int i = 0; i < this.getLabyrinthe().getListeMonstre().size(); i++) {
            if ((this.getLabyrinthe().getJoueur().getX() == this.getLabyrinthe().getListeMonstre().get(i).getX()) &&
                    (this.getLabyrinthe().getJoueur().getY() == this.getLabyrinthe().getListeMonstre().get(i).getY())) {
                fin = true;
            }
        }
        return fin;
    }

    public Labyrinthe getLabyrinthe() {
        return this.labyrinthe;
    }
}
