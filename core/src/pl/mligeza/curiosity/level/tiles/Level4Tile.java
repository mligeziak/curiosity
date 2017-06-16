package pl.mligeza.curiosity.level.tiles;

import pl.mligeza.curiosity.Assets;

public class Level4Tile extends Tile {
    public Level4Tile() {
    }

    public Level4Tile(Tile tile) {
        super(tile);
    }

    public Level4Tile(int id, int maxDurability, boolean isDestructable) {
        super(id, maxDurability, isDestructable);

        this.tilesSet = new int[maxDurability];

        this.tilesSet[0] = Assets.LEVEL_1_TEX_3_ID;
        this.tilesSet[1] = Assets.LEVEL_1_TEX_2_ID;
        this.tilesSet[2] = Assets.LEVEL_1_TEX_1_ID;
        this.tilesSet[3] = Assets.LEVEL_1_TEX_0_ID;

        this.texId = tilesSet[this.maxDurability - 1];
    }
}
