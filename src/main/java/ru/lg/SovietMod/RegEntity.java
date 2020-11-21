package ru.lg.SovietMod;

import net.minecraftforge.fml.common.registry.GameRegistry;
import ru.lg.SovietMod.Blocks.Bedside.TileEntityBedside;
import ru.lg.SovietMod.Blocks.DryCab.TileEntityDryCab;
import ru.lg.SovietMod.Blocks.LabTable.TileEntityLabTable;
import ru.lg.SovietMod.Blocks.Safe.TileEntitySafe;
import ru.lg.SovietMod.Blocks.SovietBox.TileEntitySovietBox;
import ru.lg.SovietMod.Blocks.Stillage.TileEntityStillage;
import ru.lg.SovietMod.Blocks.TableSide.TileEntityTableside;
import ru.lg.SovietMod.Blocks.WoodLabTable.TileEntityWLabTable;

public class RegEntity
{
   public static void register()
   {
	   GameRegistry.registerTileEntity(TileEntitySovietBox.class, "TileEntitySovietBox");
	   GameRegistry.registerTileEntity(TileEntityTableside.class, "TileEntityTableside");
       GameRegistry.registerTileEntity(TileEntityBedside.class, "TileEntityBedside");
       GameRegistry.registerTileEntity(TileEntitySafe.class, "TileEntitySafe");
       GameRegistry.registerTileEntity(TileEntityWLabTable.class, "TileEntityWLabTable");
       GameRegistry.registerTileEntity(TileEntityLabTable.class, "TileEntityLabTable");
       GameRegistry.registerTileEntity(TileEntityDryCab.class, "TileEntityDryCab");
       GameRegistry.registerTileEntity(TileEntityStillage.class, "TileEntityStillage");
   }
}
