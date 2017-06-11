package pl.mligeza.curiosity;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pl.mligeza.curiosity.server.ClientService;

import java.util.ArrayList;
import java.util.List;

public class Curiosity extends ApplicationAdapter {
    public static final String TAG = "[Curiosity]";

    private OrthographicCamera camera = new OrthographicCamera();
    private SpriteBatch spriteBatch;

    public static Sprite defaultImg;
    private Texture img;

    private List<Sprite> sprites = new ArrayList<>();

    private ClientService clientService;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        img = new Texture("badlogic.jpg");

        defaultImg = new Sprite(img);

        clientService = new ClientService();
        clientService.start();

        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.input.setInputProcessor(new InputManager(camera, sprites, clientService));
    }

    public void update(float dt) {
        camera.update();
    }

    @Override
    public void render() {
        update(Gdx.graphics.getDeltaTime());

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        {
            for (Sprite sprite : sprites) {
                sprite.draw(spriteBatch);
            }
        }
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        img.dispose();
    }
}
