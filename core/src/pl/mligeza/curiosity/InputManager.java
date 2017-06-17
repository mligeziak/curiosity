package pl.mligeza.curiosity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import pl.mligeza.curiosity.server.ClientService;

public class InputManager extends InputAdapter {
    private ClientService clientService;
    private OrthographicCamera camera;

    public InputManager(ClientService clientService, OrthographicCamera camera) {
        this.clientService = clientService;
        this.camera = camera;
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
        Vector3 clickPos = camera.unproject(new Vector3(screenX, screenY, 0));

        Rectangle startButtonRange = new Rectangle(ClientService.startScreenPos.x - 87, ClientService.startScreenPos.y - 100, 175, 55);
        if (startButtonRange.contains(clickPos.x, clickPos.y)) {
            clientService.cameraPos = ClientService.mainGamePos;
        }
        else {
            clientService.destroyTile((int)clickPos.x/32, (int)clickPos.y/32);
            System.out.println(clientService.level.toString());
        }

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
