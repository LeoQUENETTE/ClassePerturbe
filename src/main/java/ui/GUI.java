package ui;

import back.Classe;

public class GUI {
    public static void affiche_classe(Classe classe) {
        for (String[] ligne : classe.getEntitePos()){
            int count = 0;
            for (String entite_type : ligne) {
                if (count == 0){
                    System.out.print(" ");
                }
                if (entite_type != null) {
                    System.out.print(entite_type+" ");
                }else{
                    System.out.print(". ");
                }
                count++;
            }
            System.out.println();
        }
    }
}
