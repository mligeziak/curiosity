package pl.mligeza.curiosity;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

public class Assets {
    public static final int EMPTY_TEX_ID = 0;

    public static final int LEVEL_1_TEX_0_ID = 1;
    public static final int LEVEL_1_TEX_1_ID = 2;

    public static final int LEVEL_2_TEX_0_ID = 3;
    public static final int LEVEL_2_TEX_1_ID = 4;
    public static final int LEVEL_2_TEX_2_ID = 5;

    public static final int LEVEL_3_TEX_0_ID = 6;
    public static final int LEVEL_3_TEX_1_ID = 7;
    public static final int LEVEL_3_TEX_2_ID = 8;
    public static final int LEVEL_3_TEX_3_ID = 9;

    private static Map<Integer, Texture> textures = new HashMap<>();

    public static void initTextures() {
        final Texture emptyTex = new Texture("tiles/empty-tile.png");

        final Texture level1Tex0 = new Texture("tiles/level-1/tile-0.png");
        final Texture level1Tex1 = new Texture("tiles/level-1/tile-1.png");

        final Texture level2Tex0 = new Texture("tiles/level-2/tile-0.png");
        final Texture level2Tex1 = new Texture("tiles/level-2/tile-1.png");
        final Texture level2Tex2 = new Texture("tiles/level-2/tile-2.png");

        final Texture level3Tex0 = new Texture("tiles/level-3/tile-0.png");
        final Texture level3Tex1 = new Texture("tiles/level-3/tile-1.png");
        final Texture level3Tex2 = new Texture("tiles/level-3/tile-2.png");
        final Texture level3Tex3 = new Texture("tiles/level-3/tile-3.png");

        textures.put(EMPTY_TEX_ID, emptyTex);

        textures.put(LEVEL_1_TEX_0_ID, level1Tex0);
        textures.put(LEVEL_1_TEX_1_ID, level1Tex1);

        textures.put(LEVEL_2_TEX_0_ID, level2Tex0);
        textures.put(LEVEL_2_TEX_1_ID, level2Tex1);
        textures.put(LEVEL_2_TEX_2_ID, level2Tex2);

        textures.put(LEVEL_3_TEX_0_ID, level3Tex0);
        textures.put(LEVEL_3_TEX_1_ID, level3Tex1);
        textures.put(LEVEL_3_TEX_2_ID, level3Tex2);
        textures.put(LEVEL_3_TEX_3_ID, level3Tex3);
    }

    public static Texture getTexture(int textureId) {
        return textures.get(textureId);
    }
}
