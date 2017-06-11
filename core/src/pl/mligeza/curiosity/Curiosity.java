package pl.mligeza.curiosity;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class Curiosity extends ApplicationAdapter {
    public static final String TAG = "[Curiosity]";

    private OrthographicCamera camera = new OrthographicCamera();
    private SpriteBatch spriteBatch;
    private Texture img;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        Gdx.input.setInputProcessor(new InputManager());
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            Gdx.app.log(TAG, "Mouse left clicked");
        }

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        {
            Vector3 mousePos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(mousePos);
            int w = img.getWidth();
            int h = img.getHeight();

            spriteBatch.draw(img, mousePos.x - (w / 2), mousePos.y - (h / 2));
        }
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        img.dispose();
    }
}
