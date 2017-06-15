package pl.mligeza.curiosity;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

public class Assets {
    public static final int EMPTY_TEX_ID = 0;
    public static final int DEFAULT_TEX_ID = 1;
    public static final int GROUND_TEX_ID = 2;

    private static Map<String, Integer> texturesId = new HashMap<>();
    private static Map<Integer, Texture> textures = new HashMap<>();

    public static void initTextures() {
        final Texture emptyTex = new Texture("tiles/empty-tile.png");
        final Texture defaultTex = new Texture("tiles/default-tile.png");
        final Texture groundTex = new Texture("tiles/ground-tile.png");

        textures.put(EMPTY_TEX_ID, emptyTex);
        textures.put(DEFAULT_TEX_ID, defaultTex);
        textures.put(GROUND_TEX_ID, groundTex);
    }

    public static Texture getTexture(int textureId) {
        return textures.get(textureId);
    }
}
