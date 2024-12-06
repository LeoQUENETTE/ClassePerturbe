package back;

public abstract class Personne extends Entite{
    protected int vitesse;
    public Personne(Pos pos_depart) {
        super(pos_depart);
        this.pos_actuelle = this.pos_depart;
    }

    public abstract void deplacement(Game game);
}
