package pl.mligeza.curiosity.level;

import java.util.Arrays;

public class Level {
    public int width, height;
    private int[] tiles;
    public static final int EMPTY_TILE_ID = 0;
    public static final int DEFAULT_TILE_ID = 0;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;

        this.tiles = new int[width * height];

        Arrays.fill(tiles, DEFAULT_TILE_ID);
    }

    public Level() { }

    public void update(float dt) {
    }

    public Tile getTile(int x, int y) {
        return Tile.tiles[tiles[x + y * width]];
    }

    public int[] getTiles() {
        return tiles;
    }
}
