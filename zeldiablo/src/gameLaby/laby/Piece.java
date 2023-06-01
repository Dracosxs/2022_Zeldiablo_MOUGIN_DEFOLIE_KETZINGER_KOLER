package gameLaby.laby;

public class Piece {

    int x, y;

    boolean pieceRecuperee;

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


}
