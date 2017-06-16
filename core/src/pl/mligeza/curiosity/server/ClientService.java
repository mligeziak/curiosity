package pl.mligeza.curiosity.server;

import com.badlogic.gdx.math.Vector2;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import pl.mligeza.curiosity.level.Level;
import pl.mligeza.curiosity.level.tiles.*;

import java.io.IOException;
import java.util.Arrays;

public class ClientService extends Thread {
    private Client client;
    public Level level;

    @Override
    public void run() {
        Tile.initTiles();

        level = null;
        try {
            client = new Client();

            Kryo kryo = client.getKryo();
            kryo.register(Player.class);
            kryo.register(Request.class);
            kryo.register(Level.class);
            kryo.register(Vector2.class);
            kryo.register(int[].class);
            kryo.register(Tile[].class);

            kryo.register(EmptyTile.class);
            kryo.register(Level1Tile.class);
            kryo.register(Level2Tile.class);
            kryo.register(Level3Tile.class);
            kryo.register(Level4Tile.class);

            client.start();
            client.connect(5000, "localhost", 54555, 54777);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Player player = new Player();
        client.sendTCP(player);

        sendRequest("GET_LEVEL");

        client.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                if (object instanceof Level) {
                    level = (Level)object;
                    System.out.println("CLIENT LEVEL: " + Arrays.toString(level.getTiles()));
                } else if (object instanceof Vector2) {
                    Vector2 destroy = (Vector2)object;
                    level.hitTile((int)destroy.x, (int)destroy.y);
                }
            }
        });
    }

    public void destroyTile(int x, int y) {
        Vector2 destroy = new Vector2(x, y);
        client.sendTCP(destroy);
    }

    public void sendRequest(String text) {
        Request request = new Request();
        request.request = text;
        client.sendTCP(request);
    }
}
