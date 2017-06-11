package pl.mligeza.curiosity.server;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;

public class ClientService extends Thread {
    private Client client;

    @Override
    public void run() {
        try {
            client = new Client();
            Kryo kryo = client.getKryo();
            kryo.register(Player.class);
            client.start();
            client.connect(5000, "localhost", 54555, 54777);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Player player = new Player();
        client.sendTCP(player);

        client.addListener(new Listener() {
            public void received (Connection connection, Object object) {
            }
        });
    }

    public void destroyTile(int x, int y) {
    }
}
