package back;

public class Enfant extends Personne{
    private final int vitesse =  Conf.VITESSE_ENFANT;
    public boolean a_bonbon = false;
    public boolean a_sachet = false;

    public Enfant(Pos pos_depart){
        super(pos_depart);
        this.type_entite = Conf.enfant_type;
    }

    public double getBruit() {
        return Conf.BRUIT_ENFANT;
    }

    private double calcul_distance(Enfant e){
        return Math.sqrt(
                Math.pow((pos_actuelle.x - e.pos_actuelle.x),2) +
                Math.pow((pos_actuelle.y - e.pos_actuelle.y),2)
        );
    }

    @Override
    public void deplacement(Game game) {
        Pos new_pos = new Pos(pos_actuelle);
        
        //Choix direction
        //Récupération de l'enfant le plus proche
        Enfant enfant_proche = null;
        double distance_min = 0;
        for (Enfant e : game.liste_enfant){
            if (!e.a_bonbon && !e.a_sachet){
                double distance_e = calcul_distance(e);
                if (enfant_proche == null){
                    enfant_proche = e;
                    distance_min = distance_e;
                }
                if (distance_min > distance_e){
                    enfant_proche = e;
                }
            }
        }
        //Calcul de la future position
        /*
        *
        * */
        assert enfant_proche != null;
        if (enfant_proche.getYActuelle() > pos_actuelle.y){
            new_pos.y += vitesse;
        } else if (enfant_proche.getXActuelle() > pos_actuelle.x) {
            new_pos.x += vitesse;
        } else if (enfant_proche.getXActuelle() < pos_actuelle.x) {
            new_pos.x -= vitesse;
        } else if (enfant_proche.getYActuelle() < pos_actuelle.y) {
            new_pos.y -= vitesse;
        }
        String[][] classe = game.classe.getEntitePos();
        if (classe[new_pos.y][new_pos.x] == null){
            pos_actuelle.x = new_pos.x;
            pos_actuelle.y = new_pos.y;
        }
    }
}
