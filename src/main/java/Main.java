import back.Conf;
import back.Game;
import back.Pos;
import ui.GUI;
import ui.UI;

public class Main {
    public static void main(String[] args) {

        Conf.set_nb_enfant_range(5);
        Conf.set_nb_range(5);
        Conf.set_dist_enfant(5);
        Conf.set_dist_range_enfant(5);
        Conf.NB_SACHET_BONBON = 2;
        Game game = new Game();

        UI ui = new UI();
        // Lancer l'interface utilisateur avec le tableau
        ui.lancerUi(game.classe.getEntitePos());
    }
}