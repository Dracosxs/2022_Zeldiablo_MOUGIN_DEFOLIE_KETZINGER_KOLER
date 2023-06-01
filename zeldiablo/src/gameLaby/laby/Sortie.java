package gameLaby.laby;

public class Sortie {

        private int xSortie, ySortie;

        private boolean affiche;


        public Sortie(int x, int y) {
            this.xSortie = x;
            this.ySortie = y;
            this.affiche = false;
        }


        public boolean etrePresent(int x, int y) {
            return this.xSortie == x && this.ySortie == y;
        }


        public void afficherEscalier() {
            this.affiche = true;
        }


        public void cacherEscalier() {
            this.affiche = false;
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


