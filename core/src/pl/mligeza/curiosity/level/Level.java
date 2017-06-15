package pl.mligeza.curiosity.level;

import pl.mligeza.curiosity.level.tiles.Tile;

import java.util.Arrays;

public class Level {
    public static final String TAG = "[Level]";

    public int width, height;
    private Tile[] tiles;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;

        this.tiles = new Tile[width * height];

        Arrays.fill(tiles, Tile.defaultTile);
    }

    public Level() { // NOTE(hubert): Need for Kryonet
    }

    public void update(float dt) {
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x > width || y > height) throw new RuntimeException("Coords cannot be out of bounds");

        return tiles[x + y * width];
    }

    public void hitTile(int x, int y) {
        if (x < 0 || y < 0 || x > width - 1 || y > height - 1) return;

        Tile tile = getTile(x, y);
        tile.hit();

        if (tile.durability <= 0) {
            setTile(x, y, Tile.emptyTile);
        }
    }

    public boolean isClear() {
        System.out.println(Arrays.toString(tiles));
        for (Tile tile : tiles) {
            if (tile.id != Tile.emptyTile.id) {
                return false;
            }
        }

        return true;
    }

    public void setTile(int x, int y, Tile tile) {
        if (x < 0 || y < 0 || x > width || y > height) return;

        tiles[x + y * width] = tile;
    }

    public Tile[] getTiles() {
        return tiles;
    }
}