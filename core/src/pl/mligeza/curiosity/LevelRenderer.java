package pl.mligeza.curiosity;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import pl.mligeza.curiosity.level.Level;
import pl.mligeza.curiosity.level.Tile;

public class LevelRenderer {
    public static final String TAG = "[LevelRenderer]";
    public Level level;
    public OrthographicCamera camera;

    public ShapeRenderer shapeRenderer;

    public LevelRenderer(Level level, OrthographicCamera camera) {
        this.level = level;
        this.camera = camera;

        shapeRenderer = new ShapeRenderer();
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        {
            for (int y = 0; y < level.height; y++) {
                for (int x = 0; x < level.width; x++) {
                    Tile tile = level.getTile(x, y);
                    if(tile.id == 1) {
                        float xTile = x * Tile.TILE_SIZE;
                        float yTile = y * Tile.TILE_SIZE;
                        spriteBatch.draw(tile.texture, xTile, yTile);
                    }
                }
            }
        }
        spriteBatch.end();
    }
}
