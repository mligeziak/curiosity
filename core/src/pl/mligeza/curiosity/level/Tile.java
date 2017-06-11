package pl.mligeza.curiosity.level;

import com.badlogic.gdx.graphics.Texture;

public class Tile {
    public static int TILE_SIZE = 32;

    public static Tile defaultTile = new Tile();

    private Texture defaultTexture;
    private static int NEXT_ID = 0;
    public int id = -1;

    public Texture texture;

    public Tile() {
        this.id = ++NEXT_ID;

        defaultTexture = new Texture("tiles/default-tile.png");

        texture = new Texture(defaultTexture.getTextureData());
    }
}
