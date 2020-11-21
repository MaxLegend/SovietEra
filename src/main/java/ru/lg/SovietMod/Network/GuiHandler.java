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
import ru.lg.SovietMod.Blocks.DryCab.ContainerDryCab;
import ru.lg.SovietMod.Blocks.DryCab.GuiDryCab;
import ru.lg.SovietMod.Blocks.DryCab.TileEntityDryCab;
import ru.lg.SovietMod.Blocks.LabTable.ContainerLabTable;
import ru.lg.SovietMod.Blocks.LabTable.GuiLabTable;
import ru.lg.SovietMod.Blocks.LabTable.TileEntityLabTable;
import ru.lg.SovietMod.Blocks.Safe.ContainerSafe;
import ru.lg.SovietMod.Blocks.Safe.GuiSafe;
import ru.lg.SovietMod.Blocks.Safe.TileEntitySafe;
import ru.lg.SovietMod.Blocks.SovietBox.ContainerSovietBox;
import ru.lg.SovietMod.Blocks.SovietBox.GuiSovietBox;
import ru.lg.SovietMod.Blocks.SovietBox.TileEntitySovietBox;
import ru.lg.SovietMod.Blocks.SovietTumb.ContainerTumb;
import ru.lg.SovietMod.Blocks.SovietTumb.GuiTumb;
import ru.lg.SovietMod.Blocks.SovietTumb.TileEntityTumb;
import ru.lg.SovietMod.Blocks.Stillage.ContainerStillage;
import ru.lg.SovietMod.Blocks.Stillage.GuiStillage;
import ru.lg.SovietMod.Blocks.Stillage.TileEntityStillage;
import ru.lg.SovietMod.Blocks.TableSide.ContainerTableside;
import ru.lg.SovietMod.Blocks.TableSide.GuiTableside;
import ru.lg.SovietMod.Blocks.TableSide.TileEntityTableside;
import ru.lg.SovietMod.Blocks.WoodLabTable.ContainerWLabTable;
import ru.lg.SovietMod.Blocks.WoodLabTable.GuiWLabTable;
import ru.lg.SovietMod.Blocks.WoodLabTable.TileEntityWLabTable;

public class GuiHandler implements IGuiHandler
{

   public static final int GUI_WATCHER = 0;
   public static final int GUI_TABLE_SIDE = 1;
   public static final int GUI_SOVIET_BOX = 2;
   public static final int GUI_NUMBER_SIGN = 3;
   public static final int GUI_DRY_CAB = 4;
   public static final int GUI_TUMB = 5;
   public static final int GUI_LT = 6;
   public static final int GUI_LT_LEFT = 7;
   public static final int GUI_LT_RIGHT = 8;
   public static final int GUI_WLT = 9;
   public static final int GUI_WLT_BREAK = 10;
   public static final int GUI_SAFE = 11;
  public static final int GUI_STILLAGE = 12;

   @Override
   public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
   {
       switch (ID)
       { 

           case GUI_WATCHER: return new ContainerBedside(player.inventory, (TileEntityBedside) world.getTileEntity(new BlockPos(x, y, z)));
           case GUI_TABLE_SIDE: return new ContainerTableside(player.inventory, (TileEntityTableside) world.getTileEntity(new BlockPos(x, y, z)));
           case GUI_SOVIET_BOX: return new ContainerSovietBox(player.inventory, (TileEntitySovietBox) world.getTileEntity(new BlockPos(x, y, z)), player);
           case GUI_DRY_CAB: return new ContainerDryCab(player.inventory, (TileEntityDryCab) world.getTileEntity(new BlockPos(x, y, z)), player);
           case GUI_TUMB: return new ContainerTumb(player.inventory, (TileEntityTumb) world.getTileEntity(new BlockPos(x, y, z)), player);
           case GUI_LT: return new ContainerLabTable(player.inventory, (TileEntityLabTable) world.getTileEntity(new BlockPos(x, y, z)), player);
           case GUI_LT_LEFT: return new ContainerLabTable(player.inventory, (TileEntityLabTable) world.getTileEntity(new BlockPos(x, y, z)), player);
           case GUI_LT_RIGHT: return new ContainerLabTable(player.inventory, (TileEntityLabTable) world.getTileEntity(new BlockPos(x, y, z)), player);
           case GUI_WLT: return new ContainerWLabTable(player.inventory, (TileEntityWLabTable) world.getTileEntity(new BlockPos(x, y, z)), player);
           case GUI_WLT_BREAK: return new ContainerWLabTable(player.inventory, (TileEntityWLabTable) world.getTileEntity(new BlockPos(x, y, z)), player);
           case GUI_SAFE: return new ContainerSafe(player.inventory, (TileEntitySafe) world.getTileEntity(new BlockPos(x, y, z)), player);
           case GUI_STILLAGE: return new ContainerStillage(player.inventory, (TileEntityStillage) world.getTileEntity(new BlockPos(x, y, z)), player);
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
           case GUI_SOVIET_BOX: return new GuiSovietBox((TileEntitySovietBox) world.getTileEntity(new BlockPos(x, y, z)), new ContainerSovietBox(player.inventory, (TileEntitySovietBox) world.getTileEntity(new BlockPos(x, y, z)), player));
           case GUI_DRY_CAB: return new GuiDryCab((TileEntityDryCab) world.getTileEntity(new BlockPos(x, y, z)), new ContainerDryCab(player.inventory, (TileEntityDryCab) world.getTileEntity(new BlockPos(x, y, z)), player));
           case GUI_TUMB: return new GuiTumb((TileEntityTumb) world.getTileEntity(new BlockPos(x, y, z)), new ContainerTumb(player.inventory, (TileEntityTumb) world.getTileEntity(new BlockPos(x, y, z)), player));
           case GUI_LT: return new GuiLabTable((TileEntityLabTable) world.getTileEntity(new BlockPos(x, y, z)), new ContainerLabTable(player.inventory, (TileEntityLabTable) world.getTileEntity(new BlockPos(x, y, z)), player));
           case GUI_LT_LEFT: return new GuiLabTable((TileEntityLabTable) world.getTileEntity(new BlockPos(x, y, z)), new ContainerLabTable(player.inventory, (TileEntityLabTable) world.getTileEntity(new BlockPos(x, y, z)), player));
           case GUI_LT_RIGHT: return new GuiLabTable((TileEntityLabTable) world.getTileEntity(new BlockPos(x, y, z)), new ContainerLabTable(player.inventory, (TileEntityLabTable) world.getTileEntity(new BlockPos(x, y, z)), player));
           case GUI_WLT: return new GuiWLabTable((TileEntityWLabTable) world.getTileEntity(new BlockPos(x, y, z)), new ContainerWLabTable(player.inventory, (TileEntityWLabTable) world.getTileEntity(new BlockPos(x, y, z)), player));
           case GUI_WLT_BREAK: return new GuiWLabTable((TileEntityWLabTable) world.getTileEntity(new BlockPos(x, y, z)), new ContainerWLabTable(player.inventory, (TileEntityWLabTable) world.getTileEntity(new BlockPos(x, y, z)), player));
           case GUI_SAFE: return new GuiSafe((TileEntitySafe) world.getTileEntity(new BlockPos(x, y, z)), new ContainerSafe(player.inventory, (TileEntitySafe) world.getTileEntity(new BlockPos(x, y, z)), player));
           case GUI_STILLAGE: return new GuiStillage((TileEntityStillage) world.getTileEntity(new BlockPos(x, y, z)), new ContainerStillage(player.inventory, (TileEntityStillage) world.getTileEntity(new BlockPos(x, y, z)), player));

           default: return null;
       }
   }
}