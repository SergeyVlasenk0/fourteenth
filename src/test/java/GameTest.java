import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testFirstPlayerWin() {

        Game game = new Game();
        Player player1 = new Player(1, "Sergey", 90);
        Player player2 = new Player(2, "Andrey", 70);
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("Sergey", "Andrey");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSecondPlayerWin() {

        Game game = new Game();
        Player player1 = new Player(1, "Sergey", 70);
        Player player2 = new Player(2, "Andrey", 90);
        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round("Sergey", "Andrey");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDraw() {

        Game game = new Game();
        Player player1 = new Player(1, "Sergey", 70);
        Player player2 = new Player(2, "Andrey", 70);
        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round("Sergey", "Andrey");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFirstPlayerUnknown() {

        Game game = new Game();
        Player player1 = new Player(1, "Sergey", 70);
        Player player2 = new Player(2, "Andrey", 90);

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Sergey", "Andrey"));
    }

    @Test
    public void testSecondPlayerUnknown() {

        Game game = new Game();
        Player player1 = new Player(1, "Sergey", 70);
        Player player2 = new Player(2, "Andrey", 90);

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Sergey", "Andrey"));
    }

    @Test
    public void testId() {

        Game game = new Game();
        Player player1 = new Player(1, "Sergey", 70);
        Player player2 = new Player(2, "Andrey", 80);


        int expected = 1;
        int actual = player1.getId();

        Assertions.assertEquals(expected, actual);
    }
}
