package me.gergoo007.velocity.utils.render;

import java.awt.Color;

public class Rainbow {

	public static int getRainbow() {
		float hue = System.currentTimeMillis() % 6000 / 6000F;
		return Color.HSBtoRGB(hue, 0.8F, 0.9F);
	}
	
	public static int getRainbow(long i) {
		float hue = System.currentTimeMillis() + i % 6000 / 6000F;
		return Color.HSBtoRGB(hue, 0.8F, 0.8F);
	}
	
}
