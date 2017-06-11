package pl.mligeza.curiosity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import pl.mligeza.curiosity.level.Level;
import pl.mligeza.curiosity.server.ClientService;

public class InputManager extends InputAdapter {
    private OrthographicCamera camera;
    private Level level;
    private ClientService clientService;

    public InputManager(Level level, OrthographicCamera camera, ClientService clientService) {
        this.level = level;
        this.camera = camera;
        this.clientService = clientService;
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
        clientService.destroyTile(screenX/32, screenY/32);
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
