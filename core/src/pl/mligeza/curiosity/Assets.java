package pl.mligeza.curiosity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;
import java.util.Map;

public class Assets {
    public static final int EMPTY_TEX_ID = 0;

    public static final int LEVEL_1_TEX_0_ID = 1;
    public static final int LEVEL_1_TEX_1_ID = 2;
    public static final int LEVEL_1_TEX_2_ID = 3;
    public static final int LEVEL_1_TEX_3_ID = 4;

    private static Map<Integer, Texture> textures = new HashMap<>();

    public static void initTextures() {
        final Texture emptyTex = new Texture("tiles/empty-tile.png");

        final Texture level1Tex0 = new Texture("tiles/level-1-tile-0.png");
        final Texture level1Tex1 = new Texture("tiles/level-1-tile-1.png");
        final Texture level1Tex2 = new Texture("tiles/level-1-tile-2.png");
        final Texture level1Tex3 = new Texture("tiles/level-1-tile-3.png");

        textures.put(EMPTY_TEX_ID, emptyTex);

        textures.put(LEVEL_1_TEX_0_ID, level1Tex0);
        textures.put(LEVEL_1_TEX_1_ID, level1Tex1);
        textures.put(LEVEL_1_TEX_2_ID, level1Tex2);
        textures.put(LEVEL_1_TEX_3_ID, level1Tex3);
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
