package ru.lg.SovietMod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegCrafts {
	public static void register() {
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(RegItems.armature, 1), new ItemStack(Items.IRON_NUGGET, 3), 4f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(RegBlocks.iron_beam_thin, 1), new ItemStack(RegItems.soviet_steel, 16), 1f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(RegBlocks.iron_beam_thin_vertical, 1), new ItemStack(RegItems.soviet_steel, 16), 2f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(RegBlocks.iron_beam_vertical, 1), new ItemStack(RegItems.soviet_steel, 32),3f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(RegBlocks.iron_beam, 1), new ItemStack(RegItems.soviet_steel, 32), 2f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(RegItems.soviet_steel, 2), new ItemStack(Items.IRON_INGOT, 1), 1f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(RegBlocks.raw_beton, 1), new ItemStack(RegBlocks.betons, 1), 4f);
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(Blocks.STONE, 1, 3), new ItemStack(RegBlocks.travertine_block, 1), 4f);
		
		GameRegistry.addShapedRecipe(new ResourceLocation("po_2"), new ResourceLocation("po_2"), new ItemStack(RegBlocks.po_2_down),new Object[]{
				"YYY",
				"YYY",
				"Z Z",
				'Y', new ItemStack(RegBlocks.betons,1,0),
				'Z', new ItemStack(RegBlocks.beton_block)
		});
		
		GameRegistry.addShapedRecipe(new ResourceLocation("soviet_window"), new ResourceLocation("soviet_window"), new ItemStack(RegBlocks.soviet_window),new Object[]{
				"YZY",
				"TZT",
				"YZY",
				'Y', new ItemStack(Blocks.PLANKS),
				'T', Items.STICK,
				'Z', new ItemStack(Blocks.GLASS_PANE),
		});
		GameRegistry.addShapelessRecipe(new ResourceLocation("soviet_steel"), new ResourceLocation("soviet_steel"), new ItemStack(RegItems.soviet_steel,9), new Ingredient[] {
				Ingredient.fromStacks(new ItemStack(Items.IRON_INGOT,9)),
				Ingredient.fromStacks(new ItemStack(Items.WATER_BUCKET,1))
		});
		GameRegistry.addShapelessRecipe(new ResourceLocation("white_brick"), new ResourceLocation("white_brick"), new ItemStack(RegItems.white_brick), new Ingredient[] {
				Ingredient.fromItem(RegItems.andesite_rock),
				Ingredient.fromItem(RegItems.hammer)
		});
		GameRegistry.addShapelessRecipe(new ResourceLocation("quadtile_glass"), new ResourceLocation("quadtile_glass"), new ItemStack(RegItems.quadtile_glass,4), new Ingredient[] {
				Ingredient.fromStacks(new ItemStack(Blocks.GLASS_PANE, 1)),
				Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 12))
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("small_tiles_blue"), new ResourceLocation("small_tiles_blue"), new ItemStack(RegBlocks.small_tiles_blue),new Object[]{
				"YYY",
				"YDY",
				"YYY",
				'Y', RegItems.quad_tile_small,
				'D', new ItemStack(Items.DYE,1, 12),
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("small_tiles"), new ResourceLocation("small_tiles"), new ItemStack(RegBlocks.small_tiles),new Object[]{
				"YYY",
				"YDY",
				"YYY",
				'Y', RegItems.quad_tile_small,
				'D', new ItemStack(Items.DYE,1, 15),
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("nii_wall_3"), new ResourceLocation("nii_wall_3"), new ItemStack(RegBlocks.nii_blocks,1,0),new Object[]{
				"YY ",
				"YY ",
				"   ",
				'Y', new ItemStack(RegBlocks.travertine_block),
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("white_soviet_bricks"), new ResourceLocation("white_soviet_bricks"), new ItemStack(RegBlocks.white_soviet_bricks),new Object[]{
				"YY ",
				"YY ",
				"   ",
				'Y', RegItems.white_brick,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("soviet_box"), new ResourceLocation("soviet_box"), new ItemStack(RegBlocks.soviet_box),new Object[]{
				"YYY",
				"YZY",
				"YYY",
				
				'Y', new ItemStack(Blocks.PLANKS),
				'Z', new ItemStack(Items.DYE, 1, 14),
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("soviet_box"), new ResourceLocation("soviet_box"), new ItemStack(RegBlocks.kafels,1,2),new Object[]{
				"ZY ",
				"YZ ",
				"   ",
				
				'Y', RegItems.quad_tile,
				'Z', new ItemStack(Items.DYE, 1, 2),
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("soviet_box"), new ResourceLocation("soviet_box"), new ItemStack(RegBlocks.kafels,1,1),new Object[]{
				"ZY ",
				"YZ ",
				"   ",
				
				'Y', RegItems.quad_tile,
				'Z', new ItemStack(Items.DYE, 1, 11),
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("soviet_box"), new ResourceLocation("soviet_box"), new ItemStack(RegBlocks.kafels,1,0),new Object[]{
				"ZY ",
				"YZ ",
				"   ",
				
				'Y', RegItems.quad_tile,
				'Z', new ItemStack(Items.DYE, 1, 7),
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("wallpaper_1"), new ResourceLocation("wallpaper_1"), new ItemStack(RegItems.item_wallpaper_1,16),new Object[]{
				"YYY",
				"XZX",
				"YYY",
				'X', new ItemStack(Items.DYE, 1, 11),
				'Y', Items.PAPER,
				'Z', new ItemStack(Items.DYE, 1, 14),
		});
				

		GameRegistry.addShapedRecipe(new ResourceLocation("wallpaper_2"), new ResourceLocation("wallpaper_2"), new ItemStack(RegItems.item_wallpaper_2,16),new Object[]{
				"YYY",
				"XZX",
				"YYY",
				'X', new ItemStack(Items.DYE, 1, 3),
				'Y', Items.PAPER,
				'Z', new ItemStack(Items.DYE, 1, 14),
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("wallpaper_3"), new ResourceLocation("wallpaper_3"), new ItemStack(RegItems.item_wallpaper_3,16),new Object[]{
				"YYY",
				"XZX",
				"YYY",
				'X', new ItemStack(Items.DYE, 1, 11),
				'Y', Items.PAPER,
				'Z', new ItemStack(Items.DYE, 1, 15),
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("rastyhandhold"), new ResourceLocation("rastyhandhold"), new ItemStack(RegBlocks.rusty_handhold,1),new Object[]{
				"   ",
				"YYY",
				"YYY",
				'Y', RegItems.armature,

		});
		GameRegistry.addShapedRecipe(new ResourceLocation("rastyralling"), new ResourceLocation("rastyralling"), new ItemStack(RegBlocks.rusty_ralling,4),new Object[]{
				"YYY",
				"YYY",
				"YYY",
				'Y', RegItems.armature,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("floor_grid"), new ResourceLocation("floor_grid"), new ItemStack(RegBlocks.floor_grid,1),new Object[]{
				"   ",
				"Y Y",
				"YYY",
				'Y', RegItems.armature,

		});
		GameRegistry.addShapedRecipe(new ResourceLocation("diagonal_grid"), new ResourceLocation("diagonal_grid"), new ItemStack(RegBlocks.full_diagonal_grid_invert,1),new Object[]{
				"Y Y",
				" YB",
				"Y Y",
				'Y', RegItems.armature,
				'B', Items.PAPER,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("full_diagonal_grid"), new ResourceLocation("full_diagonal_grid"), new ItemStack(RegBlocks.full_diagonal_grid,1),new Object[]{
				"Y Y",
				"BY ",
				"Y Y",
				'Y', RegItems.armature,
				'B', Items.PAPER,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("diagonal_grid"), new ResourceLocation("diagonal_grid"), new ItemStack(RegBlocks.diagonal_grid,1),new Object[]{
				"Y  ",
				" Y ",
				"Y Y",
				'Y', RegItems.armature,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("polu_circle_grid"), new ResourceLocation("polu_circle_grid"), new ItemStack(RegBlocks.polu_circle_grid,1),new Object[]{
				"Y  ",
				"YY ",
				"YYY",
				'Y', RegItems.armature,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("glazed_tile_black"), new ResourceLocation("glazed_tile_black"), new ItemStack(RegBlocks.glazed_tile_black,4),new Object[]{
				"YBY",
				"YYY",
				"YYY",
				'Y', RegItems.tile,
				'B', new ItemStack(Items.DYE,1, 0),
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("glazed_tile_blue"), new ResourceLocation("glazed_tile_blue"), new ItemStack(RegBlocks.glazed_tile_blue,4),new Object[]{
				"YBY",
				"YYY",
				"YYY",
				'Y', RegItems.tile,
				'B', new ItemStack(Items.DYE,1, 12),
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("glazed_tile_white"), new ResourceLocation("glazed_tile_white"), new ItemStack(RegBlocks.glazed_tile_white,4),new Object[]{
				"YBY",
				"YYY",
				"YYY",
				'Y', RegItems.tile,
				'B', new ItemStack(Items.DYE,1, 15),
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("brown_tile"), new ResourceLocation("brown_tile"), new ItemStack(RegBlocks.brown_tile,4),new Object[]{
				"YBY",
				"YYY",
				"YYY",
				'Y', RegItems.big_tile,
				'B', new ItemStack(Items.DYE,1, 5),
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("aquamarine_tile"), new ResourceLocation("aquamarine_tile"), new ItemStack(RegBlocks.aquamarine_tile,4),new Object[]{
				"YBY",
				"YYY",
				"YYY",
				'Y', RegItems.big_tile,
				'B', new ItemStack(Items.DYE,1, 6),
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("glazed_tile"), new ResourceLocation("glazed_tile"), new ItemStack(RegBlocks.glazed_tile,4),new Object[]{
				"YBY",
				"YYY",
				"YYY",
				'Y', RegItems.tile,
				'B', new ItemStack(Items.DYE, 1, 3),
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("item_red_banner"), new ResourceLocation("item_red_banner"), new ItemStack(RegItems.item_red_banner,1),new Object[]{
				"YYY",
				"YBY",
				"YYY",
				'Y', Items.PAPER,
				'B', new ItemStack(Items.DYE, 1, 1),
		});
//		GameRegistry.addShapedRecipe(new ResourceLocation("soviet_door"), new ResourceLocation("soviet_door"), new ItemStack(RegItems.soviet_door,1),new Object[]{
//				"YYY",
//				"YYY",
//				"YYY",
//				'Y', RegItems.soviet_steel,
//		});
		GameRegistry.addShapedRecipe(new ResourceLocation("hermo_trapdoor"), new ResourceLocation("hermo_trapdoor"), new ItemStack(RegBlocks.hermo_trapdoor,1),new Object[]{
				"   ",
				"YYY",
				"YYY",
				'Y', RegItems.soviet_steel,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("quad_tile_small"), new ResourceLocation("quad_tile_small"), new ItemStack(RegItems.quad_tile_small,8),new Object[]{
				"   ",
				"   ",
				"Y  ",
				'Y', Items.CLAY_BALL,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("quad_tile"), new ResourceLocation("quad_tile"), new ItemStack(RegItems.quad_tile,8),new Object[]{
				"   ",
				"YY ",
				"YY ",
				'Y', Items.CLAY_BALL,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("nii_glass_1"), new ResourceLocation("nii_glass_1"), new ItemStack(RegBlocks.nii_glass_1,4),new Object[]{
				"   ",
				"YY ",
				"YY ",
				'Y', RegItems.quadtile_glass,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("big_tile"), new ResourceLocation("big_tile"), new ItemStack(RegItems.big_tile,8),new Object[]{
				"   ",
				"YYY",
				"YYY",
				'Y', Items.CLAY_BALL,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("tile"), new ResourceLocation("tile"), new ItemStack(RegItems.tile,8),new Object[]{
				"YY ",
				"YY ",
				"YY ",
				'Y', Items.CLAY_BALL,
		});
//		GameRegistry.addShapedRecipe(new ResourceLocation("soviet_door_wood"), new ResourceLocation("soviet_door_wood"), new ItemStack(RegItems.soviet_door_item_wood,1),new Object[]{
//				"FYY",
//				"GYY",
//				"FYY",
//				'Y', RegItems.soviet_steel,
//				'F', new ItemStack(Items.DYE, 1, 15),
//				'G',  new ItemStack(Items.DYE, 1, 7),
//		});
		GameRegistry.addShapedRecipe(new ResourceLocation("beton_block"), new ResourceLocation("beton_block"), new ItemStack(RegBlocks.beton_block,1),new Object[]{
				"B  ",
				"YY ",
				"YY ",
				'Y', RegBlocks.betons,
				'B', RegItems.armature,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("raw_beton"), new ResourceLocation("raw_beton"), new ItemStack(RegBlocks.raw_beton,8),new Object[]{
				"FRF",
				"RYR",
				"TTT",
				'Y', Blocks.GRAVEL,
				'F', Blocks.SAND,
				'R', RegItems.armature,
				'T', Blocks.COBBLESTONE
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("soviet_ladder"), new ResourceLocation("soviet_ladder"), new ItemStack(RegBlocks.soviet_ladder,1),new Object[]{
				"Y Y",
				"YYY",
				"Y Y",
				'Y', RegItems.armature,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("pipeangle"), new ResourceLocation("pipeangle"), new ItemStack(RegBlocks.pipeangle,6),new Object[]{
				"Y Y",
				"  Y",
				"YYY",
				'Y', RegItems.soviet_steel,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("iron_beam_thin_vertical"), new ResourceLocation("iron_beam_thin_vertical"), new ItemStack(RegBlocks.iron_beam_thin_vertical,3),new Object[]{
				"YYY",
				" Y ",
				"YYY",
				'Y', RegItems.soviet_steel,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("iron_beam_thin"), new ResourceLocation("iron_beam_thin"), new ItemStack(RegBlocks.iron_beam_thin,3),new Object[]{
				"Y Y",
				"YYY",
				"Y Y",
				'Y', RegItems.soviet_steel,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("iron_beam"), new ResourceLocation("iron_beam"), new ItemStack(RegBlocks.iron_beam,1),new Object[]{
				"BYB",
				"BYB",
				"BYB",
				'Y', RegBlocks.iron_beam_thin,
				'B', RegItems.soviet_steel,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("iron_beam_vertical"), new ResourceLocation("iron_beam_vertical"), new ItemStack(RegBlocks.iron_beam_vertical,1),new Object[]{
				"BYB",
				"BYB",
				"BYB",
				'Y', RegBlocks.iron_beam_thin_vertical,
				'B', RegItems.soviet_steel,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("beton_stairs"), new ResourceLocation("beton_stairs"), new ItemStack(RegBlocks.beton_stairs,1),new Object[]{
				"Y  ",
				"YY ",
				"YYY",
				'Y', RegBlocks.betons,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("lamp"), new ResourceLocation("lamp"), new ItemStack(RegBlocks.sovietlamp,1),new Object[]{
				"NNN",
				"YBY",
				"YYY",
				'Y', Blocks.GLASS_PANE,
				'B', Blocks.REDSTONE_LAMP,
				'N', Blocks.STONE_SLAB,
		});
/*		GameRegistry.addShapedRecipe(new ResourceLocation("green_beton"), new ResourceLocation("green_beton"), new ItemStack(RegBlocks.green_beton,1),new Object[]{
				"YYY",
				"YBY",
				"YYY",
				'Y', RegBlocks.betons,
				'B',  new ItemStack(Items.DYE, 1, 2),
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("beton_whited"), new ResourceLocation("beton_whited"), new ItemStack(RegBlocks.beton_whited,1),new Object[]{
				"YYY",
				"YBY",
				"YYY",
				'Y', RegBlocks.betons,
				'B',  new ItemStack(Items.DYE, 1, 15),
		});*/
		GameRegistry.addShapedRecipe(new ResourceLocation("soviet_bricks"), new ResourceLocation("soviet_bricks"), new ItemStack(RegBlocks.soviet_bricks,1),new Object[]{
				"YYY",
				"YBY",
				"YYY",
				'Y', Items.BRICK,
				'B', RegItems.armature,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("soviet_table"), new ResourceLocation("soviet_table"), new ItemStack(RegBlocks.soviet_table,1),new Object[]{
				"BBB",
				"Y Y",
				"Y Y",
				'B', Blocks.QUARTZ_BLOCK,
				'Y', RegItems.armature,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("soviet_chair"), new ResourceLocation("soviet_chair"), new ItemStack(RegBlocks.soviet_chair,1),new Object[]{
				"  B",
				"YBY",
				"Y Y",
				'B', Blocks.QUARTZ_BLOCK,
				'Y', RegItems.armature,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("tableside"), new ResourceLocation("tableside"), new ItemStack(RegBlocks.tableside,1),new Object[]{
				"BBB",
				"Y Y",
				"YYY",
				'B', Blocks.QUARTZ_BLOCK,
				'Y', RegItems.armature,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("tableside"), new ResourceLocation("tableside"), new ItemStack(RegBlocks.tableside,1),new Object[]{
				"YYY",
				"YBY",
				"YYY",
				'B', Blocks.GLASS_PANE,
				'Y', Blocks.PLANKS,
		});
		GameRegistry.addShapelessRecipe(new ResourceLocation("iron_beam_withbeton"), new ResourceLocation("iron_beam_withbeton"), new ItemStack(RegBlocks.iron_beam_withbeton), new Ingredient[] {
				Ingredient.fromItem(Item.getItemFromBlock(RegBlocks.betons)),
				Ingredient.fromItem(Item.getItemFromBlock(RegBlocks.iron_beam))
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("tilled_block"), new ResourceLocation("tilled_block"), new ItemStack(RegBlocks.tilled_block,4),new Object[]{
				"YYY",
				"YBY",
				"YYY",
				'B', new ItemStack(Items.DYE, 1, 8),
				'Y', RegItems.quad_tile,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("white_tilled_block"), new ResourceLocation("white_tilled_block"), new ItemStack(RegBlocks.white_tilled_block,4),new Object[]{
				"YYY",
				"YBY",
				"YYY",
				'B', new ItemStack(Items.DYE, 1, 15),
				'Y', RegItems.quad_tile,
		});
		GameRegistry.addShapedRecipe(new ResourceLocation("blue_tilled_block"), new ResourceLocation("blue_tilled_block"), new ItemStack(RegBlocks.blue_tilled_block,4),new Object[]{
				"YYY",
				"YBY",
				"YYY",
				'B', new ItemStack(Items.DYE, 1, 12),
				'Y', RegItems.quad_tile,
		});
		
		GameRegistry.addShapedRecipe(new ResourceLocation("glasstube"), new ResourceLocation("glasstube"), new ItemStack(RegBlocks.glass_tube),new Object[]{
				"XYX",
				"X X",
				" X ",
				'Y', new ItemStack(Blocks.PLANKS,1),
				'X', new ItemStack(Blocks.GLASS_PANE)
		});
		
		GameRegistry.addShapedRecipe(new ResourceLocation("electro_stove"), new ResourceLocation("electro_stove"), new ItemStack(RegBlocks.electro_stove),new Object[]{
				"XYZ",
				"AZB",
				"CDD",
				
				'X', new ItemStack(Items.DYE, 1, 0),
				'Y', new ItemStack(Items.DYE, 1, 11),
				'Z', Items.IRON_INGOT,
				'B', RegItems.soviet_steel,
				'A', Items.REDSTONE,
				'C', Items.GLOWSTONE_DUST,
				'D',new ItemStack(Blocks.STONE_BUTTON),
		});
	}
}
