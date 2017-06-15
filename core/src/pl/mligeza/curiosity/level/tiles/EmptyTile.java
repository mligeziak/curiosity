package pl.mligeza.curiosity.level.tiles;

import pl.mligeza.curiosity.Assets;

public class EmptyTile extends Tile {
    public EmptyTile(int id, int durability) {
        super(id, durability);

        texture = Assets.emptyTileTexture;
    }
}
