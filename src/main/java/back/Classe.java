package back;

import java.util.Random;

public class Classe {
    private final String[][] entite_pos = new String[Conf.getProfondeurClasse()][Conf.getLargeurClasse()];
    private final Double[][] bruit_ambient = new Double[Conf.getProfondeurClasse()][Conf.getLargeurClasse()];

    public Classe(Entite[] entites){
        maj_pos_entite(entites);
    }

    public void maj_pos_entite(Entite[] entites){
        for (String[] entites_ligne : entite_pos) {
            for (String entite : entites_ligne){
                entite = "";
            }
        }
        //Mettre à jour en fonction des position relative a chaque entite
        for (Entite entite : entites){
            entite_pos[entite.getYActuelle()][entite.getXActuelle()] = entite.type_entite;
        }

    }

    public void maj_bruit_amb(){
        for (Double[] bruit_ligne : bruit_ambient) {
            for (Double bruit : bruit_ligne){
                if (bruit == null){
                    bruit = (double) 0;
                }
            }
        }
        //Mettre à jour en fonction des valeurs de bruit de chaque enfant et de leur position relative
    }

    public String[][] getEntitePos(){
        return entite_pos;
    }

    public Double[][] getBruitAmb(){
        return bruit_ambient;
    }
}
