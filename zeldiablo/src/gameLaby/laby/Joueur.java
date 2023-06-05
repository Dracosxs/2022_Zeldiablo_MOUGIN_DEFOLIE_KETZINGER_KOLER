package gameLaby.laby;

public class Joueur extends Perso{

    private int piecesRamassees;
    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Joueur(int dx, int dy) {
        super(dx, dy);
        this.piecesRamassees = 0;
    }


    public void PieceRamasee(int xPiece, int yPiece){
        if ((this.getX()==xPiece) && (this.getY()==yPiece)){
            this.piecesRamassees++;
        }
    }

    public int getPiecesRamassees() {
        return piecesRamassees;
    }
}
