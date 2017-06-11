package pl.mligeza.curiosity.level;

import java.util.Arrays;

public class Level {
    public int width, height;
    private int[] tiles;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;

        this.tiles = new int[width * height];

        Arrays.fill(tiles, Tile.defaultTile.id);
    }

    public void update(float dt) {
    }

    public Tile getTile(int x, int y) {
        return Tile.tiles[tiles[x + y * width]];
    }

    public int[] getTiles() {
        return tiles;
    }
}
