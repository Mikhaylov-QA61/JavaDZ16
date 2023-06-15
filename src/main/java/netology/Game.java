package netology;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {

    HashMap<String, Integer> playersList = new HashMap<>();

    public void registration(Player player) {
        playersList.put(player.getName(),player.getStrength());
    }

    public int round(String playerName1, String playerName2) {
        String player1[] = null;
        String player2[] = null;
        for ( String key : playersList.keySet()) {
            if (playersList.containsKey(playerName1)) {
                player1 = new String[]{"Зарегистрирован"};
            }
        }
        for (String key : playersList.keySet()) {
            if (playersList.containsKey(playerName2)) {
                player2 = new String[]{"Зарегистрирован"};
            }
        }

        if (player1 == null) {
            throw new NotFoundException("Игрок с именем " + playerName1 + " не зарегистрирован");
        }
        if (player2 == null) {
            throw new NotFoundException("Игрок с именем " + playerName2 + " не зарегистрирован");
        }
        if (playersList.get(playerName1) > playersList.get(playerName2)) {
            return 1;
        }
        if (playersList.get(playerName1) < playersList.get(playerName2)) {
            return 2;
        }
        return 0;
    }
}
