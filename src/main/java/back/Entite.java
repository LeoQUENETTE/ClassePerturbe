package back;

public abstract class Entite {
    protected Pos pos_depart;
    protected Pos pos_actuelle;
    public String type_entite;

    public Entite(Pos pos_depart) {
        this.pos_depart = pos_depart;
    }

    public Pos getPos_depart() {
        return pos_depart;
    }

    public Pos getPos_actuelle() {
        return pos_actuelle;
    }

    public int getXDepart(){
        return pos_depart.x;
    }
    public int getYDepart(){
        return pos_depart.y;
    }
    public int getXActuelle(){
        return pos_actuelle.x;
    }
    public int getYActuelle(){
        return pos_actuelle.y;
    }
}
