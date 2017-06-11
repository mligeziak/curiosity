package pl.mligeza.curiosity.level.tiles;

import com.badlogic.gdx.graphics.Texture;

public class EmptyTile extends Tile {
    public EmptyTile(int id) {
        super(id);

        texture = new Texture("tiles/empty-tile.png");
    }
}
