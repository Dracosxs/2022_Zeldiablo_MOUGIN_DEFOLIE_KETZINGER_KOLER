package Graphe;

import ALGO.Dijkstra;
import ALGO.Valeur;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * La classe GrapheListe représente un graphe utilisant une représentation par liste d'adjacence.
 */


public class GrapheListe implements Graphe {

    // Attributs //

    // Liste des noms des nœuds du graphe
    private List<String> ensNom;

    // Liste des nœuds du graphe avec leurs arcs adjacents
    private List<Noeud> ensNoeuds;


    // Constructeurs //

    /**
     * Constructeur de la classe GrapheListe à partir d'un fichier.
     *
     * @param fichier Le nom du fichier contenant les informations du graphe.
     * @throws IOException Si une erreur de lecture du fichier se produit.
     */
    public GrapheListe(String fichier) throws IOException {
        // Initialisation de ensNom et de ensNoeuds
        this.ensNom = new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();

        // Création d'un BufferedReader pour le fichier passé en paramètre
        BufferedReader b = new BufferedReader(new FileReader(fichier));

        // On lit la première ligne
        String s = b.readLine();
        // On crée un tableau de String pour récupérer les données contenues dans les lignes du fichier après un split
        String[] tab;

        // Création d'une boucle permettant de parcourir toutes les lignes du fichier
        while (s != null) {
            // On remplit le tableau avec la méthode split() pour enlever les tabulations entre les valeurs qui nous intéressent
            tab = s.split("\t");
            // On ajoute l'arc tel que le premier terme correspond au départ, le deuxième à la destination et le troisième au coût
            this.ajouterArc(tab[0], tab[1], Double.parseDouble(tab[2]));
            //On lit la prochaine ligne
            s = b.readLine();
        }
        //On ferme le BufferedReader
        b.close();
    }

    /**
     * Constructeur par défaut de la classe GrapheListe.
     */
    public GrapheListe() {
        // Initialisation de ensNom et de ensNoeuds
        this.ensNom = new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();
    }

    /**
     * Constructeur de la classe GrapheListe.
     *
     * @param nbNoeud Le nombre de nœuds à créer dans le graphe.
     */
    public GrapheListe(int nbNoeud) {
        // Initialisation de ensNom et de ensNoeuds
        this.ensNom = new ArrayList<String>();
        this.ensNoeuds = new ArrayList<Noeud>();

        // Création des noeuds avec des noms numériques (1, 2, 3, ...)
        for (int i = 1; i < nbNoeud + 1; i++) {
            this.ensNom.add(String.valueOf(i));
            this.ensNoeuds.add(new Noeud(String.valueOf(i)));
        }

        // Création des arcs entre les noeuds consécutifs avec des poids aléatoires
        for (int i = 0; i < nbNoeud; i++) {
            if (i == this.ensNom.size() - 1) {
                this.ajouterArc(this.ensNom.get(i), this.ensNom.get(0), Math.floor(Math.random() * 99 + 1));
            } else {
                this.ajouterArc(this.ensNom.get(i), this.ensNom.get(i + 1), Math.floor(Math.random() * 99 + 1));
            }
        }

        // Création d'arcs supplémentaires de manière aléatoire entre les noeuds (minimum d'un noeud supplémentaire (2 au total))
        for (int i = 0; i < this.ensNom.size(); i++) {
            for (int j = 0; j < Math.random() * nbNoeud / 4; j++) {
                String destination = this.ensNom.get((int) (Math.random() * nbNoeud));
                String nvDestination = "";

                // Vérification si un arc vers la destination existe déjà
                for (Noeud n : this.ensNoeuds) {
                    if (n.getNom().equals(this.ensNom.get(i))) {
                        boolean existant = true;
                        while (existant) {
                            for (Arc a : n.getAdj()) {
                                if (a.getDest().equals(destination)) {
                                    nvDestination = this.ensNom.get((int) (Math.random() * nbNoeud));
                                }
                            }
                            if ((nvDestination.equals(this.ensNom.get(i))) || (destination.equals(this.ensNom.get(i)))){
                                nvDestination = this.ensNom.get((int) (Math.random() * nbNoeud));
                            }
                            if (nvDestination.equals("")) {
                                existant = false;
                            } else {
                                destination = nvDestination;
                                nvDestination = "";
                            }
                        }
                    }
                }

                // Ajout de l'arc avec un poids aléatoire
                ajouterArc(this.ensNom.get(i), destination, Math.floor(Math.random() * 99 + 1));
            }
        }
    }


