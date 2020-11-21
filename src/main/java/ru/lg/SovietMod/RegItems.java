package ru.lg.SovietMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import ru.lg.SovietMod.Entity.EntityDspPanel1;
import ru.lg.SovietMod.Entity.EntityRedBanner;
import ru.lg.SovietMod.Entity.EntityWallCarpet;
import ru.lg.SovietMod.Entity.EntityWallTile1;
import ru.lg.SovietMod.Entity.EntityWallTile2;
import ru.lg.SovietMod.Entity.EntityWallpaper;
import ru.lg.SovietMod.Entity.EntityWallpaper2;
import ru.lg.SovietMod.Entity.EntityWallpaper3;
import ru.lg.SovietMod.Entity.EntityWallpaper4;
import ru.lg.SovietMod.Entity.EntityWallpaper5;
import ru.lg.SovietMod.Items.BasicDoorItem;
import ru.lg.SovietMod.Items.BasicItem;
import ru.lg.SovietMod.Items.BasicItemWithInfo;
import ru.lg.SovietMod.Items.ItemDspPanel1;
import ru.lg.SovietMod.Items.ItemHammer;
import ru.lg.SovietMod.Items.ItemRedBanner;
import ru.lg.SovietMod.Items.ItemWallCarpet;
import ru.lg.SovietMod.Items.ItemWallTile1;
import ru.lg.SovietMod.Items.ItemWallTile2;
import ru.lg.SovietMod.Items.ItemWallpaper;
import ru.lg.SovietMod.Items.ItemWallpaper2;
import ru.lg.SovietMod.Items.ItemWallpaper3;
import ru.lg.SovietMod.Items.ItemWallpaper4;
import ru.lg.SovietMod.Items.ItemWallpaper5;
import ru.lg.SovietMod.Items.SovietBedItem;

public class RegItems
{
//	public static ItemArmor.ArmorMaterial armorMaterial = EnumHelper.addArmorMaterial("soviet:lab_coat", "soviet:lab_coat", 9, new int[]{2, 4, 6, 3}, 7, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);
//	public static Item lab_coat = new LabCoat("lab_coat", 1, SovietCore.tabItems, EntityEquipmentSlot.CHEST, armorMaterial);
//	public static Item item_record_hymn_ussr = new ItemSovietRecord("item_record_hymn_ussr","item_record_hymn_ussr", RegSounds.hymnussr);
//	public static Item item_record_stalker_mt = new ItemSovietRecord("item_record_stalker_mt","item_record_stalker_mt", RegSounds.stalkertheme);


	
	public static Item soviet_bed_item = new SovietBedItem("soviet_bed_item", 1, SovietCore.tabInsDeco);
	
	public static Item armature = new BasicItem("armature", 64, SovietCore.tabItems);
	public static Item tile = new BasicItem("tile", 64, SovietCore.tabItems);
	public static Item quad_tile = new BasicItem("quadtile", 64, SovietCore.tabItems);
	public static Item quad_tile_small = new BasicItem("quad_tile_small", 64, SovietCore.tabItems);
	public static Item big_tile = new BasicItem("big_tile", 64, SovietCore.tabItems);
	public static Item quadtile_glass = new BasicItem("quadtile_glass", 64, SovietCore.tabItems);
	public static Item andesite_rock = new BasicItem("andesite_rock", 64, SovietCore.tabItems);
	public static Item white_brick = new BasicItem("white_brick", 64, SovietCore.tabItems);
	public static Item adh_tile = new BasicItem("adh_tile", 64, SovietCore.tabItems);
	//public static Item aluminum_ingot = new BasicItem("aluminum_ingot", 64, SovietCore.tabItems);
	public static ItemPickaxe hammer = new ItemHammer("hammer", 1, SovietCore.tabItems);

	
	public static Item soviet_steel = new BasicItemWithInfo("soviet_steel", 64, SovietCore.tabItems,"sov_steel_desc.name");
	public static Item wrench = new BasicItemWithInfo("wrench", 64, SovietCore.tabItems,"wrench.name");

	public static Item rusty_iron_door_item = new BasicDoorItem("rusty_iron_door_item", RegBlocks.rusty_iron_door); 
	public static Item hermodoor_item = new BasicDoorItem("hermodoor_item", RegBlocks.hermo_door); 
	public static Item ralling_door_item = new BasicDoorItem("ralling_door_item", RegBlocks.ralling_door); 
	public static Item wood_door_item = new BasicDoorItem("wood_door_item", RegBlocks.wood_door); 
	public static Item wood_door_into_item = new BasicDoorItem("wood_door_into_item", RegBlocks.wood_door_into);
	public static Item airlock_door_item = new BasicDoorItem("airlock_door_item", RegBlocks.airlock_door);
	public static Item alm_door_item = new BasicDoorItem("alm_door_item", RegBlocks.alm_door);
	
