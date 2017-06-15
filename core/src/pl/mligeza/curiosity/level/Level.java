package pl.mligeza.curiosity.level;

import pl.mligeza.curiosity.level.tiles.EmptyTile;
import pl.mligeza.curiosity.level.tiles.GroundTile;
import pl.mligeza.curiosity.level.tiles.Tile;

import java.util.Arrays;

public class Level {
    public int width, height;
    private Tile[] tiles;

    private int tilesLeft;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width * height];

        this.tilesLeft = tiles.length;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                setTile(x, y, new GroundTile(Tile.groundTile));
            }
        }

        System.out.println("Tiles: " + Arrays.toString(tiles));
    }

    public Level() { // NOTE(hubert): Need for Kryonet
    }

    public void update(float dt) {
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x > width - 1 || y > height - 1) {
            throw new RuntimeException("Coords cannot be out of bounds");
        }

        return tiles[x + y * width];
    }

    public void hitTile(int x, int y) {
        if (x < 0 || y < 0 || x > width - 1 || y > height - 1) return;

        Tile tile = getTile(x, y);
        tile.hit();

        if (tile.destroyed) {
            System.out.println("Tile destroyed");
            setTile(x, y, new EmptyTile(Tile.emptyTile));
            tilesLeft--;
            System.out.println("Tiles left: " + tilesLeft);
        }
    }

    public boolean isClear() {
        return tilesLeft == 0;
    }

    public void setTile(int x, int y, Tile tile) {
        if (x < 0 || y < 0 || x > width - 1 || y > height - 1) return;

        tiles[x + y * width] = tile;
    }

    public Tile[] getTiles() {
        return tiles;
    }
}