    // Méthodes //

    /**
     * Ajoute un arc reliant deux nœuds dans le graphe.
     *
     * @param depart      Le nom du nœud de départ de l'arc.
     * @param destination Le nom du nœud de destination de l'arc.
     * @param cout        Le coût associé à l'arc.
     */
    public void ajouterArc(String depart, String destination, double cout){
        // On regarde si le noeud de départ est inexistant
        if (!this.ensNom.contains(depart)){
            // Si c'est le cas, on le crée
            Noeud nd = new Noeud(depart);
            // On l'ajoute dans ensNom et dans ensNoeuds
            this.ensNom.add(depart);
            this.ensNoeuds.add(nd);
        }
        // On regarde si le noeud de destination est inexistant
        if (!this.ensNom.contains(destination)) {
            // Si c'est le cas, on le crée
            Noeud nf = new Noeud(destination);
            // On l'ajoute dans ensNom et dans ensNoeuds
            this.ensNom.add(destination);
            this.ensNoeuds.add(nf);
        }

        // On parcourt la liste des Noeuds
        for (Noeud i : this.ensNoeuds) {
            // On cherche le noeud i correspondant au noeud de départ
            if (i.getNom().equals(depart)) {
                // Une fois trouvé, on lui ajoute un arc avec destination et cout passés en paramètre
                i.ajouterArc(destination, cout);
            }
        }
    }


    /**
     * Convertit un fichier au format matrice en un graphe représenté par liste d'adjacence.
     *
     * @param nomFichier Le nom du fichier contenant la matrice du graphe.
     * @return String Le nom du fichier créé contenant le graphe au format liste d'adjacence.
     * @throws IOException Si une erreur de lecture ou d'écriture du fichier se produit.
     */
    public String convertisseurMatrice(String nomFichier) throws IOException {
        // Création d'un BufferedReader lisant le contenu de nomFichier
        BufferedReader b = new BufferedReader(new FileReader(nomFichier));
        // Création d'un graphe vide
        GrapheListe g = new GrapheListe();
        // On lit la première ligne
        String s = b.readLine();
        // On crée un tableau de String pour récupérer les données contenues dans les lignes du fichier après un split
        String[] tab;
        tab = s.split("\t");
        for (int i = 1; i < tab.length; i++) {
            Noeud n = new Noeud(tab[i]);
            g.ensNom.add(tab[i]);
        }
        s = b.readLine();
        String s1;
        while (s != null) {
            tab = s.split("\t");
            s1 = tab[0];
            for (int i = 1; i < tab.length; i++) {
                if (!tab[i].equals("0.")) {
                    g.ajouterArc(s1, g.ensNom.get(i - 1), Double.parseDouble(tab[i]));
                }
            }
            s = b.readLine();
        }
        FileWriter nvFichier = new FileWriter("Graphe_Exemple_1");
        for (int i = 0; i < g.ensNom.size(); i++) {
            for (int j = 0; j < g.ensNoeuds.size(); j++) {
                if (g.ensNoeuds.get(j).getNom().equals(g.ensNom.get(i))) {
                    for (int k = 0; k < g.ensNoeuds.get(j).getAdj().size(); k++) {
                        nvFichier.write(g.ensNom.get(i) + "\t" + g.ensNoeuds.get(j).getAdj().get(k).getDest() + "\t" + g.ensNoeuds.get(j).getAdj().get(k).getCout() + "\n");
                    }
                }
            }
        }
        nvFichier.close();
        return "Graphe_Exemple_1";
    }

