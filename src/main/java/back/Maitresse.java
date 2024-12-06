package back;

public class Maitresse extends Personne{
    private final double rechargement = Conf.TMPS_RCHARGMNT_ACTION;
    public int nb_sachet_trouve = 0;
    public Maitresse(Pos pos_depart){
        super(pos_depart);
        this.type_entite = Conf.maitresse_type;
        this.vitesse = Conf.VITESSE_MAITRESSE;
    }

    @Override
    public void deplacement(Game game) {

    }

    public void action_concentration(){

    }
}
