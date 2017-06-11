package pl.mligeza.curiosity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

import java.util.List;

public class InputManager extends InputAdapter {
    private OrthographicCamera camera;
    private List<Sprite> sprites;

    public InputManager(OrthographicCamera camera, List<Sprite> sprites) {
        this.camera = camera;
        this.sprites = sprites;
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
        Sprite newSprite = new Sprite(Curiosity.defaultImg);

        Vector3 newPosition = new Vector3(screenX, screenY, 0);
        camera.unproject(newPosition);

        float wHalf = newSprite.getWidth() / 2;
        float hHalf = newSprite.getHeight() / 2;
        newSprite.setPosition(newPosition.x - wHalf, newPosition.y - hHalf);

        sprites.add(newSprite);

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
        return true;
    }
}
