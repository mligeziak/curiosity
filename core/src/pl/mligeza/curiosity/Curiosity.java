package pl.mligeza.curiosity;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pl.mligeza.curiosity.level.tiles.Tile;
import pl.mligeza.curiosity.server.ClientService;

public class Curiosity extends ApplicationAdapter {
    public static final String TAG = "[Curiosity]";

    private OrthographicCamera camera;
    private SpriteBatch spriteBatch;

    private LevelRenderer levelRenderer;

    private ClientService clientService;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();

        clientService = new ClientService();
        clientService.start();

        camera = new OrthographicCamera();
        camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();

        Tile.initTiles();

        levelRenderer = new LevelRenderer(clientService.level, camera);

        Gdx.input.setInputProcessor(new InputManager(clientService));
    }

    private void update(float dt) {
        levelRenderer.updateLevel(clientService.level);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render() {
        update(Gdx.graphics.getDeltaTime());

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        levelRenderer.render(spriteBatch);
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
    }
}
