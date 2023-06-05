

import gameLaby.laby.LabyJeu;
import moteurJeu.Clavier;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;


public class Tests {

    @Test
    public void test_01_testDeplacementPerso4Directions() throws IOException {
        ArrayList<String> fichier = new ArrayList<>();
        fichier.add(0, "labySimple/laby0.txt");
        LabyJeu l = new LabyJeu(fichier);


        // test déplacement à gauche
        // place avant déplacement
        int x = l.getLabyrinthe().getJoueur().getX();
        int y = l.getLabyrinthe().getJoueur().getY();
        l.getLabyrinthe().deplacerPerso("Gauche");
        Assert.assertEquals("Methode mal ecrite, resultat attendu non obtenu", x-1, l.getLabyrinthe().getJoueur().getX());
        Assert.assertEquals("Methode mal ecrite, resultat attendu non obtenu", y, l.getLabyrinthe().getJoueur().getY());

        // test déplacement à droite
        // place avant déplacement
        x = l.getLabyrinthe().getJoueur().getX();
        y = l.getLabyrinthe().getJoueur().getY();
        l.getLabyrinthe().deplacerPerso("Droite");
        Assert.assertEquals("Methode mal ecrite, resultat attendu non obtenu", x+1, l.getLabyrinthe().getJoueur().getX());
        Assert.assertEquals("Methode mal ecrite, resultat attendu non obtenu", y, l.getLabyrinthe().getJoueur().getY());

        // test déplacement en haut
        // place avant déplacement
        x = l.getLabyrinthe().getJoueur().getX();
        y = l.getLabyrinthe().getJoueur().getY();
        l.getLabyrinthe().deplacerPerso("Haut");
        Assert.assertEquals("Methode mal ecrite, resultat attendu non obtenu", x, l.getLabyrinthe().getJoueur().getX());
        Assert.assertEquals("Methode mal ecrite, resultat attendu non obtenu", y-1, l.getLabyrinthe().getJoueur().getY());

        // test déplacement en bas
        // place avant déplacement
        x = l.getLabyrinthe().getJoueur().getX();
        y = l.getLabyrinthe().getJoueur().getY();
        l.getLabyrinthe().deplacerPerso("Bas");
        Assert.assertEquals("Methode mal ecrite, resultat attendu non obtenu", x, l.getLabyrinthe().getJoueur().getX());
        Assert.assertEquals("Methode mal ecrite, resultat attendu non obtenu", y+1, l.getLabyrinthe().getJoueur().getY());
    }

    @Test
    public void test_02_deplacementMonstre() throws IOException {
        ArrayList<String> fichier = new ArrayList<>();
        fichier.add(0, "labySimple/laby1.txt");
        LabyJeu l = new LabyJeu(fichier);

        // test déplacement
        // place avant déplacement
        int x = l.getLabyrinthe().getListeMonstre().get(0).getX();
        int y = l.getLabyrinthe().getListeMonstre().get(0).getY();
        l.getLabyrinthe().deplacerMonstre(0);
        Assert.assertEquals("Methode mal ecrite, resultat attendu non obtenu", x+1, l.getLabyrinthe().getListeMonstre().get(0).getX());
        Assert.assertEquals("Methode mal ecrite, resultat attendu non obtenu", y, l.getLabyrinthe().getListeMonstre().get(0).getY());
    }

    @Test
    public void test_03_pieceRamassee() throws IOException, ConcurrentModificationException {
        ArrayList<String> fichier = new ArrayList<>();
        fichier.add(0, "labySimple/laby0.txt");
        LabyJeu l = new LabyJeu(fichier);

        //deplacement à droite
        for (int i = 0; i < 7; i++) {
            l.getLabyrinthe().deplacerPerso("Droite");
        }

        //deplacement en haut
        for (int i = 0; i < 9; i++) {
            l.getLabyrinthe().deplacerPerso("Haut");
        }

        //deplacement à gauche
        for (int i = 0; i < 6; i++) {
            l.getLabyrinthe().deplacerPerso("Gauche");
        }

        // test si le perso est à côté de la pièce (à droite)
        Assert.assertEquals("Methode mal ecrite, resultat attendu non obtenu en Y", l.getLabyrinthe().getListePiece().get(0).getY(), l.getLabyrinthe().getJoueur().getY());

        Assert.assertEquals("Methode mal ecrite, resultat attendu non obtenu en X", l.getLabyrinthe().getListePiece().get(0).getX()+1, l.getLabyrinthe().getJoueur().getX());

        // on vérifie que le perso a bien ramassé zéro pièce
        Assert.assertEquals("Methode mal ecrite, resultat attendu non obtenu en Y", 0, l.getLabyrinthe().getJoueur().getPiecesRamassees());

        // on effectue le déplacement
        l.getLabyrinthe().deplacerPerso("Gauche");

        // le perso doit avoir récupéré une pièce
        Assert.assertEquals("Methode mal ecrite, resultat attendu non obtenu", 1, l.getLabyrinthe().getJoueur().getPiecesRamassees());

        // La pièce doit avoir disparu
        Assert.assertEquals("Methode mal ecrite, resultat attendu non obtenu", true, l.getLabyrinthe().getListePiece().isEmpty());
    }

    @Test
    public void test_04_Sortie() throws IOException, ConcurrentModificationException {
        ArrayList<String> fichier = new ArrayList<>();
        fichier.add(0, "labySimple/laby0.txt");
        LabyJeu l = new LabyJeu(fichier);

        //deplacement à droite
        for (int i = 0; i < 7; i++) {
            l.getLabyrinthe().deplacerPerso("Droite");
        }

        //deplacement en haut
        for (int i = 0; i < 9; i++) {
            l.getLabyrinthe().deplacerPerso("Haut");
        }

        //deplacement à gauche
        for (int i = 0; i < 13; i++) {
            l.getLabyrinthe().deplacerPerso("Gauche");
        }

        //deplacement en bas
        for (int i = 0; i < 10; i++) {
            l.getLabyrinthe().deplacerPerso("Bas");
        }

        //deplacement à droite
        for (int i = 0; i < 7; i++) {
            l.getLabyrinthe().deplacerPerso("Droite");
        }

        Assert.assertEquals("Methode mal ecrite, resultat attendu non obtenu en Y", l.getLabyrinthe().getSortie().getY(), l.getLabyrinthe().getJoueur().getY());

        Assert.assertEquals("Methode mal ecrite, resultat attendu non obtenu en X", l.getLabyrinthe().getSortie().getX(), l.getLabyrinthe().getJoueur().getX());

        Assert.assertEquals("Methode mal ecrite, resultat attendu non obtenu", true, l.getLabyrinthe().getSortie().etreAffiche());

    }
}
