package ru.lg.SovietMod.Blocks.Safe;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import ru.lg.SovietMod.Blocks.SovietBox.ContainerSovietBox;
import ru.lg.SovietMod.Blocks.SovietBox.TileEntitySovietBox;

public class GuiSafe extends GuiContainer
{  
	public static final int WIDTH = 180;
public static final int HEIGHT = 180;
   private static final ResourceLocation TEXTURE = new ResourceLocation("soviet:textures/gui/safe.png");
   
   public GuiSafe(TileEntitySafe tileEntity, ContainerSafe container) {
       super(container);
 
       xSize = WIDTH;
       ySize = 220;
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