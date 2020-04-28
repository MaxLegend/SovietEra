package ru.lg.SovietMod;

import net.minecraftforge.fml.common.registry.GameRegistry;
import ru.lg.SovietMod.Blocks.Bedside.TileEntityBedside;
import ru.lg.SovietMod.Blocks.SovietBox.TileEntitySovietBox;
import ru.lg.SovietMod.Blocks.TableSide.TileEntityTableside;

public class RegEntity
{
   public static void register()
   {
	   GameRegistry.registerTileEntity(TileEntitySovietBox.class, "TileEntitySovietBox");
	   GameRegistry.registerTileEntity(TileEntityTableside.class, "TileEntityTableside");
       GameRegistry.registerTileEntity(TileEntityBedside.class, "TileEntityBedside");
   }
}
