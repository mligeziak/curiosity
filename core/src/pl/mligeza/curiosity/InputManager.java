package pl.mligeza.curiosity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import pl.mligeza.curiosity.level.Level;

public class InputManager extends InputAdapter {
    private OrthographicCamera camera;
    private Level level;

    public InputManager(OrthographicCamera camera, Level level) {
        this.camera = camera;
        this.level = level;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (Input.Keys.ESCAPE == keycode) {
            Gdx.app.exit();
        }

        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector3 newPosition = new Vector3(screenX, screenY, 0);
        camera.unproject(newPosition);

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {

        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        System.out.println(amount);
        return true;
    }
}
