package pl.mligeza.curiosity.level.tiles;

import pl.mligeza.curiosity.Assets;

public class Level1Tile extends Tile {
    public Level1Tile() {
    }

    public Level1Tile(Tile tile) {
        super(tile);
    }

    public Level1Tile(int id, int maxDurability, boolean isDestructable) {
        super(id, maxDurability, isDestructable);

        this.tilesSet = new int[maxDurability];
        this.tilesSet[0] = Assets.LEVEL_1_TEX_0_ID;

        this.texId = tilesSet[this.maxDurability - 1];
    }
}
