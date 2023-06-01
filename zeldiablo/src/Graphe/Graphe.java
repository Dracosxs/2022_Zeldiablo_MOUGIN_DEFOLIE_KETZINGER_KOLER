package Graphe;

import java.util.List;


public interface Graphe {

    /**
     * Méthode listeNoeuds() de l'interface Graphe.
     *
     * @return List<String>  Renvoie la liste des noms des noeuds du graphe.
     */
    public List<String> listeNoeuds();

    /**
     * Méthode suivants(String n) de l'interface Graphe.
     *
     * @param n Correspond au nom d'un noeud
     * @return List<Arc>  Renvoie la liste des arcs du noeud passé en paramètre.
     */
    public List<Arc> suivants(String n);
}
