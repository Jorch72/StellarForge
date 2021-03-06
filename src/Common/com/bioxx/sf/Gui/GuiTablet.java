package com.bioxx.sf.Gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.bioxx.sf.Reference;

public class GuiTablet extends GuiTabletBase
{
	private static ResourceLocation TabletTex = new ResourceLocation(Reference.ModID, Reference.AssetPathGui + "gui_tablet.png");

	public GuiTablet(EntityPlayer player)
	{
		super(player);
	}

	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_)
	{
		this.drawGui(TabletTex);
		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
	}

	@Override
	public void initGui()
	{
		super.initGui();
		guiLeft = (width - xSize) / 2;
		guiTop = (height - ySize) / 2;
		buttonList.clear();
		buttonList.add(new TabletButton(0, guiLeft+11, guiTop+11, 16, 16,"", 0, 144, 16, 16, this));
		buttonList.add(new TabletButton(1, guiLeft+29, guiTop+11, 16, 16,"", 16, 144, 16, 16, this));
	}

	@Override
	protected void actionPerformed(GuiButton guibutton)
	{
		if (guibutton.id == 1)
			Minecraft.getMinecraft().displayGuiScreen(new GuiTabletMap(player));
	}

	@Override
	protected void drawGui(ResourceLocation rl)
	{
		if(rl != null)
		{
			this.bindTexture(rl);

			drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		}
	}

	@Override
	protected void bindTexture(ResourceLocation rl)
	{
		mc.getTextureManager().bindTexture(rl);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public void drawTooltip(int mx, int my, String text) {
		List list = new ArrayList();
		list.add(text);
		this.drawHoveringText(list, mx, my+15, mc.fontRenderer);
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
	}
}
