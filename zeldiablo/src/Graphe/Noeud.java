package Graphe;

import java.util.ArrayList;
import java.util.List;

public class Noeud {

    // Attributs
    private String nom;
    private List<Arc> adj;

    /**
     * Constructeur de la classe Noeud.
     *
     * @param n Le nom du nœud.
     */
    public Noeud(String n) {
        this.nom = n;
        this.adj = new ArrayList<Arc>();
    }

    /**
     * Vérifie l'égalité entre l'objet courant et un autre objet donné.
     *
     * @param o L'objet à comparer.
     * @return true si les deux objets sont égaux, false sinon.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Noeud noeud = (Noeud) o;
        return nom.equals(noeud.nom);
    }

    /**
     * Retourne le nom du nœud.
     *
     * @return Le nom du nœud.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Retourne la liste des arcs adjacents au nœud.
     *
     * @return La liste des arcs adjacents au nœud.
     */
    public List<Arc> getAdj() {
        return this.adj;
    }

    /**
     * Ajoute un arc reliant le nœud à une destination avec un coût donné.
     *
     * @param destination La destination du nouvel arc.
     * @param cout        Le coût du nouvel arc.
     */
    public void ajouterArc(String destination, double cout) {
        Arc arc = new Arc(destination, cout);
        this.adj.add(arc);
    }
}
