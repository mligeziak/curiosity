package pl.mligeza.curiosity.server;

import com.badlogic.gdx.math.Vector2;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import pl.mligeza.curiosity.level.Level;
import pl.mligeza.curiosity.level.tiles.EmptyTile;
import pl.mligeza.curiosity.level.tiles.Level1Tile;
import pl.mligeza.curiosity.level.tiles.Tile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CuriosityServer {
    private static List<Player> players;
    private static Server server;
    private static int nextPlayerNumber;
    private static Level level;
    private static int levelLayers;
    private static final int LEVEL_W = 8; // NOTE(hubert): max 16x16
    private static final int LEVEL_H = 8;

    public static void main(String[] args) throws IOException {
        Tile.initTiles();

        players = new ArrayList<>();
        server = new Server();
        levelLayers = 2;
        nextPlayerNumber = 1;

        level = new Level(LEVEL_W, LEVEL_H, levelLayers);

        Kryo kryo = server.getKryo();
        kryo.register(Player.class);
        kryo.register(Request.class);
        kryo.register(Level.class);
        kryo.register(Vector2.class);
        kryo.register(int[].class);
        kryo.register(Tile[].class);

        kryo.register(EmptyTile.class);
        kryo.register(Level1Tile.class);

        server.start();
        server.bind(54555, 54777);

        server.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                if (object instanceof Player) {
                    Player player = (Player)object;
                    player.connection = connection;
                    player.number = nextPlayerNumber;
                    nextPlayerNumber++;
                    players.add(player);
                } else if (object instanceof Request) {
                    Request request = (Request)object;
                    if (request.request.equals("GET_LEVEL")) {
                        connection.sendTCP(level);
                    }
                } else if (object instanceof Vector2) {
                    Vector2 destroy = (Vector2)object;
                    //level.hitTile((int)destroy.x, (int)destroy.y);
                    sendToAll(destroy);

                    final boolean isLevelCleared = level.isClear();
                    System.out.println("isLevelCleared = " + isLevelCleared);
                    if (isLevelCleared) {
                        System.out.println("Level wyczyszczony");
                        levelLayers--;
                        if (levelLayers == 0) {
                            Player player = findPlayerByConnection(connection);
                            System.out.println("Wygrał gracz" + player.number);
                        } else {
                            level.generateLevel(new Level1Tile(Tile.level1Tile));
                            sendToAll(level);
                        }
                    }
                }
            }
        });
    }

    public static Player findPlayerByConnection(Connection connection) {
        for (Player player : players) {
            if (player.connection.equals(connection)) {
                return player;
            }
        }
        return null;
    }

    public static void sendToAll(Object object) {
        for (Player player : players) {
            player.connection.sendTCP(object);
        }
    }
}