package me.gergoo007.velocity.ui;

import org.lwjgl.input.Keyboard;

import me.gergoo007.velocity.Client;
import me.gergoo007.velocity.utils.render.Rainbow;
import me.gergoo007.velocity.utils.render.RenderingUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.AxisAlignedBB;

public class HUD {
	
	static Minecraft mc = Minecraft.getMinecraft();
	static FontRenderer fr = mc.fontRendererObj;

 	public HUD() {  }
	
	public static void draw() {
		if(!mc.gameSettings.showDebugInfo) {
			fr.drawStringWithShadow(Client.title, 4, 4, Rainbow.getRainbow(), 1.5);
		}
	}
}
