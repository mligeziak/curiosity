package pl.mligeza.curiosity.level;

import com.badlogic.gdx.graphics.Texture;

public class Tile {
    public static int TILE_SIZE = 32;

    public static Tile defaultTile = new Tile("default-tile");

    private static int NEXT_ID = 0;
    public int id = -1;
    public String tileName;

    private Texture defaultTexture;

    public Texture texture;

    public Tile(String tileName) {
        this.tileName = tileName;
        this.id = ++NEXT_ID;

        defaultTexture = new Texture("tiles/default-tile.png");

        texture = new Texture(defaultTexture.getTextureData());
    }
}
