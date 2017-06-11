package pl.mligeza.curiosity;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pl.mligeza.curiosity.level.Level;

import java.util.ArrayList;
import java.util.List;

public class Curiosity extends ApplicationAdapter {
    public static final String TAG = "[Curiosity]";

    private OrthographicCamera camera = new OrthographicCamera();
    private SpriteBatch spriteBatch;

    private Level level;
    private LevelRenderer levelRenderer;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();

        final float width = Gdx.graphics.getWidth();
        final float height = Gdx.graphics.getHeight();
        camera.setToOrtho(false, width, height);
        camera.translate(-width/2, -height/2);

        level = new Level(8, 8);
        levelRenderer = new LevelRenderer(level, camera);

        Gdx.input.setInputProcessor(new InputManager(camera, level));
    }

    public void update(float dt) {
        level.update(dt);
        camera.update();
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
