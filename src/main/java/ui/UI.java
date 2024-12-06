package ui;

import javax.swing.*;
import java.awt.*;

public class UI {
    // Constantes de configuration
    private static final int CASE_SIZE = 30;  // Taille de chaque case
    private static final Color BACKGROUND_COLOR = new Color(224, 122, 87);  // Beige
    private static int WIDTH;  // Largeur de la fenêtre (à ajuster selon la taille du tableau)
    private static int HEIGHT;  // Hauteur de la fenêtre (à ajuster selon la taille du tableau)

    // Méthode pour lancer l'UI
    public void lancerUi(String[][] classe) {
        // Création de la fenêtre
        JFrame frame = new JFrame("Affichage du tableau");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WIDTH = CASE_SIZE * classe[0].length + 60;
        HEIGHT = CASE_SIZE * classe.length + 60;
        frame.setSize(WIDTH, HEIGHT);
        frame.setContentPane(new DrawingPanel(classe));  // Ajouter le panneau de dessin
        frame.setVisible(true);
    }

    // Classe interne pour dessiner le tableau
    class DrawingPanel extends JPanel {
        private String[][] classe;

        // Constructeur du panneau
        public DrawingPanel(String[][] classe) {
            this.classe = classe;
        }

        // Méthode de dessin
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(BACKGROUND_COLOR);  // Définir la couleur de fond

            // Calculer la taille totale de la grille
            int totalWidth = classe[0].length * CASE_SIZE;
            int totalHeight = classe.length * CASE_SIZE;

            // Calculer les marges pour centrer la grille
            int marginX = (getWidth() - totalWidth) / 2;
            int marginY = (getHeight() - totalHeight) / 2;

            // Dessiner le tableau
            for (int i = 0; i < classe.length; i++) {
                for (int j = 0; j < classe[i].length; j++) {
                    int x = marginX + j * CASE_SIZE;
                    int y = marginY + i * CASE_SIZE;

                    // Dessiner un rectangle pour chaque case
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, CASE_SIZE, CASE_SIZE);

                    // Vérifier la valeur de la case et dessiner les cercles
                    if ("E".equals(classe[i][j])) {
                        g.setColor(Color.GREEN);  // Cercle vert pour "E"
                        g.fillOval(x + 5, y + 5, CASE_SIZE - 10, CASE_SIZE - 10);
                    } else if ("M".equals(classe[i][j])) {
                        g.setColor(Color.RED);  // Cercle rouge pour "M"
                        g.fillOval(x + 5, y + 5, CASE_SIZE - 10, CASE_SIZE - 10);
                    } else if ("S".equals(classe[i][j])) {
                        g.setColor(Color.BLUE);
                        g.fillOval(x + 5, y + 5, CASE_SIZE - 10, CASE_SIZE - 10);
                    }

                }
            }
        }
    }
}
