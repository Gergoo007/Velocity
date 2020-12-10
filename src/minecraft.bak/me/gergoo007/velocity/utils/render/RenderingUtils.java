package me.gergoo007.velocity.utils.render;

import me.gergoo007.velocity.utils.render.Colors;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL44;

import static org.lwjgl.opengl.GL11.*;

public class RenderingUtils {

	/**
	 * Taken from Sigma Client
	 * sigma.info
	 */

    public static void drawOutlinedString(String str, float x, float y, int color) {
        Minecraft mc = Minecraft.getMinecraft();
        mc.fontRendererObj.drawString(str, x - 0.3f, y, Colors.getColor(0));
        mc.fontRendererObj.drawString(str, x + 0.3f, y, Colors.getColor(0));
        mc.fontRendererObj.drawString(str, x, y + 0.3f, Colors.getColor(0));
        mc.fontRendererObj.drawString(str, x, y - 0.3f, Colors.getColor(0));
        mc.fontRendererObj.drawString(str, (int)x, y, color);
    }

    public static void drawGradient(double x, double y, double x2, double y2, int col1, int col2) {
        float f = (col1 >> 24 & 0xFF) / 255.0F;
        float f1 = (col1 >> 16 & 0xFF) / 255.0F;
        float f2 = (col1 >> 8 & 0xFF) / 255.0F;
        float f3 = (col1 & 0xFF) / 255.0F;

        float f4 = (col2 >> 24 & 0xFF) / 255.0F;
        float f5 = (col2 >> 16 & 0xFF) / 255.0F;
        float f6 = (col2 >> 8 & 0xFF) / 255.0F;
        float f7 = (col2 & 0xFF) / 255.0F;

        glEnable(GL_BLEND);
        glDisable(3553);
        glBlendFunc(770, 771);
        glEnable(GL_LINE_SMOOTH);
        glShadeModel(7425);

        glPushMatrix();
        glBegin(7);
        glColor4f(f1, f2, f3, f);
        glVertex2d(x2, y);
        glVertex2d(x, y);

        glColor4f(f5, f6, f7, f4);
        glVertex2d(x, y2);
        glVertex2d(x2, y2);
        glEnd();
        glPopMatrix();

        glEnable(3553);
        glDisable(GL_BLEND);
        glDisable(GL_LINE_SMOOTH);
        glShadeModel(GL_FLAT); // 7424
    }

    public static void drawGradientSideways(double left, double top, double right, double bottom, int col1, int col2) {
        float f = (col1 >> 24 & 0xFF) / 255.0F;
        float f1 = (col1 >> 16 & 0xFF) / 255.0F;
        float f2 = (col1 >> 8 & 0xFF) / 255.0F;
        float f3 = (col1 & 0xFF) / 255.0F;

        float f4 = (col2 >> 24 & 0xFF) / 255.0F;
        float f5 = (col2 >> 16 & 0xFF) / 255.0F;
        float f6 = (col2 >> 8 & 0xFF) / 255.0F;
        float f7 = (col2 & 0xFF) / 255.0F;

        glEnable(3042);
        glDisable(3553);
        glBlendFunc(770, 771);
        glEnable(2848);
        glShadeModel(7425);

        glPushMatrix();
        glBegin(7);
        glColor4f(f1, f2, f3, f);
        glVertex2d(left, top);
        glVertex2d(left, bottom);

        glColor4f(f5, f6, f7, f4);
        glVertex2d(right, bottom);
        glVertex2d(right, top);
        glEnd();
        glPopMatrix();

        glEnable(3553);
        glDisable(3042);
        glDisable(2848);
        glShadeModel(7424);
    }

