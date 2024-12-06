package back;

public class Enfant extends Personne{
    private final int vitesse =  Conf.VITESSE_ENFANT;

    public Enfant(Pos pos_depart){
        super(pos_depart);
        this.type_entite = Conf.enfant_type;
    }

    public double getBruit() {
        return Conf.BRUIT_ENFANT;
    }

    private double calcul_distance(Entite e){
        return Math.sqrt(
                Math.pow((pos_actuelle.x - e.pos_actuelle.x),2) +
                Math.pow((pos_actuelle.y - e.pos_actuelle.y),2)
        );
    }
    private double calcul_distance(int x,int y,Entite e){
        return Math.sqrt(
                Math.pow((x - e.pos_actuelle.x),2) +
                Math.pow((y - e.pos_actuelle.y),2)
        );
    }

    @Override
    public void deplacement(Game game) {

    }
}
