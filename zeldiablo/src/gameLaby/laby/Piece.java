package gameLaby.laby;

public class Piece {

    private int x, y;

    private boolean pieceRecuperee;

    public Piece(int dx, int dy){
        this.x = dx;
        this.y = dy;
        this.pieceRecuperee = false;
    }

    public void setPieceRecuperee(){
        this.pieceRecuperee = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getPieceRecuperee() {
        return pieceRecuperee;
    }
}
