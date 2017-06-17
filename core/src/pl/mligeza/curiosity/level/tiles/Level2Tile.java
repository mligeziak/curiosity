package pl.mligeza.curiosity.level.tiles;

import pl.mligeza.curiosity.Assets;

public class Level2Tile extends Tile {
    public Level2Tile() {
    }

    public Level2Tile(Tile tile) {
        super(tile);
    }

    public Level2Tile(int id, int maxDurability, boolean isDestructable) {
        super(id, maxDurability, isDestructable);

        this.tilesSet = new int[maxDurability];

        this.tilesSet[0] = Assets.LEVEL_1_TEX_1_ID;
        this.tilesSet[1] = Assets.LEVEL_1_TEX_0_ID;

        this.texId = tilesSet[this.maxDurability - 1];
    }
}
