package pl.mligeza.curiosity.level;

import pl.mligeza.curiosity.level.tiles.Tile;

import java.util.Arrays;

public class Level {
    public int width, height;
    private int[] tiles;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;

        this.tiles = new int[width * height];

        Arrays.fill(tiles, 1);
    }

    public Level() { }

    public void update(float dt) {
    }

    public Tile getTile(int x, int y) {
        return Tile.tiles[tiles[x + y * width]];
    }

    public void destroyTile(int x, int y) {
        tiles[x + y * width] = 0;
    }

    public int[] getTiles() {
        return tiles;
    }
}