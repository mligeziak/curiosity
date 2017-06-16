package pl.mligeza.curiosity.level.tiles;

import pl.mligeza.curiosity.Assets;

public class Level1Tile extends Tile {
    public Level1Tile() {
    }

    public Level1Tile(Tile tile) {
        super(tile);
    }

    public Level1Tile(int id, int durability, boolean isDestructable) {
        super(id, durability, isDestructable);

        this.tilesSet[0] = Assets.LEVEL_1_TEX_3_ID;
        this.tilesSet[1] = Assets.LEVEL_1_TEX_2_ID;
        this.tilesSet[2] = Assets.LEVEL_1_TEX_1_ID;
        this.tilesSet[3] = Assets.LEVEL_1_TEX_0_ID;

        this.texId = tilesSet[this.durability - 1];
    }
}
