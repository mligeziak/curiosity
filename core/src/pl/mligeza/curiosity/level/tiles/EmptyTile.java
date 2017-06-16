package pl.mligeza.curiosity.level.tiles;

import pl.mligeza.curiosity.Assets;

public class EmptyTile extends Tile {
    public EmptyTile() {
    }

    public EmptyTile(Tile tile) {
        super(tile);
    }

    public EmptyTile(int id, int durability, boolean isDestructable) {
        super(id, durability, isDestructable);

        this.tilesSet[0] = Assets.EMPTY_TEX_ID;

        this.texId = tilesSet[this.maxDurability - 1];
    }
}
