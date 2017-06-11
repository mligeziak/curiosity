package pl.mligeza.curiosity.level;

import java.util.ArrayList;
import java.util.List;

public class Level {
    public int width, height;
    public List<Tile> tiles = new ArrayList<>();

    public Level(int width, int height) {
        this.width = width;
        this.height = height;

        for (int i = 0; i < width * height; i++) {
            tiles.add(Tile.defaultTile);
        }
    }

    public void update(float dt) {
    }
}