    /**
     * Renvoie une représentation textuelle du graphe.
     *
     * @return Une chaîne de caractères représentant le graphe.
     */
    public String toString() {
        StringBuilder s = new StringBuilder("--------------------------------FICHIER-------------------------------- \n");
        for (Noeud noeud : this.ensNoeuds) {
            s.append(noeud.getNom()).append(" -> ");
            for (Arc arc : noeud.getAdj()) {
                s.append(arc.getDest()).append("(").append((int) arc.getCout()).append(") ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * Renvoie une représentation du graphe au format Graphviz.
     *
     * @return Une chaîne de caractères représentant le graphe au format Graphviz.
     */
    public String toGraphviz() {
        StringBuilder s = new StringBuilder("");
        s.append("digraph G {\n");
        for (Noeud noeud : this.ensNoeuds) {
            for (Arc arc : noeud.getAdj()) {
                s.append(noeud.getNom()).append(" -> ");
                s.append(arc.getDest()).append(" [label = ").append((int) arc.getCout()).append("] ");
                s.append("\n");
            }
        }

        s.append("}\n");
        return s.toString();
    }

    /**
     * Crée un fichier PlantUML à partir du graphe au format Graphviz.
     *
     * @param fichierPlantUML Le nom du fichier PlantUML à créer.
     */
    public void toGraphviztoPlantUMLFile(String fichierPlantUML) {
        try {
            FileWriter writer = new FileWriter(fichierPlantUML);
            writer.write("@startuml\n");
            writer.write("digraph G {\n");
            for (Noeud noeud : this.ensNoeuds) {
                for (Arc arc : noeud.getAdj()) {
                    writer.write(noeud.getNom() + " -> " + arc.getDest() + " [label = " + (int) arc.getCout() + "]\n");
                }
            }
            writer.write("}\n");
            writer.write("@enduml\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de la création du fichier PlantUML.");
            e.printStackTrace();
        }
    }

    /**
     * Retourne la liste des noms des nœuds du graphe.
     *
     * @return La liste des noms des nœuds du graphe.
     */
    public List<String> getEnsNom() {
        return ensNom;
    }

    /**
     * Retourne la liste des nœuds du graphe avec leurs arcs adjacents.
     *
     * @return La liste des nœuds du graphe.
     */
    public List<Noeud> getEnsNoeuds() {
        return ensNoeuds;
    }

    /**
     * Retourne le nombre de nœuds dans le graphe.
     *
     * @return Le nombre de nœuds dans le graphe.
     */
    public int getNombreNoeuds() {
        return ensNoeuds.size();
    }

    /**
     * Retourne le nombre d'arcs dans le graphe.
     *
     * @return Le nombre d'arcs dans le graphe.
     */
    public int getNombreArcs() {
        int count = 0;
        for (Noeud noeud : ensNoeuds) {
            count += noeud.getAdj().size();
        }
        return count;
    }

    /**
     * Méthode non implémentée.
     *
     * @return Une erreur indiquant que la méthode n'est pas encore implémentée.
     */
    public int estVide() {
        if (this.ensNom.isEmpty()) {
            return 1;
        } else {
            return 0;
        }

    }

    /**
     * Retourne la liste des noms des nœuds du graphe.
     *
     * @return La liste des noms des nœuds du graphe.
     */
    public List<String> listeNoeuds() {
        return this.ensNom;
    }

    /**
     * Retourne la liste des arcs adjacents à un nœud donné.
     *
     * @param n Le nom du nœud.
     * @return La liste des arcs adjacents au nœud.
     */
    public List<Arc> suivants(String n) {
        List<Arc> s = new ArrayList<>();

        for (Noeud noeud : this.ensNoeuds)
            if (n.equals(noeud.getNom()))
                s = noeud.getAdj();

        return s;
    }

}
