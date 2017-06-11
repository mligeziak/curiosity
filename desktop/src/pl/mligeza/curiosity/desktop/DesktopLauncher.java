package pl.mligeza.curiosity.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import pl.mligeza.curiosity.Curiosity;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Curiosity";
		config.width = 1280;
		config.height = 720;
		config.resizable = false;
		config.vSyncEnabled = true;
		new LwjglApplication(new Curiosity(), config);
	}
}
