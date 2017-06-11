package pl.mligeza.curiosity.level.tiles;

import com.badlogic.gdx.graphics.Texture;

public class GroundTile extends Tile {
    public GroundTile(int id) {
        super(id);

        texture = new Texture("tiles/ground-tile.png");
    }
}
