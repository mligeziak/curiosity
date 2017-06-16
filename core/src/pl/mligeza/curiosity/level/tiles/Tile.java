package pl.mligeza.curiosity.level.tiles;

public abstract class Tile {
    public static final int TILE_SIZE = 32;
    public static final int MAX_TILES = 8;

    public static Tile[] tiles = new Tile[MAX_TILES];

    public static Tile emptyTile;
    public static Tile level1Tile;

    public int texId;
    public int id;

    private int maxDurability;
    public int durability = 0;
    public boolean isDestructable = false;
    public boolean destroyed = false;
    public int[] tilesSet;

    public Tile() {// NOTE(hubert): For KryoNet
    }

    public Tile(Tile tile) {
        this.id = tile.id;
        this.texId = tile.texId;
        this.isDestructable = tile.isDestructable;
        this.destroyed = tile.destroyed;
        this.durability = tile.durability;
        this.maxDurability = tile.maxDurability;
        this.tilesSet = tile.tilesSet;
    }

    public Tile(int id, int maxDurability, boolean isDestructable) {
        this.id = id;
        this.durability = this.maxDurability = maxDurability;
        this.isDestructable = isDestructable;
        this.tilesSet = new int[maxDurability];

        tiles[id] = this;
    }

    public static void initTiles() {
        emptyTile = new EmptyTile(0, 1, false);
        level1Tile = new Level1Tile(1, 4, true);
    }

    public void hit() {
        if (isDestructable) {
            System.out.println("HIT!");
            durability--;
            if(durability > 0) {
                texId = tilesSet[durability - 1];
            }
            System.out.println("Tile durability: " + durability);
            if (durability == 0) {
                destroyed = true;
            }
        }
    }
}
