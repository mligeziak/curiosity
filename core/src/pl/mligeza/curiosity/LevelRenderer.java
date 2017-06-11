package pl.mligeza.curiosity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
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

    public void render(SpriteBatch spriteBatch) {
        Gdx.app.log(TAG, "sprites: " + level.tiles.size());

        spriteBatch.begin();
        {
            for (int y = 0; y < level.height; y++) {
                for (int x = 0; x < level.width; x++) {
                    Tile tile = level.tiles.get(x + y * level.height);

                    spriteBatch.draw(tile.texture, x * Tile.TILE_SIZE, y * Tile.TILE_SIZE);
                }
            }
        }
        spriteBatch.end();

        final Vector3 position = camera.position;
        Gdx.app.log(TAG, "camera pos: " + position);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        {
            shapeRenderer.setColor(Color.RED);
            shapeRenderer.rect(position.x, position.y, camera.viewportWidth, camera.viewportHeight);
        }
        shapeRenderer.end();
    }
}
