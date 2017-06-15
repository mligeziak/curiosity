package pl.mligeza.curiosity.level.tiles;

import pl.mligeza.curiosity.Assets;

public class GroundTile extends Tile {
    public GroundTile(int id, int durability) {
        super(id, durability);

        texId = Assets.GROUND_TEX_ID;
    }
}