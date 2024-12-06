import back.Conf;
import back.Enfant;
import back.Game;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GameTest {

    private final Game game = new Game();

    @Test
    public void fin_jeu_maitresse_false() throws Exception {
        Method fin_jeu_maitresse = Game.class.getDeclaredMethod("fin_jeu_maitresse");
        fin_jeu_maitresse.setAccessible(true);
        boolean result = (boolean) fin_jeu_maitresse.invoke(game);
        Assert.assertFalse(result);
    }

    @Test
    public void fin_jeu_maitresse_true() throws Exception {
        game.liste_maitresse[0].nb_sachet_trouve = Conf.NB_SACHET_BONBON;
        Method fin_jeu_maitresse = Game.class.getDeclaredMethod("fin_jeu_maitresse");
        fin_jeu_maitresse.setAccessible(true);
        boolean result = (boolean) fin_jeu_maitresse.invoke(game);
        Assert.assertTrue(result);
    }

    @Test
    public void fin_jeu_enfant_false() throws Exception {
        Method fin_jeu_enfant = Game.class.getDeclaredMethod("fin_jeu_enfant");
        fin_jeu_enfant.setAccessible(true);
        boolean result = (boolean) fin_jeu_enfant.invoke(game);
        Assert.assertFalse(result);
    }

    @Test
    public void fin_jeu_enfant_true() throws Exception {
        Method fin_jeu_enfant = Game.class.getDeclaredMethod("fin_jeu_enfant");
        fin_jeu_enfant.setAccessible(true);

        for (Enfant e : game.liste_enfant){
            e.a_bonbon = true;
        }

        boolean result = (boolean) fin_jeu_enfant.invoke(game);
        Assert.assertTrue(result);
    }
}
