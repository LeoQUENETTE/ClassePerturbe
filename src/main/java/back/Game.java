package back;

import java.util.Random;

public class Game {
    public final Enfant[] liste_enfant = new Enfant[Conf.getNbEnfant()];
    public final Maitresse[] liste_maitresse = new Maitresse[Conf.NB_MAITRESSE];
    public Entite[] liste_entite = new Entite[liste_enfant.length + liste_maitresse.length];
    public final Classe classe;

    public Game(){
        generation_enfant();
        generation_maitresse();
        maj_liste_entite();
        this.classe = new Classe(liste_entite);
//        game_cycle();
    }

    private void maj_liste_entite(){
        int count = 0;
        for (Maitresse maitresse : liste_maitresse) {
            liste_entite[count] = maitresse;
            count++;
        }
        for (Enfant enfant : liste_enfant) {
            liste_entite[count] = enfant;
            count++;
        }

    }

    private void deplacer_persos(){
        for (Enfant e : liste_enfant) {
            if (e.a_sachet){
                e.deplacement(this);
            }
        }
    }

    public void game_cycle(){
        while (!fin_jeu_enfant() && !fin_jeu_maitresse()){
            System.out.println("ok");
        }
        System.out.println("fin jeu");
    }

    private void generation_enfant(){
        int y = 0;
        for (int i = 0; i < Conf.getNbEnfant(); i++) {
            if ((i) % Conf.getNbEnfantRange() == 0 && i != 0){
                y +=Conf.getDistRangeEnfant();
            }
            Pos new_pos = new Pos((i % Conf.getNbEnfantRange()) * Conf.getDistEnfant(), y + Conf.getDistMaitresseEnfant());
            liste_enfant[i] = new Enfant(new_pos);
        }
        Random rand = new Random();
        for (int i = 0; i < Conf.NB_SACHET_BONBON; i++){
            boolean err = true;
            while (err){
                int enfant_pos = rand.nextInt(liste_enfant.length);
                if (!liste_enfant[enfant_pos].a_sachet){
                    liste_enfant[enfant_pos].a_bonbon = true;
                    liste_enfant[enfant_pos].a_sachet = true;
                    liste_enfant[enfant_pos].type_entite = "S";
                    err = false;
                }
            }
        }
    }
    private void generation_maitresse(){
        for (int i = 0; i < Conf.NB_MAITRESSE; i++) {
            Pos new_pos = new Pos(Conf.getLargeurClasse() / 2, 0);
            liste_maitresse[i] = new Maitresse(new_pos);
        }
    }

    private boolean fin_jeu_maitresse(){
        for (Maitresse maitresse : liste_maitresse){
            if (maitresse.nb_sachet_trouve != Conf.NB_SACHET_BONBON){
                return false;
            }
        }
        return true;
    }

    private boolean fin_jeu_enfant(){
        for (Enfant enfant : liste_enfant){
            if (!enfant.a_bonbon){
                return false;
            }
        }
        return true;
    }
}