	public static Item item_walltile_1 = new ItemWallTile1("walltile_1", EntityWallTile1.class);
	public static Item item_walltile_2 = new ItemWallTile2("walltile_2", EntityWallTile2.class);
	
	public static Item item_wallpaper_1 = new ItemWallpaper("wallpaper_1", EntityWallpaper.class).setCreativeTab(SovietCore.tabInsDeco);
	public static Item item_wallpaper_2 = new ItemWallpaper2("wallpaper_2", EntityWallpaper2.class).setCreativeTab(SovietCore.tabInsDeco);
	public static Item item_wallpaper_3 = new ItemWallpaper3("wallpaper_3", EntityWallpaper3.class).setCreativeTab(SovietCore.tabInsDeco);
	public static Item item_wallpaper_4 = new ItemWallpaper4("wallpaper_4", EntityWallpaper4.class).setCreativeTab(SovietCore.tabInsDeco);
	public static Item item_wallpaper_5 = new ItemWallpaper5("wallpaper_5", EntityWallpaper5.class).setCreativeTab(SovietCore.tabInsDeco);
	
	public static Item item_dsp_panel_1 = new ItemDspPanel1("item_dsp_panel_1", EntityDspPanel1.class).setCreativeTab(SovietCore.tabInsDeco);
	
	
	public static Item item_red_banner = new ItemRedBanner("item_red_banner", EntityRedBanner.class).setCreativeTab(SovietCore.tabInsDeco);
	public static Item item_wall_carpet = new ItemWallCarpet("item_wall_carpet", EntityWallCarpet.class).setCreativeTab(SovietCore.tabInsDeco);

	public static void register() {
//		registerItem(swamp_water_bucket);
		registerItem(soviet_bed_item);
		registerItem(rusty_iron_door_item);
		registerItem(alm_door_item);
		registerItem(adh_tile);
		registerItem(wrench);
		registerItem(quad_tile);
		registerItem(big_tile);
		registerItem(white_brick);
		registerItem(tile);
		registerItem(andesite_rock);
		registerItem(hammer);
		registerItem(ralling_door_item);
		registerItem(quad_tile_small);
		registerItem(item_walltile_1);
		registerItem(item_walltile_2);
		registerItem(quadtile_glass);
		
		registerItem(hermodoor_item);
		registerItem(airlock_door_item);
		registerItem(wood_door_item);
		registerItem(wood_door_into_item);
		registerItem(soviet_steel);
		registerItem(armature);
		registerItem(item_wallpaper_1);
		registerItem(item_dsp_panel_1);
		registerItem(item_wallpaper_2);
		registerItem(item_wallpaper_3);
		registerItem(item_wallpaper_4);
		registerItem(item_wallpaper_5);
		registerItem(item_red_banner);
	}
	public static void registerRender() {
		
//		registerRenderItem(swamp_water_bucket);
		registerRenderItem(soviet_bed_item);
		registerRenderItem(rusty_iron_door_item);
		registerRenderItem(hermodoor_item);
		registerRenderItem(adh_tile);
		registerRenderItem(wrench);
		registerRenderItem(alm_door_item);
		registerRenderItem(big_tile);
		registerRenderItem(quad_tile_small);
		registerRenderItem(quadtile_glass);
		registerRenderItem(white_brick);
		registerRenderItem(wood_door_into_item);
		registerRenderItem(tile);
		registerRenderItem(quad_tile);
		registerRenderItem(hammer);
		registerRenderItem(andesite_rock);
		registerRenderItem(ralling_door_item);
		registerRenderItem(wood_door_item);
		registerRenderItem(airlock_door_item);
		registerRenderItem(item_walltile_1);
		registerRenderItem(item_walltile_2);
		registerRenderItem(item_dsp_panel_1);
	
		registerRenderItem(soviet_steel);
		registerRenderItem(armature);
		registerRenderItem(item_wallpaper_1);
		registerRenderItem(item_wallpaper_2);
		registerRenderItem(item_wallpaper_3);
		registerRenderItem(item_wallpaper_4);
		registerRenderItem(item_wallpaper_5);
		registerRenderItem(item_red_banner);
	}
	private static void registerItem(Item item) {
		ForgeRegistries.ITEMS.register(item);
	}
	private static void registerRenderItem(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}