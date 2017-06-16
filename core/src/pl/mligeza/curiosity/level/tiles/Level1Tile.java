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

        texId = Assets.LEVEL_1_TEX_0_ID;
    }
}
