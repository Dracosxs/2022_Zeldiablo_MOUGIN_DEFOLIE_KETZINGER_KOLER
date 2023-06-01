package gameLaby.laby.outils;

import gameLaby.laby.Sortie;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Sprite {

  public static Image MUR;

 public static Image PNJ;

 public static Image MONSTRE;

 public static Image PIECE;

 public static Image SORTIE;


 static {
  try {
   MUR = new Image(new FileInputStream("Ressources/mur.png"), 50, 50, false, false);
  } catch (FileNotFoundException e) {
   throw new RuntimeException(e);
  }
 }


 static {
  try {
   PNJ = new Image(new FileInputStream("Ressources/torche.png"), 50, 50, false, false);
  } catch (FileNotFoundException e) {
   throw new RuntimeException(e);
  }
    }

 static {
  try {
   MONSTRE = new Image(new FileInputStream("Ressources/monstre.png"), 50, 50, false, false);
  } catch (FileNotFoundException e) {
   throw new RuntimeException(e);
  }
 }


 static {
  try {
   PIECE = new Image(new FileInputStream("Ressources/euro.png"), 50, 50, false, false);
  } catch (FileNotFoundException e) {
   throw new RuntimeException(e);
  }
 }


 static {
  try {
   SORTIE = new Image(new FileInputStream("Ressources/piece.jpg"), 50, 50, false, false);
  } catch (FileNotFoundException e) {
   throw new RuntimeException(e);
  }
 }




}


