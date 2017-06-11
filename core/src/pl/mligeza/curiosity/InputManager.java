package pl.mligeza.curiosity;

import com.badlogic.gdx.InputAdapter;

public class InputManager extends InputAdapter {
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("mouse down");
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        System.out.println("mouse up");
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        System.out.println("mouse dragged");
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        System.out.println("mouse moved");
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        System.out.println("scroll moved: " + amount);
        return true;
    }
}
