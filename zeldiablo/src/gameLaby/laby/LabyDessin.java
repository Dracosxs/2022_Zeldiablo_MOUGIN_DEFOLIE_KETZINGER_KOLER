package gameLaby.laby;

import gameLaby.laby.outils.Sprite;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

public class LabyDessin implements DessinJeu {

    public Image imageMur;

    public Image imagePnj;

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {

//        try {
//            Image image = new Image("file:Resources/mur.png");
//            // Image chargée avec succès, vous pouvez continuer à utiliser l'image
//        } catch (Exception e) {
//            System.err.println("Erreur lors du chargement de l'image : " + e.getMessage());
//            // Gérer l'erreur, afficher un message d'erreur ou effectuer d'autres actions nécessaires
//        }



        this.imageMur = Sprite.MUR;

        this.imagePnj = Sprite.PNJ;


        LabyJeu laby = (LabyJeu) jeu;

        // recupere un pinceau pour dessiner
        GraphicsContext gc = canvas.getGraphicsContext2D();

//        gc.drawImage(imageMur, 10 * 80,  10 * 80);



        for (int y = 0; y < laby.getL().getLengthY(); y++) {
            // affiche la ligne
            for (int x = 0; x < laby.getL().getLength(); x++) {
                if (laby.getL().getMur(x, y)) {
                    gc.setFill(Color.BLACK);
                    gc.fillRect(laby.tailleCase*x, laby.tailleCase*y, laby.tailleCase, laby.tailleCase);
//                    System.out.println("x : " + laby.tailleCase * x + " y : " + laby.tailleCase * y);
//                    gc.drawImage(imageMur, laby.tailleCase * x, laby.tailleCase * y);


                }else if ((laby.getL().getJ().getX()==x) && (laby.getL().getJ().getY()==y)) {
                    gc.setFill(Color.LIGHTGRAY);
                    gc.fillRect(laby.tailleCase*x, laby.tailleCase*y, laby.tailleCase, laby.tailleCase);
                    gc.setFill(Color.RED);
                    gc.fillOval(laby.tailleCase*x, laby.tailleCase*y, laby.tailleCase, laby.tailleCase);

                }else if (laby.getL().getM(x, y)) {
                    gc.setFill(Color.DARKGREEN);
                    gc.fillOval(laby.tailleCase*x, laby.tailleCase*y, laby.tailleCase, laby.tailleCase);
                } else if (laby.getL().getPiecePresente(x, y)) {
                    gc.setFill(Color.LIGHTGRAY);
                    gc.fillRect(laby.tailleCase*x, laby.tailleCase*y, laby.tailleCase, laby.tailleCase);
                    gc.setFill(Color.YELLOW);
                    gc.fillOval(laby.tailleCase*x, laby.tailleCase*y, laby.tailleCase, laby.tailleCase);
                } else {
                    gc.setFill(Color.LIGHTGRAY);
                    gc.fillRect(laby.tailleCase*x, laby.tailleCase*y, laby.tailleCase, laby.tailleCase);
                }
            }
        }

    }
}