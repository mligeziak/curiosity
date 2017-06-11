package pl.mligeza.curiosity.level.tiles;

import com.badlogic.gdx.graphics.Texture;

public class Tile {
    public static final int TILE_SIZE = 32;
    public static final int MAX_TILES = 8;

    public static Tile[] tiles = new Tile[MAX_TILES];

    public static Tile defaultTile;

    public static Tile emptyTile;
    public static Tile groundTile;

    private Texture defaultTexture;
    public int id;

    public Texture texture;

    public Tile(int id) {
        this.id = id;
        this.tiles[id] = this;

        defaultTexture = new Texture("tiles/default-tile.png");
        texture = new Texture(defaultTexture.getTextureData());
    }

    public static void initTiles() {
        defaultTile = new Tile(0);
        emptyTile = new EmptyTile(1);
        groundTile = new GroundTile(2);
    }
}
