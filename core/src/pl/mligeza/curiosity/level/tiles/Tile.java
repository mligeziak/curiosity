package pl.mligeza.curiosity.level.tiles;

import com.badlogic.gdx.graphics.Texture;
import pl.mligeza.curiosity.Assets;

public class Tile {
    public static final int TILE_SIZE = 32;
    public static final int MAX_TILES = 8;

    public static Tile[] tiles = new Tile[MAX_TILES];

    public static Tile defaultTile;

    public static Tile emptyTile;
    public static Tile groundTile;

    private Texture defaultTexture;
    public int id;

    public int durability = 0;

    public Texture texture;

    public Tile(int id, int durability) {
        this.id = id;
        this.durability = durability;

        tiles[id] = this;

        defaultTexture = Assets.defaultTileTexture;
        if (id == 1) texture = defaultTexture;
    }

    public static void initTiles() {
        emptyTile = new EmptyTile(0, 0);
        defaultTile = new Tile(1, 5);
        groundTile = new GroundTile(2, 2);
    }

    public void hit() {
        durability--;
        // TODO(hubert): Texture change based on durability
    }
}
