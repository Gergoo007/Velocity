package me.gergoo007.velocity.ui.screen;

import me.gergoo007.velocity.utils.render.RenderingUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

public class MainMenu extends GuiScreen {
	
	static Minecraft mc = Minecraft.getMinecraft();
	
	public void initGui() {
		this.buttonList.add(new GuiButton(5, 5, 5, 5, 5, "Hello"));
	}
	
	public void drawScreen() {
		ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		
		RenderingUtils.drawGradient(0, 0, sr.getScaledWidth(), sr.getScaledHeight(), -1, 0);
	}

}
