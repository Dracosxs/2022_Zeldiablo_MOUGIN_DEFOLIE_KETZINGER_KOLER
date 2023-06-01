package gameLaby.laby;

import ALGO.Dijkstra;
import ALGO.Valeur;
import Graphe.GrapheListe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.animation.PauseTransition;
import javafx.util.Duration;



/**
 * classe labyrinthe. represente un labyrinthe avec
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 */
public class Labyrinthe {

    /**
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char VIDE = '.';
    public static final char MONSTRE = 'M';

    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";

    /**
     * attribut du personnage
     */
    public Perso pj;

    /**
     * attribut du monstre
     */
    public ArrayList<Monstre> m = new ArrayList<>();

    /**
     * les murs du labyrinthe
     */
    public boolean[][] murs;



    /**
     * retourne la case suivante selon une actions
     *
     * @param x      case depart
     * @param y      case depart
     * @param action action effectuee
     * @return case suivante
     */
    static int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                // on monte une ligne
                y--;
                break;
            case BAS:
                // on descend une ligne
                y++;
                break;
            case DROITE:
                // on augmente colonne
                x++;
                break;
            case GAUCHE:
                // on augmente colonne
                x--;
                break;
            default:
                throw new Error("action inconnue");
        }
        return new int[]{x, y};
    }

    /**
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @return labyrinthe cree
     * @throws IOException probleme a la lecture / ouverture
     */



    public Labyrinthe(String nom) throws IOException {
        // ouvrir fichier
        FileReader fichier = new FileReader(nom);
        BufferedReader bfRead = new BufferedReader(fichier);

        int nbLignes, nbColonnes;
        // lecture nblignes
        nbLignes = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        nbColonnes = Integer.parseInt(bfRead.readLine());

        // creation labyrinthe vide
        this.murs = new boolean[nbColonnes][nbLignes];
        this.pj = null;

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;

        // parcours le fichier
        while (ligne != null) {

            // parcours de la ligne
            for (int colonne = 0; colonne < ligne.length(); colonne++) {
                char c = ligne.charAt(colonne);
                switch (c) {
                    case MUR:
                        this.murs[colonne][numeroLigne] = true;
                        break;
                    case VIDE:
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case PJ:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute PJ
                        this.pj = new Perso(colonne, numeroLigne);
                        break;
                    case MONSTRE:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute un monstre
                        this.m.add(new Monstre(colonne, numeroLigne));
                        break;
                    default:
                        throw new Error("caractere inconnu " + c);
                }
            }

            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }

        // ferme fichier
        bfRead.close();
    }


    /**
     * deplace le personnage en fonction de l'action.
     * gere la collision avec les murs
     *
     * @param action une des actions possibles
     */
    public void deplacerPerso(String action) {
        // case courante
        int[] courante = {this.pj.x, this.pj.y};

        // calcule case suivante
        int[] suivante = getSuivant(courante[0], courante[1], action);

        // si c'est pas un mur, on effectue le deplacement
        if ((!this.murs[suivante[0]][suivante[1]]) && (!this.getM(suivante[0], suivante[1]))) {
            // on met a jour personnage
            this.pj.x = suivante[0];
            this.pj.y = suivante[1];
        }
    }



    public void deplacerMonstre(int i) throws IOException {
        int alea = 1 /**(int) Math.floor(Math.random()*4)*/;
        String action = "";

        action = getProchaineAction(i);

        // case courante
        int[] courante = {this.m.get(i).getX(), this.m.get(i).getY()};

        // calcule case suivante
        int[] suivante = getSuivant(courante[0], courante[1], action);

        // si ce n'est pas un mur, on effectue le déplacement avec délai
            if ((!this.murs[suivante[0]][suivante[1]]) && (!this.getM(suivante[0], suivante[1]))) {
                // on met a jour personnage
                this.m.remove(i) ;
                this.m.add(i, new Monstre(suivante[0], suivante[1]));

            }
    }



    /**
     * jamais fini
     *
     * @return fin du jeu
     */
    public boolean etreFini() {
        return false;
    }

    // ##################################
    // GETTER
    // ##################################

    /**
     * return taille selon Y
     *
     * @return
     */
    public int getLengthY() {
        return murs[0].length;
    }

    /**
     * return taille selon X
     *
     * @return
     */
    public int getLength() {
        return murs.length;
    }

    /**
     * return mur en (i,j)
     * @param x
     * @param y
     * @return
     */
    public boolean getMur(int x, int y) {
        // utilise le tableau de boolean
        return this.murs[x][y];
    }

    public Perso getPj() {
        return pj;
    }

    public boolean[][] getMurs() {
        return murs;
    }

    public boolean getMurs(int x, int y) {
        // utilise le tableau de boolean
        return this.murs[x][y];
    }


    public boolean getM(int dx, int dy){
        boolean present = false;
        for (Monstre monstre : this.m){
            if ((monstre.getX() == dx) && (monstre.getY() == dy)){
                present = true;
            }
        }
        return present;
    }

    public GrapheListe genererGraphe() throws IOException {
        // Création du graphe vide
        GrapheListe g = new GrapheListe();
        // Création d'une table support pour stocker les indices des cases libres adjacentes (voir getAdjacent)
        int[][] tabTemp = new int[2][4];
        // Première boucle sur x
        for (int i = 0; i < getLengthY(); i++) {
            // Deuxième boucle sur y
            for (int j = 0; j < getLength(); j++) {
                // On regarde si à i,j il n'y a pas de mur
                if (!this.murs[j][i]){
                    // On récupère les cases adjacentes qui sont libres à i, j
                    tabTemp = this.getAdjacent(j, i);
                    // On parcourt tabTemp pour récupérer les cases adjacentes libres
                    for (int k = 0; k < tabTemp[0].length; k++) {
                        // On regarde si la place est libre (si ell ne l'est pas la valeur de la case est infini)
                        if (tabTemp[0][k] != Integer.MAX_VALUE){
                            // On ajoute finalement le noeud de départ, un noeud libre adjacent et le cout qui est de 1 pour tous
                            g.ajouterArc(j + ", " + i, tabTemp[0][k] + ", " + tabTemp[1][k], 1);
                        }
                    }
                }
            }
        }
        return g;
    }


    public int[][] getAdjacent(int x, int y){
        int[][] tab = new int[2][4];
        //on regarde si au dessus c'est libre
        if (!this.murs[x][y-1]){
            tab[0][0] = x;
            tab[1][0] = y-1;
        }
        else {
            tab[0][0] = Integer.MAX_VALUE;
            tab[1][0] = Integer.MAX_VALUE;
        }
        //pareil pour le dessous
        if (!this.murs[x][y+1]){
            tab[0][1] = x;
            tab[1][1] = y+1;
        }
        else {
            tab[0][1] = Integer.MAX_VALUE;
            tab[1][1] = Integer.MAX_VALUE;
        }
        //pareil pour la gauche
        if (!this.murs[x-1][y]){
            tab[0][2] = x-1;
            tab[1][2] = y;
        }
        else {
            tab[0][2] = Integer.MAX_VALUE;
            tab[1][2] = Integer.MAX_VALUE;
        }
        //pareil pour la droite
        if (!this.murs[x+1][y]){
            tab[0][3] = x+1;
            tab[1][3] = y;
        }
        else {
            tab[0][3] = Integer.MAX_VALUE;
            tab[1][3] = Integer.MAX_VALUE;
        }
        return tab;
    }

    public String getProchaineAction(int indiceMonstre) throws IOException {
        int xMonstre = this.m.get(indiceMonstre).getX();
        int yMonstre = this.m.get(indiceMonstre).getY();
        int xPj = this.pj.getX();
        int yPj = this.pj.getY();
        String action = "";
        String depart = xMonstre + ", " + yMonstre;
        String arrivee = xPj + ", " + yPj;
        Dijkstra d = new Dijkstra();
        Valeur v = d.resoudre(genererGraphe(), depart);
        ArrayList<String> chemin = v.calculerChemin(arrivee);
        String temp = chemin.toString();
        temp = temp.replace("[", "");
        temp = temp.replace("]", "");
        String[] tab = temp.split(", ");

        int nvX = Integer.parseInt(tab[2]);
        int nvY = Integer.parseInt(tab[3]);
        if ((nvX > xMonstre) && (nvY == yMonstre)){
            action = "Droite";
        }
        else if ((nvX < xMonstre) && (nvY == yMonstre)){
            action = "Gauche";
        } else if ((nvX == xMonstre) && (nvY < yMonstre)) {
            action = "Haut";
        }
        else {
            action = "Bas";
        }
        return action;
    }


}
