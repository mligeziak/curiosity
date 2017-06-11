package pl.mligeza.curiosity.server;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CuriosityServer {
    private static List<Player> players;
    private static Server server;
    private static int nextPlayerNumber;

    public static void main (String[] args) throws IOException {
        players = new ArrayList<>();
        server = new Server();
        nextPlayerNumber = 1;

        Kryo kryo = server.getKryo();
        kryo.register(Player.class);

        server.start();
        server.bind(54555, 54777);

        server.addListener(new Listener() {
            public void received (Connection connection, Object object) {
                if (object instanceof Player) {
                    Player player = (Player) object;
                    player.connection = connection;
                    player.number = nextPlayerNumber;
                    nextPlayerNumber++;
                    players.add(player);
                }
            }
        });
    }

    public static Player findPlayerByConnection(Connection connection) {
        for(Player player : players) {
            if(player.connection.equals(connection)) {
                return player;
            }
        }
        return null;
    }

    public static void sendToAll(Object object) {
        for(Player player : players) {
            player.connection.sendTCP(object);
        }
    }
}