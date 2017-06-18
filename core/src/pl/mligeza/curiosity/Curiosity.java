package pl.mligeza.curiosity;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pl.mligeza.curiosity.level.tiles.Tile;
import pl.mligeza.curiosity.server.ClientService;

public class Curiosity extends ApplicationAdapter {
    private OrthographicCamera camera;
    private SpriteBatch spriteBatch;

    private LevelRenderer levelRenderer;
    private InterfaceRenderer interfaceRenderer;
    private ClientService clientService;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();

        Assets.initTextures();
        Tile.initTiles();

        clientService = new ClientService();
        clientService.start();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();

        levelRenderer = new LevelRenderer(clientService.level, camera);
        interfaceRenderer = new InterfaceRenderer(clientService);

        Gdx.input.setInputProcessor(new InputManager(clientService, camera));
    }

    private void update(float dt) {
        levelRenderer.updateLevel(clientService.level);
        interfaceRenderer.update(dt);

        camera.position.x = clientService.cameraPos.x;
        camera.position.y = clientService.cameraPos.y;
        camera.update();
    }

    @Override
    public void render() {
        update(Gdx.graphics.getDeltaTime());

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        interfaceRenderer.render(spriteBatch);
        levelRenderer.render(spriteBatch);
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
    }
}
