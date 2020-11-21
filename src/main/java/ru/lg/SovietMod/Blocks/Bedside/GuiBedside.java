package ru.lg.SovietMod.Blocks.Bedside;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiBedside extends GuiContainer
{
   private static final ResourceLocation TEXTURE = new ResourceLocation("soviet:textures/gui/bedside.png");
   
   public GuiBedside(Container inventorySlotsIn)
   {
       super(inventorySlotsIn);
   }


   
   @Override
   protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
	 
       mc.getTextureManager().bindTexture(TEXTURE);
       int x = (this.width - this.xSize) / 2;
       int y = (this.height - this.xSize) / 2;
       drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
       
   }
   @Override
   public void drawScreen(int mouseX, int mouseY, float partialTicks)
   {
	   this.drawDefaultBackground();
       this.drawGuiContainerBackgroundLayer(partialTicks, mouseY, mouseY);
       super.drawScreen(mouseX, mouseY, partialTicks);
       this.renderHoveredToolTip(mouseX, mouseY);
   }
}