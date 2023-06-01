package ALGO;

import Graphe.Graphe;
import Graphe.Arc;

import java.util.ArrayList;

public class Dijkstra {

    public Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur();
        ArrayList<String> Q = new ArrayList<>();
        for (String s :g.listeNoeuds()) {
            v.setValeur(s, Double.MAX_VALUE);
            v.setParent(s, null);
            Q.add(s);
        }
        v.setValeur(depart, 0);
        while (!Q.isEmpty()){
            String u = Q.get(0);
            double distanceMin = Double.MAX_VALUE;
            for (String s : Q) {
                if (v.getValeur(s) < v.getValeur(u)){
                    u = s;
                    distanceMin = v.getValeur(s);
                }
            }
            Q.remove(u);
            for (Arc a : g.suivants(u)) {
                if (Q.contains(a.getDest())){
                    double distanceTotaleActuelle = v.getValeur(u) + a.getCout();
                    if (distanceTotaleActuelle < v.getValeur(a.getDest())){
                        v.setParent(a.getDest(), u);
                        v.setValeur(a.getDest(), distanceTotaleActuelle);
                    }
                }
            }
            //System.out.println(v);
        }
        return v;
    }
}




/**
 * Entrées :
 *
 * G un graphe orienté avec une pondération (poids) positive des arcs
 * A un sommet (d´epart) de G
 *
 * Début
 * Q <- {} // utilisation d’une liste de noeuds à traiter
 * Pour chaque sommet v de G faire
 * 	v.distance <- Infini
 * 	v.parent <- Indéfini
 * 	Q <- Q U {v} // ajouter le sommet v à la liste Q
 * Fin Pour
 * A.distance <- 0
 * Tant que Q est un ensemble non vide faire
 * 	u <- un sommet de Q telle que u.distance est minimale
 * 	Q <- Q \ {u} // enlever le sommet u de la liste Q
 * 	Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
 * 		D <- u.distance + poids(u,v)
 * 		Si D < v.distance
 * 			Alors v.distance <- D
 * 			v.parent <- u
 * 		Fin Si
 * 	Fin Pour
 * Fin Tant que
 * Fin
 */