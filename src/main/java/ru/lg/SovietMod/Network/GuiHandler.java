package ru.lg.SovietMod.Network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.Blocks.Bedside.ContainerBedside;
import ru.lg.SovietMod.Blocks.Bedside.GuiBedside;
import ru.lg.SovietMod.Blocks.Bedside.TileEntityBedside;
import ru.lg.SovietMod.Blocks.SovietBox.ContainerSovietBox;
import ru.lg.SovietMod.Blocks.SovietBox.GuiSovietBox;
import ru.lg.SovietMod.Blocks.SovietBox.TileEntitySovietBox;
import ru.lg.SovietMod.Blocks.TableSide.ContainerTableside;
import ru.lg.SovietMod.Blocks.TableSide.GuiTableside;
import ru.lg.SovietMod.Blocks.TableSide.TileEntityTableside;

public class GuiHandler implements IGuiHandler
{

   public static final int GUI_WATCHER = 0;
   public static final int GUI_TABLE_SIDE = 1;
   public static final int GUI_SOVIET_BOX = 2;
   public static final int GUI_NUMBER_SIGN = 3;
   
//   public static final int GUI_SIGN_BOX = 3;

   @Override
   public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
   {
       switch (ID)
       {
           case GUI_WATCHER: return new ContainerBedside(player.inventory, (TileEntityBedside) world.getTileEntity(new BlockPos(x, y, z)));
           case GUI_TABLE_SIDE: return new ContainerTableside(player.inventory, (TileEntityTableside) world.getTileEntity(new BlockPos(x, y, z)));
           case GUI_SOVIET_BOX: return new ContainerSovietBox(player.inventory, (TileEntitySovietBox) world.getTileEntity(new BlockPos(x, y, z)));
           default: return null;
       }
   }

   @Override
   @SideOnly(Side.CLIENT)
   public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
   {
       switch (ID)
       {
   
           case GUI_WATCHER: return new GuiBedside(new ContainerBedside(player.inventory, (TileEntityBedside) world.getTileEntity(new BlockPos(x, y, z))));
           case GUI_TABLE_SIDE: return new GuiTableside(new ContainerTableside(player.inventory, (TileEntityTableside) world.getTileEntity(new BlockPos(x, y, z))));
           case GUI_SOVIET_BOX: return new GuiSovietBox(new ContainerSovietBox(player.inventory, (TileEntitySovietBox) world.getTileEntity(new BlockPos(x, y, z))));
          
           default: return null;
       }
   }
}