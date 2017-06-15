package pl.mligeza.curiosity.level.tiles;

import pl.mligeza.curiosity.Assets;

public class DefaultTile extends Tile {
    public DefaultTile() {
    }

    public DefaultTile(Tile tile) {
        super(tile);
    }

    public DefaultTile(int id, int durability, boolean isDestructable) {
        super(id, durability, isDestructable);

        texId = Assets.DEFAULT_TEX_ID;
    }
}
