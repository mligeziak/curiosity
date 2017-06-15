package pl.mligeza.curiosity.level.tiles;

import pl.mligeza.curiosity.Assets;

public class Tile {
    public static final int TILE_SIZE = 32;
    public static final int MAX_TILES = 8;

    public static Tile[] tiles = new Tile[MAX_TILES];

    public static Tile defaultTile;
    public static Tile emptyTile;
    public static Tile groundTile;

    public int defaultTexId;
    public int texId;

    public int id;

    public int maxDurability;
    public int durability = 0;

    public Tile() {// NOTE(hubert): For KryoNet
    }

    public Tile(int id, int maxDurability) {
        this.id = id;
        this.durability = this.maxDurability = maxDurability;

        tiles[id] = this;

        defaultTexId = Assets.DEFAULT_TEX_ID;
        if (id == 1) texId = defaultTexId;
    }

    public static void initTiles() {
        emptyTile = new EmptyTile(0, 0);
        defaultTile = new Tile(1, 5);
        groundTile = new GroundTile(2, 2);
    }

    public void hit() {
        durability--;
        if (durability < 0) durability = maxDurability;
        // TODO(hubert): Texture change based on durability
    }
}
