package pl.mligeza.curiosity.level.tiles;

import pl.mligeza.curiosity.Assets;

public class GroundTile extends Tile {
    public GroundTile() {
    }

    public GroundTile(Tile tile) {
        super(tile);
    }

    public GroundTile(int id, int durability, boolean isDestructable) {
        super(id, durability, isDestructable);

        texId = Assets.GROUND_TEX_2HARD_ID;
    }
}
