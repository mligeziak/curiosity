package pl.mligeza.curiosity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;
import java.util.Map;

public class Assets {
    public static final int EMPTY_TEX_ID = 0;
    public static final int DEFAULT_TEX_ID = 1;

    public static final int GROUND_TEX_ID = 2;
    public static final int GROUND_TEX_1HARD_ID = 3;
    public static final int GROUND_TEX_2HARD_ID = 4;

    private static Map<Integer, Texture> textures = new HashMap<>();

    public static void initTextures() {
        final Texture emptyTex = new Texture("tiles/empty-tile.png");
        final Texture defaultTex = new Texture("tiles/default-tile.png");
        final Texture groundTex = new Texture("tiles/ground-tile.png");

        final Texture groundTex1Hard = new Texture("tiles/ground-tile-1hard.png");
        final Texture groundTex2Hard = new Texture("tiles/ground-tile-2hard.png");

        textures.put(EMPTY_TEX_ID, emptyTex);
        textures.put(DEFAULT_TEX_ID, defaultTex);

        textures.put(GROUND_TEX_ID, groundTex);
        textures.put(GROUND_TEX_1HARD_ID, groundTex1Hard);
        textures.put(GROUND_TEX_2HARD_ID, groundTex2Hard);
    }

    private static TextureRegion generateFlippedTextureRegion(Texture texture) {
        TextureRegion result = new TextureRegion(texture);
        result.flip(false, true);

        return result;
    }

    public static Texture getTexture(int textureId) {
        return textures.get(textureId);
    }
}
