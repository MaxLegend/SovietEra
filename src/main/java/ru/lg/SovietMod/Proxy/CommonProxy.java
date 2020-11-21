package ru.lg.SovietMod.Proxy;

import com.google.common.collect.ImmutableMap;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.animation.ITimeValue;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.RegConfig;
import ru.lg.SovietMod.RegCrafts;
import ru.lg.SovietMod.RegEntity;
import ru.lg.SovietMod.RegFluids;
import ru.lg.SovietMod.RegItems;
import ru.lg.SovietMod.SovietCore;
import ru.lg.SovietMod.Blocks.DryCab.TileEntityDryCab;
import ru.lg.SovietMod.Blocks.LabTable.TileEntityLabTable;
import ru.lg.SovietMod.Blocks.SovietBox.TileEntitySovietBox;
import ru.lg.SovietMod.Blocks.SovietTumb.TileEntityTumb;
import ru.lg.SovietMod.Blocks.WoodLabTable.TileEntityWLabTable;
import ru.lg.SovietMod.Entity.EntityDspPanel1;
import ru.lg.SovietMod.Entity.EntityRedBanner;
import ru.lg.SovietMod.Entity.EntitySittableBlock;
import ru.lg.SovietMod.Entity.EntityWallCarpet;
import ru.lg.SovietMod.Entity.EntityWallTile1;
import ru.lg.SovietMod.Entity.EntityWallTile2;
import ru.lg.SovietMod.Entity.EntityWallpaper;
import ru.lg.SovietMod.Entity.EntityWallpaper2;
import ru.lg.SovietMod.Entity.EntityWallpaper3;
import ru.lg.SovietMod.Entity.EntityWallpaper4;
import ru.lg.SovietMod.Entity.EntityWallpaper5;
import ru.lg.SovietMod.Event.RegEvents.Server;
import ru.lg.SovietMod.Network.GuiHandler;
import ru.lg.SovietMod.WorldGen.WorldGenLab;

public class CommonProxy {
	public static WorldGenLab wgl = new WorldGenLab();

	//public static WorldGenSovietMod wghouse = new WorldGenSovietMod();

	public void preInit(FMLPreInitializationEvent event) {
		
		RegConfig.register(event);
		RegFluids.register();
		RegBlocks.register();
		RegItems.register();
		RegEntity.register();
		new Server();

		EntityRegistry.registerModEntity(new ResourceLocation(SovietCore.MODID, "entitywallpaper"), EntityWallpaper.class, SovietCore.MODID + ":entitywallpaper", 45, SovietCore.INSTANCE, 64, 20, false);
		EntityRegistry.registerModEntity(new ResourceLocation(SovietCore.MODID, "entitywallpaper2"), EntityWallpaper2.class, SovietCore.MODID + ":entitywallpaper2", 46, SovietCore.INSTANCE, 64, 20, false);
		EntityRegistry.registerModEntity(new ResourceLocation(SovietCore.MODID, "entitywallpaper3"), EntityWallpaper3.class, SovietCore.MODID + ":entitywallpaper3", 47, SovietCore.INSTANCE, 64, 20, false);
		EntityRegistry.registerModEntity(new ResourceLocation(SovietCore.MODID, "entityredbanner"), EntityRedBanner.class, SovietCore.MODID + ":entityredbanner", 48, SovietCore.INSTANCE, 64, 20, false);
		EntityRegistry.registerModEntity(new ResourceLocation(SovietCore.MODID, "sit_block"), EntitySittableBlock.class, "sit_block", 49, SovietCore.INSTANCE, 80, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation(SovietCore.MODID, "entitywallcarpet"), EntityWallCarpet.class, SovietCore.MODID + ":entitywallcarpet", 50, SovietCore.INSTANCE, 64, 20, false);

		EntityRegistry.registerModEntity(new ResourceLocation(SovietCore.MODID, "entitywallpaper4"), EntityWallpaper4.class, SovietCore.MODID + ":entitywallpaper4", 51, SovietCore.INSTANCE, 64, 20, false);
		EntityRegistry.registerModEntity(new ResourceLocation(SovietCore.MODID, "entitywallpaper5"), EntityWallpaper5.class, SovietCore.MODID + ":entitywallpaper5", 52, SovietCore.INSTANCE, 64, 20, false);
		EntityRegistry.registerModEntity(new ResourceLocation(SovietCore.MODID, "dsp_panel_1"), EntityDspPanel1.class, SovietCore.MODID + ":dsp_panel_1", 53, SovietCore.INSTANCE, 64, 20, false);
	//	GameRegistry.registerTileEntity(TileEntityNumberSign.class, "TileEntityNumberSign");
		GameRegistry.registerTileEntity(TileEntitySovietBox.class, "TileEntitySovietBox");
		GameRegistry.registerTileEntity(TileEntityDryCab.class, "TileEntityDryCab");
		GameRegistry.registerTileEntity(TileEntityTumb.class, "TileEntityTumb");
		GameRegistry.registerTileEntity(TileEntityLabTable.class, "TileEntityLabTable");
		GameRegistry.registerTileEntity(TileEntityWLabTable.class, "TileEntityWLabTable");
//		GameRegistry.registerTileEntity(TileEntityHermoDoor.class, "TileEntityHermoDoor");
//		GameRegistry.registerTileEntity(TileEntityTrapAnimDoor.class, "TileEntityTrapAnimDoor");
	//	GameRegistry.registerTileEntity(TileEntitySovSign.class, "TileEntitySovSign");
	
		
		EntityRegistry.registerModEntity(new ResourceLocation(SovietCore.MODID, "entitywalltile1"), EntityWallTile1.class, SovietCore.MODID + ":entitywalltile1", 53, SovietCore.INSTANCE, 64, 20, false);
		EntityRegistry.registerModEntity(new ResourceLocation(SovietCore.MODID, "entitywalltile2"), EntityWallTile2.class, SovietCore.MODID + ":entitywalltile2", 54, SovietCore.INSTANCE, 64, 20, false);
	}
	public void init(FMLInitializationEvent event) {
	//	RegCrafts.register();
	//	GameRegistry.registerWorldGenerator(wghouse, 0);
	GameRegistry.registerWorldGenerator(wgl, 1);
		NetworkRegistry.INSTANCE.registerGuiHandler(SovietCore.INSTANCE, new GuiHandler());
	}
	
	public IAnimationStateMachine load(ResourceLocation location, ImmutableMap<String, ITimeValue> parameters) {
		return null;
	}
	public void postInit(FMLPostInitializationEvent event) {}
	public void registerModel(Item item, int metadata) {
		// TODO Auto-generated method stub
		
	}
}
