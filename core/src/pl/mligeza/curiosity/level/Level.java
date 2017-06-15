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

        Arrays.fill(tiles, 1); // FIX(hubert): Avoid magic numbers!!!
    }

    public Level() { // NOTE(hubert): Need for Kryonet
    }

    public void update(float dt) {
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x > width || y > height) throw new RuntimeException("Coords cannot be out of bounds");

        return Tile.tiles[tiles[x + y * width]];
    }

    public void hitTile(int x, int y) {
        if (x < 0 || y < 0 || x > width - 1 || y > height - 1) return;
        System.out.println("tile pos: " + x + ", " + y);
        System.out.println("tiles: " + Arrays.toString(tiles));
        System.out.println("tiles: " + Arrays.toString(Tile.tiles));
        Tile tile = getTile(x, y);
        System.out.println(tile);
        tile.hit();
        System.out.println(tile.durability);
        if (tile.durability <= 0) {
            setTile(x, y, 0); // FIX(hubert): change tile id number to corresponding Tile id from object, avoid magic numbers
        }
    }

    public boolean isClear() {
        for (int tile : tiles) {
            if (tile != 0) { // FIX(hubert): same here, avoid magic numbers
                return false;
            }
        }
        return true;
    }

    public void setTile(int x, int y, int tile) {
        if (x < 0 || y < 0 || x > width || y > height) return;

        tiles[x + y * width] = tile;
    }

    public int[] getTiles() {
        return tiles;
    }
}