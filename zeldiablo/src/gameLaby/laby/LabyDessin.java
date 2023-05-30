package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

public class LabyDessin implements DessinJeu {
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu laby = (LabyJeu) jeu;

        // recupere un pinceau pour dessiner
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        // dessin fond
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());


        for (int y = 0; y < laby.getL().getLengthY(); y++) {
            // affiche la ligne
            for (int x = 0; x < laby.getL().getLength(); x++) {
                if (laby.getL().getMur(x, y))
                    gc.setFill(Color.BLACK);
                    gc.fillRect(0, 0, x, y);
                else if ((laby.getL().getPj().getX()==x) && (laby.getL().getPj().getY()==y)) {
                    gc.setFill(Color.RED);
                    gc.fillRect(0, 0, x, y);
                }
            }
            // saut de ligne
            System.out.println();
        }
    }
}
