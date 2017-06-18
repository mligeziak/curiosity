package pl.mligeza.curiosity;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import pl.mligeza.curiosity.level.Level;
import pl.mligeza.curiosity.level.tiles.Tile;

public class LevelRenderer {
    public Level level;
    public OrthographicCamera camera;
    public ShapeRenderer shapeRenderer;

    public LevelRenderer(Level level, OrthographicCamera camera) {
        this.level = level;
        this.camera = camera;

        shapeRenderer = new ShapeRenderer();
    }

    public void updateLevel(Level level) {
        this.level = level;
    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        if (level != null && !level.isEnded) {
            for (int y = 0; y < level.height; y++) {
                for (int x = 0; x < level.width; x++) {
                    Tile tile = level.getTile(x, y);
                    float xTile = x * Tile.TILE_SIZE;
                    float yTile = y * Tile.TILE_SIZE;
                    Texture texture = Assets.getTexture(tile.texId);
                    spriteBatch.draw(texture, xTile, yTile);
                }
            }
        }
        spriteBatch.end();
    }
}
