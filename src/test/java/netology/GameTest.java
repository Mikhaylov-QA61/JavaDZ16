package netology;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class GameTest {

    Game game = new Game();
    Player player1 = new Player(33, "Boy3000", 150);
    Player player2 = new Player(10, "Robokop", 150);
    Player player3 = new Player(54, "Nagibator", 10);
    Player player4 = new Player(29, "PRO100Petya", 666);

    public void setup() {
        game.registration(player1);
        game.registration(player2);
        game.registration(player4);
    }

    @Test
    public void winFirstPlayer() {
        setup();

        int expected = 1;
        int actual = game.round("PRO100Petya", "Robokop");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void winSecondPlayer() {
        setup();

        int expected = 2;
        int actual = game.round("Boy3000", "PRO100Petya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void winDraw() {
        setup();

        int expected = 0;
        int actual = game.round("Boy3000", "Robokop");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotRegistered() {
        setup();

        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round("Nagibator", "Robokop");
        });
    }

    @Test
    public void secondPlayerNotRegistered() {
        setup();

        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round("PRO100Petya", "Nagibator");
        });
    }
}
