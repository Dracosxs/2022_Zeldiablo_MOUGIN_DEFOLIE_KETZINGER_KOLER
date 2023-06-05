package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;


import java.io.IOException;
import java.util.ArrayList;

public class LabyJeu implements Jeu {

    public final static int tailleCase = 50;
    public static int TotalPiece;

    public static ArrayList<String> listeFichier;
    private Labyrinthe labyrinthe;

    public LabyJeu(ArrayList<String> nomFichier) throws IOException {
        listeFichier = nomFichier;
        this.labyrinthe = new Labyrinthe(listeFichier);
        TotalPiece = this.labyrinthe.getListePiece().size();
    }

    @Override
    public void update(double secondes, Clavier clavier) throws IOException {
        // deplace le personnage en fonction des touches
        if ((!etreFini()) && (TotalPiece != this.labyrinthe.getJoueur().getPiecesRamassees())) {
            deplacementClavier(clavier);
            for (int i = 0; i < this.getLabyrinthe().getListeMonstre().size(); i++) {
                this.labyrinthe.deplacerMonstre(i);
            }
        } else if ((TotalPiece == this.labyrinthe.getJoueur().getPiecesRamassees()) && (!this.labyrinthe.getFin())) {
            for (int i = 0; i < this.getLabyrinthe().getListeMonstre().size(); i++) {
                this.labyrinthe.getListeMonstre().remove(this.labyrinthe.getListeMonstre().get(i));
            }
            this.labyrinthe.getSortie().afficherSortie();
            deplacementClavier(clavier);
            this.labyrinthe.joueurSurSortie();


        } else if ((!listeFichier.isEmpty()) && (TotalPiece == this.labyrinthe.getJoueur().getPiecesRamassees())){
            this.labyrinthe = new Labyrinthe(listeFichier);
            TotalPiece = this.getLabyrinthe().getListePiece().size();

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
                break;
            }
        }
        return fin;
    }


    public Labyrinthe getLabyrinthe() {
        return this.labyrinthe;
    }
}
