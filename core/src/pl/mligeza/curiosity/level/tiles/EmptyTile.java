package pl.mligeza.curiosity.level.tiles;

import pl.mligeza.curiosity.Assets;

public class EmptyTile extends Tile {
    public EmptyTile() {
    }

    public EmptyTile(Tile tile) {
        super(tile);
    }

    public EmptyTile(int id, int maxDurability, boolean isDestructable) {
        super(id, maxDurability, isDestructable);

        this.tilesSet = new int[maxDurability];

        this.tilesSet[0] = Assets.EMPTY_TEX_ID;

        this.texId = tilesSet[this.maxDurability - 1];
    }
}
