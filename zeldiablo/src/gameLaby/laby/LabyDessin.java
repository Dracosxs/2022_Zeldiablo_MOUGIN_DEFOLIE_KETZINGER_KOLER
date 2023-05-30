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

        for (int y = 0; y < laby.getL().getLengthY(); y++) {
            // affiche la ligne
            for (int x = 0; x < laby.getL().getLength(); x++) {
                if (laby.getL().getMur(x, y)) {
                    gc.setFill(Color.BLACK);
                    gc.fillRect(laby.tailleCase*x, laby.tailleCase*y, laby.tailleCase, laby.tailleCase);
                }else if ((laby.getL().getPj().getX()==x) && (laby.getL().getPj().getY()==y)) {
                    gc.setFill(Color.RED);
                    gc.fillOval(laby.tailleCase*x, laby.tailleCase*y, laby.tailleCase, laby.tailleCase);
                }else {
                    gc.setFill(Color.LIGHTGRAY);
                    gc.fillRect(laby.tailleCase*x, laby.tailleCase*y, laby.tailleCase, laby.tailleCase);
                }
            }
        }
    }
}