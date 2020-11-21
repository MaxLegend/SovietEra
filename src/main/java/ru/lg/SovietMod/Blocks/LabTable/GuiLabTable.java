package ru.lg.SovietMod.Blocks.LabTable;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class GuiLabTable extends GuiContainer
{  
	public static final int WIDTH = 180;
public static final int HEIGHT = 152;
   private static final ResourceLocation TEXTURE = new ResourceLocation("soviet:textures/gui/lab_table.png");
   
   public GuiLabTable(TileEntityLabTable tileEntity, ContainerLabTable  container) {
       super(container);

       xSize = 180;
       ySize = 180;
   }

   @Override
   protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
       mc.getTextureManager().bindTexture(TEXTURE);
       drawTexturedModalRect(guiLeft +1, guiTop - 14, 0, -14, xSize, ySize);
       
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
