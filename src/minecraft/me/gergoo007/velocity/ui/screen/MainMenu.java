package me.gergoo007.velocity.ui.screen;

import me.gergoo007.velocity.Client;
import me.gergoo007.velocity.utils.render.Rainbow;
import me.gergoo007.velocity.utils.render.RenderingUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class MainMenu extends GuiScreen {
	
	static Minecraft mc = Minecraft.getMinecraft();
	static FontRenderer fr = mc.fontRendererObj;
	
	public void initGui() { 
		ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		
		this.buttonList.add(new GuiButton(4, 10, sr.getScaledHeight() - 30, 90, 20, "Quit"));
		this.buttonList.add(new GuiButton(3, 10, sr.getScaledHeight() - 30 * 2, 90, 20, "Settings"));
		this.buttonList.add(new GuiButton(2, 10, sr.getScaledHeight() - 30 * 3, 90, 20, "Multiplayer"));
		this.buttonList.add(new GuiButton(1, 10, sr.getScaledHeight() - 30 * 4, 90, 20, "Singleplayer"));
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		int color = Rainbow.getRainbow();
		
		ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		
		this.drawRect(0, 0, sr.getScaledWidth(), sr.getScaledHeight(), 0xff000000);
			
		// Title
		mc.fontRendererObj.drawStringWithShadow("Velocity", (sr.getScaledWidth() - mc.fontRendererObj.getStringWidth("Velocity")) / 2 - 30, sr.getScaledHeight() / 2 - 10, -1, 3);
		super.drawScreen(mouseX, mouseY, partialTicks);
		
	}
	
	protected void actionPerformed(GuiButton btn) {
		switch(btn.id) {
			case 1:
				mc.displayGuiScreen(new GuiSelectWorld(this));
				break;
			case 2:
				mc.displayGuiScreen(new GuiMultiplayer(this));
				break;
			case 3:
				mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
				break;
			case 4:
				mc.shutdown();
				break;
			default:
				throw new IllegalStateException();
		}
		/*
		if(btn.id == 1) {
			mc.displayGuiScreen(new GuiSelectWorld(this));
			System.out.println(btn.id);
		} else if (btn.id == 2) {
			mc.displayGuiScreen(new GuiMultiplayer(this));
			System.out.println(btn.id);
		} else if (btn.id == 3) {
			mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
			System.out.println(btn.id);
		} else if(btn.id == 4) {
			mc.shutdown();
			System.out.println(btn.id);
		} else {
			throw new IllegalStateException();
		}
		*/
	}

}
