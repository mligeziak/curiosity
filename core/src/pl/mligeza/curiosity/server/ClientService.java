package pl.mligeza.curiosity.server;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import pl.mligeza.curiosity.level.Level;

import java.io.IOException;

public class ClientService extends Thread {
    private Client client;
    public Level level;

    @Override
    public void run() {
        level = null;
        try {
            client = new Client();

            Kryo kryo = client.getKryo();
            kryo.register(Player.class);
            kryo.register(Request.class);
            kryo.register(Level.class);
            kryo.register(int[].class);

            client.start();
            client.connect(5000, "localhost", 54555, 54777);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Player player = new Player();
        client.sendTCP(player);

        sendRequest("GET_LEVEL");

        client.addListener(new Listener() {
            public void received (Connection connection, Object object) {
                if(object instanceof Level) {
                    level = (Level) object;
                    System.out.println("Odebrano level");
                }
            }
        });
    }

    public void destroyTile(int x, int y) {
    }

    public void sendRequest(String text) {
        Request request = new Request();
        request.request = text;
        client.sendTCP(request);
    }
}
