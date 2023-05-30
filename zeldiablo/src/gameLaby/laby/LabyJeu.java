package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LabyJeu implements Jeu {

    private Labyrinthe l ;

    public LabyJeu(String nomFichier) throws IOException {
        this.l = new Labyrinthe(nomFichier);
    }

    @Override
    public void update(double secondes, Clavier clavier) {


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
