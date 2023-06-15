package netology;

import java.util.ArrayList;

public class Game {

    ArrayList<Player> playersList = new ArrayList<>();

    public void registration(Player player) {
        playersList.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : playersList) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotFoundException("Игрок с именем " + playerName1 + " не зарегистрирован");
        }
        if (player2 == null) {
            throw new NotFoundException("Игрок с именем " + playerName2 + " не зарегистрирован");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
