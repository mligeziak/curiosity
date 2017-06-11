package pl.mligeza.curiosity.level;

import com.badlogic.gdx.graphics.Texture;

public class Tile {
    public static final int TILE_SIZE = 32;
    public static final int MAX_TILES = 8;

    public static Tile[] tiles = new Tile[MAX_TILES];

    public static Tile emptyTile = new Tile(Level.EMPTY_TILE_ID);
    public static Tile defaultTile = new Tile(Level.DEFAULT_TILE_ID);

    private Texture defaultTexture;
    public int id;

    public Texture texture;

    public Tile(int id) {
        this.id = id;
        this.tiles[id] = this;

        defaultTexture = new Texture("tiles/default-tile.png");
        texture = new Texture(defaultTexture.getTextureData());
    }
}
