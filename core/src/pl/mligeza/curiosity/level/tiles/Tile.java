package pl.mligeza.curiosity.level.tiles;

public abstract class Tile {
    public static final int TILE_SIZE = 32;
    public static final int MAX_TILES = 8;

    public static Tile[] tiles = new Tile[MAX_TILES];

    public static Tile defaultTile;
    public static Tile emptyTile;
    public static Tile groundTile;

    public int texId;
    public int id;

    public int maxDurability;
    public int durability = 0;
    public boolean isDestructable = false;

    public Tile() {// NOTE(hubert): For KryoNet
    }

    public Tile(int id, int maxDurability, boolean isDestructable) {
        this.id = id;
        this.durability = this.maxDurability = maxDurability;
        this.isDestructable = isDestructable;

        tiles[id] = this;
    }

    public static void initTiles() {
        emptyTile = new EmptyTile(0, 1, false);
        defaultTile = new DefaultTile(1, 1, true);
        groundTile = new GroundTile(2, 2, true);
    }

    public void hit() {
        if (isDestructable) {
            System.out.println("HIT!");
            durability--;
        }
        // TODO(hubert): Texture change based on durability
    }
}
