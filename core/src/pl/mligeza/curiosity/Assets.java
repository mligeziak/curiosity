package pl.mligeza.curiosity;

import com.badlogic.gdx.graphics.Texture;

public class Assets {
    public static Texture emptyTileTexture;
    public static Texture groundTileTexture;
    public static Texture defaultTileTexture;

    public static void initTextures() {
        emptyTileTexture = new Texture("tiles/empty-tile.png");
        groundTileTexture = new Texture("tiles/ground-tile.png");
        defaultTileTexture = new Texture("tiles/default-tile.png");
    }
}
