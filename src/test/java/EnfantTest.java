import back.Conf;
import back.Enfant;
import back.Game;
import back.Pos;
import org.junit.Assert;
import org.junit.Test;
import ui.GUI;

import java.lang.reflect.Method;

public class EnfantTest {
    private final Game game = new Game();

    @Test
    public void test_actions() throws Exception{

    }

    @Test
    public void test_calcul_distance() throws Exception{
        Pos pos1 = new Pos(2,3);
        Enfant e1 = new Enfant(pos1);
        Pos pos2 = new Pos(5,7);
        Enfant e2 = new Enfant(pos2);


        Method calcul_distance = Enfant.class.getDeclaredMethod("calcul_distance", Enfant.class);
        calcul_distance.setAccessible(true);
        double result = (double) calcul_distance.invoke(e1,e2);
        Assert.assertEquals((double) 5, result, 0);
    }

    @Test
    public void test_deplacement() throws Exception{
        Conf.set_nb_enfant_range(2);
        Conf.set_nb_range(1);
        Conf.VITESSE_ENFANT = 1;
        Conf.NB_SACHET_BONBON = 1;
        Game game = new Game();
        Enfant e1 =game.liste_enfant[0];
        Enfant e2 =game.liste_enfant[1];

        e2.a_sachet = false;
        e2.a_bonbon = false;

        e1.a_sachet = true;
        e1.a_bonbon = true;
        Method method = game.getClass().getDeclaredMethod("deplacer_persos");
        method.setAccessible(true);
        method.invoke(game);

        game.classe.maj_pos_entite(game.liste_enfant);
        GUI.affiche_classe(game.classe);
    }
}
