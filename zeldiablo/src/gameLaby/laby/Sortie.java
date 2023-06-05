package gameLaby.laby;

public class Sortie {

        private int xSortie, ySortie;

        private boolean affiche;


        public Sortie(int x, int y) {
            this.xSortie = x;
            this.ySortie = y;
            this.affiche = false;
        }

        public void afficherSortie() {
            this.affiche = true;
        }


        public boolean etreAffiche() {
            return this.affiche;
        }


        public int getX() {
            return this.xSortie;
        }

        public int getY() {
            return this.ySortie;
        }


    }


