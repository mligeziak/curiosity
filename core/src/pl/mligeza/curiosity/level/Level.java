package pl.mligeza.curiosity.level;

import java.util.Arrays;

public class Level {
    public int width, height;
    private Tile[] tiles;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;

        this.tiles = new Tile[width * height];

        Arrays.fill(tiles, Tile.defaultTile);
    }

    public void update(float dt) {
    }

    public Tile getTile(int x, int y) {
        return tiles[x + y * width];
    }

    public Tile[] getTiles() {
        return tiles;
    }
}
