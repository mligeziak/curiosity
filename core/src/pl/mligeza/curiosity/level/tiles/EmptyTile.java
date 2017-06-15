package pl.mligeza.curiosity.level.tiles;

import pl.mligeza.curiosity.Assets;

public class EmptyTile extends Tile {
    public EmptyTile() {
    }

    public EmptyTile(int id, int durability, boolean isDestructable) {
        super(id, durability, isDestructable);

        texId = Assets.EMPTY_TEX_ID;
    }
}
