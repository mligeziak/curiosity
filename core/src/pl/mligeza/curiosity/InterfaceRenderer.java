package pl.mligeza.curiosity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pl.mligeza.curiosity.server.ClientService;

public class InterfaceRenderer {
    private Texture topBarBackground;
    private BitmapFont font;
    private ClientService clientService;

    public InterfaceRenderer(ClientService clientService) {
        this.clientService = clientService;

        topBarBackground = new Texture("topbar.png");
        font = new BitmapFont();
        font.setColor(Color.WHITE);
    }

    public void update(float dt) {

    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();

        spriteBatch.draw(topBarBackground, 0, 384);

        if(clientService.level != null) {
            font.draw(spriteBatch, "Tiles left: " + clientService.level.tilesLeft, 20, 413);
        }

        spriteBatch.end();
    }
}