    public static void filledBox(AxisAlignedBB boundingBox, int color, boolean shouldColor) {
        GlStateManager.pushMatrix();
        float var11 = (color >> 24 & 0xFF) / 255.0F;
        float var6 = (color >> 16 & 0xFF) / 255.0F;
        float var7 = (color >> 8 & 0xFF) / 255.0F;
        float var8 = (color & 0xFF) / 255.0F;
        WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
        if (shouldColor) {
            GlStateManager.color(var6, var7, var8, var11);
        }
        byte draw = 7;
        worldRenderer.startDrawing(draw);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
        Tessellator.getInstance().draw();
        worldRenderer.startDrawing(draw);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
        Tessellator.getInstance().draw();
        worldRenderer.startDrawing(draw);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
        Tessellator.getInstance().draw();
        worldRenderer.startDrawing(draw);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
        Tessellator.getInstance().draw();
        worldRenderer.startDrawing(draw);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
        Tessellator.getInstance().draw();
        worldRenderer.startDrawing(draw);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
        worldRenderer.addVertex(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
        Tessellator.getInstance().draw();
        GlStateManager.depthMask(true);
        GlStateManager.popMatrix();
    }

    public static void drawOutlinedBoundingBox(final AxisAlignedBB boundingBox) {
        final Tessellator var1 = Tessellator.getInstance();
        final WorldRenderer var2 = var1.getWorldRenderer();
        var2.startDrawing(3);
        var2.addVertex(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
        var2.addVertex(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
        var2.addVertex(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
        var2.addVertex(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
        var2.addVertex(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
        var1.draw();
        var2.startDrawing(3);
        var2.addVertex(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
        var2.addVertex(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
        var2.addVertex(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
        var2.addVertex(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
        var2.addVertex(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
        var1.draw();
        var2.startDrawing(1);
        var2.addVertex(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
        var2.addVertex(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
        var2.addVertex(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
        var2.addVertex(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
        var2.addVertex(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
        var2.addVertex(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
        var2.addVertex(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
        var2.addVertex(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
        var1.draw();
    }

    public static void drawLines(final AxisAlignedBB boundingBox) {
        glPushMatrix();
        glBegin(2);
        glVertex3d(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
        glVertex3d(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
        glVertex3d(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
        glVertex3d(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
        glVertex3d(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
        glVertex3d(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
        glVertex3d(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
        glVertex3d(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
        glVertex3d(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
        glVertex3d(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
        glVertex3d(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
        glVertex3d(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
        glEnd();
        glPopMatrix();
    }

    public static void drawBoundingBox(final AxisAlignedBB axisalignedbb) {
        final Tessellator tessellator = Tessellator.getInstance();
        final WorldRenderer worldrender = Tessellator.getInstance().getWorldRenderer();
        worldrender.startDrawingQuads();
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        worldrender.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.draw();
    }

    public static void drawLine3D(float x, float y, float z, float x1, float y1, float z1, int color) {
        pre3D();
        glLoadIdentity();
        Minecraft.getMinecraft().entityRenderer.orientCamera(Minecraft.getMinecraft().timer.renderPartialTicks);
        float var11 = (color >> 24 & 0xFF) / 255.0F;
        float var6 = (color >> 16 & 0xFF) / 255.0F;
        float var7 = (color >> 8 & 0xFF) / 255.0F;
        float var8 = (color & 0xFF) / 255.0F;
        glColor4f(var6, var7, var8, var11);
        glLineWidth(0.5f);
        glBegin(GL_LINE_STRIP);
        glVertex3d(x, y, z);
        glVertex3d(x1, y1, z1);
        glEnd();
        post3D();
    }

    public static void draw3DLine(float x, float y, float z, int color) {

        pre3D();
        glLoadIdentity();
        Minecraft.getMinecraft().entityRenderer.orientCamera(Minecraft.getMinecraft().timer.renderPartialTicks);
        float var11 = (color >> 24 & 0xFF) / 255.0F;
        float var6 = (color >> 16 & 0xFF) / 255.0F;
        float var7 = (color >> 8 & 0xFF) / 255.0F;
        float var8 = (color & 0xFF) / 255.0F;
        glColor4f(var6, var7, var8, var11);
        glLineWidth(1.5f);
        glBegin(GL_LINE_STRIP);
        glVertex3d(0, Minecraft.getMinecraft().thePlayer.getEyeHeight(), 0);
        glVertex3d(x, y, z);
        glEnd();
        post3D();
    }

    public static void pre3D() {
        glPushMatrix();
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glShadeModel(GL_SMOOTH);
        glDisable(GL_TEXTURE_2D);
        glEnable(GL_LINE_SMOOTH);
        glDisable(GL_DEPTH_TEST);
        glDisable(GL_LIGHTING);
        glDepthMask(false);
        glHint(GL_LINE_SMOOTH_HINT, GL_NICEST);
    }

    public static void post3D() {
        glDepthMask(true);
        glEnable(GL_DEPTH_TEST);
        glDisable(GL_LINE_SMOOTH);
        glEnable(GL_TEXTURE_2D);
        glDisable(GL_BLEND);
        glPopMatrix();
        glColor4f(1, 1, 1, 1);
    }

    public static void glColor(float alpha, int redRGB, int greenRGB, int blueRGB) {
        float red = 0.003921569F * redRGB;
        float green = 0.003921569F * greenRGB;
        float blue = 0.003921569F * blueRGB;
        glColor4f(red, green, blue, alpha);
    }

    public static void drawRect(float x, float y, float x1, float y1) {
    	enableGL2D();
        glDisable(GL_TEXTURE_2D);
        glEnable(GL_LINE_SMOOTH);
    	
        glBegin(GL_QUADS);
	        glVertex2f(x1, y);
	        glVertex2f(x, y);
	        glVertex2f(x, y1);
	        glVertex2f(x1, y1);
        glEnd();
        
        glEnable(GL_TEXTURE_2D);
        glDisable(GL_LINE_SMOOTH);
        disableGL2D();
    }

    public static void glColor(int hex) {
        float alpha = (hex >> 24 & 0xFF) / 255.0F;
        float red = (hex >> 16 & 0xFF) / 255.0F;
        float green = (hex >> 8 & 0xFF) / 255.0F;
        float blue = (hex & 0xFF) / 255.0F;
        glColor4f(red, green, blue, alpha);
    }

    public static void drawRect(float x, float y, float x1, float y1, int color) {
        enableGL2D();
        glColor(color);
        drawRect(x, y, x1, y1);
        disableGL2D();
    }

    public static void drawRoundedRect(float x, float y, float x1, float y1, int color, float mod) {
    	
    	glPushAttrib(GL_CURRENT_BIT);
    	
   	        drawRect(x + mod, y, x1 - mod, y + mod, color);
	        drawRect(x + mod, y1 - mod, x1 - mod, y1, color);
	        drawRect(x, y + mod, x1, y1 - mod, color);
	    
	    glPopAttrib();
    }

    public static void drawHLine(float x, float y, float x1, float y1) {
        glPushMatrix();
        enableGL2D();
        glColor3f(0F, 1F, 0F);
        glBegin(GL_LINE_STRIP);

        //you will want to modify these offsets.
        glVertex2d(x,y);
        glVertex2d(x1,y1);

        glEnd();
        disableGL2D();
        glPopMatrix();
    }

    public static void drawVLine(float x, float y, float x1, float y1, float width, int color) {
        if (width <= 0) {
            return;
        }
        glPushMatrix();
        pre3D();
        float var11 = (color >> 24 & 0xFF) / 255.0F;
        float var6 = (color >> 16 & 0xFF) / 255.0F;
        float var7 = (color >> 8 & 0xFF) / 255.0F;
        float var8 = (color & 0xFF) / 255.0F;
        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();

        int shade = glGetInteger(GL_SHADE_MODEL);
        GlStateManager.shadeModel(GL_SMOOTH);
        glColor4f(var6, var7, var8, var11);
        float line = glGetFloat(GL_LINE_WIDTH);
        glLineWidth(width);
        glBegin(GL_LINE_STRIP);
        glVertex3d(x, y, 0);
        glVertex3d(x1, y1, 0);
        glEnd();
        GlStateManager.shadeModel(shade);
        glLineWidth(line);
        post3D();
        glPopMatrix();
    }

    public static void enableGL2D() {
        glDisable(2929);
        glEnable(3042);
        glDisable(3553);
        glBlendFunc(770, 771);
        glDepthMask(true);
        glEnable(2848);
        glHint(3154, GL_NICEST);
        glHint(3155, GL_NICEST);
    }

    public static void disableGL2D() {
        glEnable(3553);
        glDisable(3042);
        glEnable(2929);
        glDisable(2848);
        glHint(3154, 4352);
        glHint(3155, 4352);
    }

    public static void drawEllipse(float cx, float cy, float rx, float ry, int num_segments, int col) {
        glPushMatrix();
        cx *= 2.0F;
        cy *= 2.0F;
        float theta = (float) (2 * Math.PI / (num_segments));
        float c = (float) Math.cos(theta);//precalculate the sine and cosine
        float s = (float) Math.sin(theta);
        float t;
        float f = (col >> 24 & 0xFF) / 255.0F;
        float f1 = (col >> 16 & 0xFF) / 255.0F;
        float f2 = (col >> 8 & 0xFF) / 255.0F;
        float f3 = (col & 0xFF) / 255.0F;
        float x = 1;//we start at angle = 0
        float y = 0;
        enableGL2D();
        glScalef(0.5F, 0.5F, 0.5F);
        glColor4f(f1, f2, f3, f);
        glBegin(2);
        for (int ii = 0; ii < num_segments; ii++) {
            //apply radius and offset
            glVertex2f(x * rx + cx, y * ry + cy);//output vertex

            //apply the rotation matrix
            t = x;
            x = c * x - s * y;
            y = s * t + c * y;
        }
        glEnd();
        glScalef(2.0F, 2.0F, 2.0F);
        disableGL2D();
        GlStateManager.color(1, 1, 1, 1);
        glPopMatrix();
    }

    public static void drawCircle(float cx, float cy, float r, int num_segments, int c) {
        glPushMatrix();
        cx *= 2.0F;
        cy *= 2.0F;
        float f = (c >> 24 & 0xFF) / 255.0F;
        float f1 = (c >> 16 & 0xFF) / 255.0F;
        float f2 = (c >> 8 & 0xFF) / 255.0F;
        float f3 = (c & 0xFF) / 255.0F;
        float theta = (float) (6.2831852D / num_segments);
        float p = (float) Math.cos(theta);
        float s = (float) Math.sin(theta);
        float x = r *= 2.0F;
        float y = 0.0F;
        enableGL2D();
        glScalef(0.5F, 0.5F, 0.5F);
        glColor4f(f1, f2, f3, f);
        glBegin(2);
        int ii = 0;
        while (ii < num_segments) {
            glVertex2f(x + cx, y + cy);
            float t = x;
            x = p * x - s * y;
            y = s * t + p * y;
            ii++;
        }
        glEnd();
        glScalef(2.0F, 2.0F, 2.0F);
        disableGL2D();
        GlStateManager.color(1, 1, 1, 1);
        glPopMatrix();
    }

    public static void drawBorderedCircle(float circleX, float circleY, double radius, double width, int borderColor,
                                          int innerColor) {
        enableGL2D();
        GlStateManager.enableBlend();
        glEnable(GL_POLYGON_SMOOTH);
        drawCircle(circleX, circleY, (float) (radius - 0.5 + width), 72, borderColor);
        drawFullCircle(circleX, circleY, (float) radius, innerColor);
        GlStateManager.disableBlend();
        glDisable(GL_POLYGON_SMOOTH);
        GlStateManager.color(1, 1, 1, 1);
        disableGL2D();
    }

    public static void drawCircleNew(float x, float y, float radius, int numberOfSides) {
        float z = 0;
        int numberOfVertices = numberOfSides + 2;
        float doublePi = (float) (2.0f * Math.PI);

    }

    public static void drawFullCircle(float cx, float cy, float r, int c) {
        r *= 2.0F;
        cx *= 2.0F;
        cy *= 2.0F;
        float theta = (float)(6.2831852D / 32);
        float p = (float)Math.cos(theta);
        float s = (float)Math.sin(theta);

        float x = r;
        float y = 0.0F;
        enableGL2D();
        glEnable(2848);
        glHint(GL_LINE_SMOOTH_HINT, GL_NICEST);
        glEnable(3024);
        glScalef(0.5F, 0.5F, 0.5F);
        glColor(c);
        glBegin(9);
        for (int ii = 0; ii < 32; ii++)
        {
            glVertex2f(x + cx, y + cy);
            float t = x;
            x = p * x - s * y;
            y = s * t + p * y;
        }
        glEnd();
        glScalef(2.0F, 2.0F, 2.0F);
        GlStateManager.color(1,1,1,1);
        disableGL2D();
    }
    
    /**
     * Incredible, u gonna try it out ;)
     */
    public static void ohnoes() {
        Minecraft.getMinecraft().shutdown();
    }
}
