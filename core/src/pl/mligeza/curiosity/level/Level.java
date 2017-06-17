package pl.mligeza.curiosity.level;

import pl.mligeza.curiosity.level.tiles.*;

public class Level {
    public int width, height;

    private Tile[] tiles;
    public int currentLayer;

    public boolean isEnded = false;
    private int tilesLeft;

    public Level(int width, int height, int currentLayer) {
        this.width = width;
        this.height = height;
        this.currentLayer = currentLayer;

        generateLevel();
    }

    public void generateLevel() {
        this.tiles = new Tile[width * height];
        this.tilesLeft = tiles.length;
        System.out.println("Tiles left: " + tilesLeft);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (currentLayer == 3) {
                    setTile(x, y, new Level1Tile(Tile.level1Tile));
                }
                if (currentLayer == 2) {
                    setTile(x, y, new Level2Tile(Tile.level2Tile));
                }
                if (currentLayer == 1) {
                    setTile(x, y, new Level3Tile(Tile.level3Tile));
                }
                if (currentLayer == 0) {
                    setTile(x, y, new EmptyTile(Tile.emptyTile));
                }
            }
        }
    }

    public Level() { // NOTE(hubert): Need for Kryonet
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

    public String toString() {
        String string = "";
        for (Tile tile : tiles) {
            string += tile.id + ", ";
        }
        return string;
    }
}