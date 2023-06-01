package Graphe;

/**
 * La classe Arc représente un arc reliant deux nœuds dans un graphe.
 */
public class Arc {

    // c'est le string qui représente la destination du nœud
    private String dest;

    // c'est le coût de l'arc
    private double cout;


    /**
     * Constructeur de la classe Arc.
     *
     * @param dest La destination du nœud vers lequel cet arc pointe.
     * @param cout Le coût associé à cet arc.
     */
    public Arc (String dest, double cout) {
        this.dest = dest;

        // Assure que le coût de l'arc est toujours positif ou nul
        if (cout <= 0) {
            this.cout = cout * -1;
        }
        else {
            this.cout = cout;
        }
    }

    /**
     * Renvoie la destination du nœud vers lequel cet arc pointe.
     *
     * @return La destination du nœud.
     */
    public String getDest() {
        return this.dest;
    }

    /**
     * Renvoie le coût associé à cet arc.
     *
     * @return Le coût de l'arc.
     */
    public double getCout() {
        return this.cout;
    }
}