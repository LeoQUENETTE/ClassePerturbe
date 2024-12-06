package back;

public class Conf {
    //Variable en dur (Paramètre du jeu)
    //Variable accessible
    public static int NB_MAITRESSE = 1;
    public static int NB_SACHET_BONBON = 4;
    public static double TMPS_RCHARGMNT_ACTION = 2;
    public static double BRUIT_ENFANT = 1;
    public static int VITESSE_ENFANT = 1;
    public static int VITESSE_MAITRESSE = 2;

    //Variable nécessitant la privatisation (si modifié à la volé peut entrainer le plantage du jeu)
    private static int NB_ENFANT_RANGE = 5;
    private static int NB_RANGE = 3;
    private static int DIST_MAITRESSE_ENFANT = 2;
    private static int DIST_ENFANT = 2;
    private static int DIST_RANGE_ENFANT = 2;

    //Paramètre déduis des paramètres du jeu
    private static int NB_ENFANT = NB_ENFANT_RANGE * NB_RANGE;
    private static int LARGEUR_CLASSE = NB_ENFANT_RANGE*DIST_ENFANT-(DIST_ENFANT-1) ;
    private static int PROFONDEUR_CLASSE = NB_RANGE*DIST_RANGE_ENFANT+DIST_MAITRESSE_ENFANT-(DIST_RANGE_ENFANT-1);

    public static void set_nb_enfant_range(int nb){
        NB_ENFANT_RANGE = nb;
        NB_ENFANT = NB_ENFANT_RANGE * NB_RANGE;
        LARGEUR_CLASSE = NB_ENFANT_RANGE*DIST_ENFANT-(DIST_ENFANT-1) ;
    }
    public static void set_nb_range(int nb){
        NB_RANGE = nb;
        NB_ENFANT = NB_ENFANT_RANGE * NB_RANGE;
        PROFONDEUR_CLASSE = NB_RANGE*DIST_RANGE_ENFANT+DIST_MAITRESSE_ENFANT-(DIST_RANGE_ENFANT-1);
    }
    public static void set_dist_enfant(int nb){
        DIST_ENFANT = nb;
        LARGEUR_CLASSE = NB_ENFANT_RANGE*DIST_ENFANT-(DIST_ENFANT-1);
    }
    public static void set_dist_range_enfant(int nb){
        DIST_RANGE_ENFANT = nb;
        PROFONDEUR_CLASSE = NB_RANGE*DIST_RANGE_ENFANT+DIST_MAITRESSE_ENFANT-(DIST_RANGE_ENFANT-1);
    }
    public static void set_dist_maitresse_enfant(int nb){
        DIST_MAITRESSE_ENFANT = nb;
        PROFONDEUR_CLASSE = NB_RANGE*DIST_RANGE_ENFANT+DIST_MAITRESSE_ENFANT-(DIST_RANGE_ENFANT-1);
    }

    public static int getNbEnfantRange() {
        return NB_ENFANT_RANGE;
    }

    public static int getNbRange() {
        return NB_RANGE;
    }

    public static int getDistMaitresseEnfant() {
        return DIST_MAITRESSE_ENFANT;
    }

    public static int getDistEnfant() {
        return DIST_ENFANT;
    }

    public static int getDistRangeEnfant() {
        return DIST_RANGE_ENFANT;
    }

    public static int getNbEnfant() {
        return NB_ENFANT;
    }

    public static int getLargeurClasse() {
        return LARGEUR_CLASSE;
    }

    public static int getProfondeurClasse() {
        return PROFONDEUR_CLASSE;
    }

    //Variable UI
    public static final String enfant_type = "E";
    public static final String maitresse_type = "M";
}
