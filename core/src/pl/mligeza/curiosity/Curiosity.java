package pl.mligeza.curiosity;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import pl.mligeza.curiosity.level.Level;
import pl.mligeza.curiosity.server.ClientService;

public class Curiosity extends ApplicationAdapter {
    public static final String TAG = "[Curiosity]";

    private OrthographicCamera camera;
    private SpriteBatch spriteBatch;

    private Level level;
    private LevelRenderer levelRenderer;

    private ShapeRenderer shapeRenderer;

    private ClientService clientService;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();

        level = new Level(8, 8);
        level.setTile(0, 0, Level.EMPTY_TILE_ID);

        clientService = new ClientService(level);
        clientService.start();

        camera = new OrthographicCamera();
        camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();

        levelRenderer = new LevelRenderer(level, camera);

        Gdx.input.setInputProcessor(new InputManager(level, camera, clientService));
    }

    private void update(float dt) {
        level.update(dt);
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
