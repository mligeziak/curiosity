package pl.mligeza.curiosity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pl.mligeza.curiosity.server.ClientService;

public class InterfaceRenderer {
    private Texture topBarBackground;
    private BitmapFont normalFont;
    private ClientService clientService;
    private Texture logo;
    public Texture starButton;

    public InterfaceRenderer(ClientService clientService) {
        this.clientService = clientService;

        topBarBackground = new Texture("topbar.png");
        logo = new Texture("logo.png");
        starButton = new Texture("start-button.png");

        normalFont = new BitmapFont();
        normalFont.setColor(Color.WHITE);
    }

    public void update(float dt) {

    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();

        //Main game
        spriteBatch.draw(topBarBackground, 0, 384);
        if(clientService.level != null) {
            normalFont.draw(spriteBatch, "Tiles left: " + clientService.level.tilesLeft, 20, 413);
        }

        //Start screen
        spriteBatch.draw(logo, ClientService.startScreenPos.x - 176, ClientService.startScreenPos.y);
        spriteBatch.draw(starButton, ClientService.startScreenPos.x - 87, ClientService.startScreenPos.y - 100);

        spriteBatch.end();
    }
}
