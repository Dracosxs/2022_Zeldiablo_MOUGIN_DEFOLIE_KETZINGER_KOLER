package gameLaby.laby;

public class Joueur extends Perso{

    int piecesRammassees ;
    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Joueur(int dx, int dy) {
        super(dx, dy);
        this.piecesRammassees = 0;
    }


    public void PieceRammasee(int xPiece, int yPiece){
        if ((this.x==xPiece) && (this.y==yPiece)){
            this.piecesRammassees++;
        }
    }

    public int getPiecesRammassees() {
        return piecesRammassees;
    }
}
