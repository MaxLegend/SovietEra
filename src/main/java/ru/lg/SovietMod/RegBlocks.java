package ru.lg.SovietMod;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import ru.lg.SovietMod.Blocks.*;
import ru.lg.SovietMod.Blocks.Basic.BBSWCMSit;
import ru.lg.SovietMod.Blocks.Basic.BasicBlock;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockNoMIP;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSide;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideCustomModelWithGlass;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithInfo;
import ru.lg.SovietMod.Blocks.Basic.BasicItemBlock;
import ru.lg.SovietMod.Blocks.Bedside.BlockBedside;
import ru.lg.SovietMod.Blocks.DryCab.DryCab;
import ru.lg.SovietMod.Blocks.ItemBlocks.ItemBlockBeton;
import ru.lg.SovietMod.Blocks.ItemBlocks.ItemBlockKafel;
import ru.lg.SovietMod.Blocks.ItemBlocks.ItemBlockNIIBlocks;
import ru.lg.SovietMod.Blocks.LabTable.LabTable;
import ru.lg.SovietMod.Blocks.LabTable.LabTableLeft;
import ru.lg.SovietMod.Blocks.LabTable.LabTableRight;
import ru.lg.SovietMod.Blocks.Safe.BlockSafe;
import ru.lg.SovietMod.Blocks.SovietBox.SovietBox;
import ru.lg.SovietMod.Blocks.SovietTumb.SovietTumb;
import ru.lg.SovietMod.Blocks.Stillage.StillageBlock;
import ru.lg.SovietMod.Blocks.TableSide.BlockTableside;
import ru.lg.SovietMod.Blocks.WoodLabTable.WLabTable;
import ru.lg.SovietMod.Blocks.WoodLabTable.WLabTableBreak;

public class RegBlocks {



	//	public static Block bigdoor = new BigHermodoor(Material.ROCK, "bighermodoor", 3F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabMain);
	//	public static Block hermodoor = new Hermodoor(Material.WOOD, "hermodoor", 3F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabMain);


	//public static Block swamp_water = new SwampWaterBlock(RegFluids.swamp_water, "swamp_water");
	
	public static Block inc_lamp_false = new IncLamp(Material.GLASS, "inc_lamp_false", 0.5F, 1, SoundType.GLASS, false).setCreativeTab(SovietCore.tabInsDeco);
	public static Block inc_lamp_true = new IncLamp(Material.GLASS, "inc_lamp_true", 0.5F, 1, SoundType.GLASS, true);

	//false - down, true - up
	public static Block po_2_down = new PO_2(Material.ROCK, "po2_down", 6F, 1, SoundType.STONE, false).setCreativeTab(SovietCore.tabOutDeco);
	public static Block po_2_up = new PO_2(Material.ROCK, "po2_up", 6F, 1, SoundType.STONE, true);
	public static Block sovietlamp = new SovietLamp(Material.WOOD, "sovietlamp", 1F, 4F, SoundType.WOOD, false).setCreativeTab(SovietCore.tabInsDeco);
	public static Block sovietlamptrue = new SovietLamp(Material.WOOD, "sovietlamptrue", 1F, 4F, SoundType.WOOD, true);
	public static Block closed_sovietlamp = new ClosedSovietLamp(Material.WOOD, "closed_sovietlamp", 1F, 4F, SoundType.WOOD, false).setCreativeTab(SovietCore.tabInsDeco);
	public static Block closed_sovietlamptrue = new ClosedSovietLamp(Material.WOOD, "closed_sovietlamptrue", 1F, 4F, SoundType.WOOD, true);

	public static Block sovietlamp_cracked = new SovietLampCracked(Material.WOOD, "sovietlamp_cracked", 1F, 4F, SoundType.WOOD).setCreativeTab(SovietCore.tabInsDeco);

	public static Block soviet_table = new SovietTable(Material.WOOD, "soviettable", 2F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block rusty_ralling = new RastyRailing(Material.IRON, "rusty_ralling", 3F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);
	public static Block soviet_selector = new SovietRelay(Material.IRON, "sovietselector", 1F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);
	public static Block vibro_wire_lever = new VibroWireLever(Material.IRON, "vibro_wire_lever", 1F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);

	public static Block glass_tube = new GlassTube(Material.GLASS, "glass_tube", 0.5F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block wires = new WiresBlock(Material.CACTUS, "wires", 1F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	
	public static Block rusty_handhold = new RastyHandhold(Material.IRON, "rusty_handhold", 2F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	public static Block rusty_handhold_angle = new RastyHandholdAngle(Material.IRON, "rusty_handhold_angle", 2F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	public static Block gofro_handhold = new GofroHandhold(Material.IRON, "gofro_handhold", 2F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	public static Block beton_block = new Beton_Block(Material.ROCK, "beton_block", 7F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	public static Block battery = new BlockBattery(Material.IRON, "battery", 5F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	public static Block thintube = new ThinTubeBattery(Material.IRON, "thintube", 4F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabOutDeco);
	public static Block beton_with_ralling = new BlockBetonRalling(Material.ROCK, "beton_with_ralling", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabMain);

	public static Block green_beton_with_ralling = new BlockBetonRalling(Material.ROCK, "green_beton_with_ralling", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabMain);


	public static Block full_diagonal_grid = new ThinTubeBattery(Material.IRON, "full_diagonal_grid", 3F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	public static Block full_diagonal_grid_invert = new ThinTubeBattery(Material.IRON, "full_diagonal_grid_invert", 3F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	public static Block diagonal_grid = new ThinTubeBattery(Material.IRON, "diagonal_grid", 3F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	public static Block polu_circle_grid = new ThinTubeBattery(Material.IRON, "polu_circle_grid", 3F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);

	public static Block vent_pipe = new VentPipe("vent_pipe", 1F).setCreativeTab(SovietCore.tabOutDeco);
	public static Block barb_wire = new BarbWire("barb_wire", 2F).setCreativeTab(SovietCore.tabOutDeco);


	public static Block fantom_block = new FantomBlockForPO_2(Material.ROCK, "fantom_block", 6F, 1, SoundType.STONE);
	public static Block fantom_block2 = new FantomBlock(Material.ROCK, "fantom_block2", 6F, 1, SoundType.STONE);

	//	public static Block fantom_block4 = new FantomSideBlock2(Material.IRON, "fantom_block4", 6F, 1, SoundType.METAL);
	//	public static Block fantom_block5 = new FantomSideBlock3(Material.IRON, "fantom_block5", 6F, 1, SoundType.METAL);
	public static Block fantom_slabd = new FantomSlabD(Material.IRON, "fantom_slabd", 3F, 1, SoundType.METAL);

	public static Block soviet_window = new SovietWindow(Material.WOOD, "soviet_window", 3F, 0, SoundType.WOOD).setCreativeTab(SovietCore.tabOutDeco);
	public static Block soviet_window_leaf = new SovietWindowLeaf(Material.WOOD,"soviet_window_leaf", 3F, 0, SoundType.WOOD).setCreativeTab(SovietCore.tabOutDeco);

	public static Block modern_window = new ModernWindow(Material.WOOD, "modern_window", 3F, 0, SoundType.WOOD).setCreativeTab(SovietCore.tabOutDeco);
	public static Block modern_window_leaf = new ModernWindowLeaf(Material.WOOD,"modern_window_leaf", 3F, 0, SoundType.WOOD).setCreativeTab(SovietCore.tabOutDeco);

	public static Block factory_window = new FactoryWindow(Material.WOOD, "factory_window", 3F, 0, SoundType.WOOD).setCreativeTab(SovietCore.tabOutDeco);

	//public static Block wallpaper_2 = new Wallpaper(Material.ROCK, "wallpaper_2", 4F, 1, SoundType.CLOTH).setCreativeTab(SovietCore.tabMain);
	//public static Block wallpaper_3 = new Wallpaper(Material.ROCK, "wallpaper_3", 4F, 1, SoundType.CLOTH).setCreativeTab(SovietCore.tabMain);

	public static Block turnstile_off = new TurnStileOff(Material.ROCK, "turnstile_off", 2F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block turnstile_on = new TurnStileOn(Material.ROCK, "turnstile_on", 2F, 1, SoundType.STONE);

	public static Block hermo_door = new Hermodoor(Material.IRON, "hermodoor", 55F, 1, SoundType.METAL);
	public static Block ralling_door = new RallingDoor(Material.IRON, "ralling_door", 3F, 1, SoundType.METAL);
	public static Block wood_door_into = new SovietDoorWoodInto(Material.WOOD, "wood_door_into", 2.5F, 1, SoundType.WOOD);
	public static Block airlock_door = new AirlockDoor(Material.IRON, "airlock_door", 4F, 1, SoundType.METAL);
	public static Block wood_door = new SovietDoorWood(Material.WOOD, "wood_door", 3F, 1, SoundType.WOOD);
	public static Block alm_door = new AluminiumDoor(Material.WOOD, "alm_door", 3F, 1, SoundType.WOOD);
	public static Block rusty_iron_door = new RustyIronDoor(Material.WOOD, "rusty_iron_door", 3F, 1, SoundType.WOOD);

	public static Block hermo_trapdoor = new HermoTrapdoor(Material.IRON,"hermo_trapdoor", 55F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	//	public static Block hermo_trapdoor = new HermoTrapDoor(Material.ANVIL,"hermo_trapdoor").setCreativeTab(SovietCore.tabMain);

	public static Block soviet_ladder = new SovietLadder("soviet_ladder").setCreativeTab(SovietCore.tabOutDeco);
	public static Block soviet_ladder2 = new SovietLadder("soviet_ladder2").setCreativeTab(SovietCore.tabOutDeco);

	public static Block white_tilled_block = new BasicBlock(Material.ROCK, "white_tilled_block", 2F, 1, SoundType.STONE);

	public static Block soviet_window_angle = new BasicBlockSideCustomModelWithGlass(Material.ROCK, "soviet_window_angle", 2F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabOutDeco);

	public static Block lab_tile = new BasicBlock(Material.ROCK, "lab_tile", 2F, 1, SoundType.STONE);
	public static Block lab_tile2 = new BasicBlock(Material.ROCK, "lab_tile2", 2F, 1, SoundType.STONE);
	public static Block gofro_gold = new BasicBlock(Material.IRON, "gofro_gold", 2F, 1, SoundType.METAL);

	public static Block tilled_block = new BasicBlockSideWithInfo(Material.ROCK, "tilled_block", 2F, 1, SoundType.STONE);
	public static Block tilled_block_cracked = new BasicBlockSideWithInfo(Material.ROCK, "tilled_block_cracked", 2F, 1, SoundType.STONE);
	public static Block blue_tilled_block = new BasicBlockSideWithInfo(Material.ROCK, "blue_tilled_block", 2F, 1, SoundType.STONE);
	public static Block blue_tilled_block_cracked = new BasicBlockSideWithInfo(Material.ROCK, "blue_tilled_block_cracked", 2F, 1, SoundType.STONE);
	public static Block moss_tilled_block = new BasicBlockSideWithInfo(Material.ROCK, "moss_tilled_block", 2F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabOutDeco);
	public static Block blue_tilled_block_moss = new BasicBlockSideWithInfo(Material.ROCK, "blue_tilled_block_moss", 2F, 1, SoundType.STONE);

	public static Block intro_doors = new IntroDoors(Material.IRON, "introdoors", 5F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);

	public static Block aquamarine_tile = new BasicBlock(Material.ROCK, "aquamarine_tile", 5F, 1, SoundType.STONE);
	public static Block aquamarine_tile_cracked = new BasicBlock(Material.ROCK, "aquamarine_tile_cracked", 5F, 1, SoundType.STONE);

	public static Block brown_tile = new BasicBlock(Material.ROCK, "brown_tile", 5F, 1, SoundType.STONE);
	public static Block brown_tile_crack = new BasicBlock(Material.ROCK, "brown_tile_crack", 5F, 1, SoundType.STONE);

	public static Block autoclave = new Autoclave(Material.IRON, "autoclave", 5F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);
	public static Block soviet_bed = new SovietBed(Material.IRON, "soviet_bed", 5F, 1, SoundType.METAL);


	public static Block asphalt = new BasicBlockSide(Material.ROCK, "asphalt", 5F, 1, SoundType.STONE);
	public static Block soviet_bricks = new BasicBlock(Material.ROCK, "soviet_bricks", 5F, 1, SoundType.STONE);
	public static Block white_soviet_bricks = new BasicBlock(Material.ROCK, "white_soviet_bricks", 5F, 1, SoundType.STONE);
	public static Block soviet_bricks_with_white = new BasicBlock(Material.ROCK, "soviet_bricks_with_white", 5F, 1, SoundType.STONE);
	public static Block green_bricks = new BasicBlock(Material.ROCK, "green_bricks", 5F, 1, SoundType.STONE);
	


	public static Block panel_block = new BasicBlock(Material.ROCK, "panel_block", 5F, 1, SoundType.STONE);
	public static Block panel_block_rot = new PanelBlockRotate(Material.ROCK, "panel_block_rot", 5F, 1, SoundType.STONE);
	public static Block panel_block_ang = new PanelBlockRotate(Material.ROCK, "panel_block_ang", 5F, 1, SoundType.STONE);

	public static Block beton_panel = new BasicBlock(Material.ROCK, "beton_panel", 5F, 1, SoundType.STONE);
	public static Block beton_panel_rot = new PanelBlockRotate(Material.ROCK, "beton_panel_rot", 5F, 1, SoundType.STONE);
	public static Block beton_panel_ang = new PanelBlockRotate(Material.ROCK, "beton_panel_ang", 5F, 1, SoundType.STONE);
	
	public static Block ye_beton_panel = new BasicBlock(Material.ROCK, "ye_beton_panel", 5F, 1, SoundType.STONE);
	public static Block ye_beton_panel_rot = new PanelBlockRotate(Material.ROCK, "ye_beton_panel_rot", 5F, 1, SoundType.STONE);
	public static Block ye_beton_panel_ang = new PanelBlockRotate(Material.ROCK, "ye_beton_panel_ang", 5F, 1, SoundType.STONE);

	//Meta blocks ----------------------------------------------------------------------------------------------------------
	public static Block betons = new BlockBeton("betons", 6F, 1, SoundType.STONE);
	public static Block kafels = new BlockKafel("kafels", 6F, 1, SoundType.STONE);
	public static Block nii_blocks = new NIIBlocks("nii_blocks", 4F, 1, SoundType.STONE);



	public static Block nii_wall_1 = new BasicBlock(Material.ROCK, "nii_wall_1", 6F, 1, SoundType.STONE);
	public static Block travertine_block = new BasicBlock(Material.ROCK, "travertine_block", 6F, 1, SoundType.STONE);

	//	public static Block green_beton = new BasicBlock(Material.ROCK, "green_beton", 4F, 1, SoundType.STONE);
	public static Block raw_beton = new BasicBlock(Material.SAND, "raw_beton", 5F, 1, SoundType.SAND);

	//	public static Block cracked_beton = new BasicBlock(Material.ROCK, "cracked_beton", 6F, 1, SoundType.STONE);
	//	public static Block cracked_green_beton = new BasicBlock(Material.ROCK, "cracked_green_beton", 6F, 1, SoundType.STONE);
	public static Block beton_stairs = new SovietStairs("beton_stairs", RegBlocks.betons.getDefaultState(), 6F);



	
	public static Block glazed_tile = new BasicBlockSideWithInfo(Material.ROCK, "glazed_tile", 3F, 1, SoundType.STONE);
	public static Block glazed_tile_white = new BasicBlockSideWithInfo(Material.ROCK, "glazed_tile_white", 3F, 1, SoundType.STONE);
	public static Block glazed_tile_blue = new BasicBlockSideWithInfo(Material.ROCK, "glazed_tile_blue", 3F, 1, SoundType.STONE);
	public static Block glazed_tile_cracked = new BasicBlockSideWithInfo(Material.ROCK, "glazed_tile_cracked", 3F, 1, SoundType.STONE);
	public static Block glazed_tile_white_cracked = new BasicBlockSideWithInfo(Material.ROCK, "glazed_tile_white_cracked", 3F, 1, SoundType.STONE);
	public static Block glazed_tile_blue_cracked = new BasicBlockSideWithInfo(Material.ROCK, "glazed_tile_blue_cracked", 3F, 1, SoundType.STONE);
	public static Block glazed_tile_black = new BasicBlockSideWithInfo(Material.ROCK, "glazed_tile_black", 3F, 1, SoundType.STONE);
	public static Block glazed_tile_black_cracked = new BasicBlockSideWithInfo(Material.ROCK, "glazed_tile_black_cracked", 3F, 1, SoundType.STONE);

	//public static Block testgen = new TestGen(Material.ROCK, "testgen", 5F, 1, SoundType.STONE);

	public static Block block_moss = new BlockMoss(Material.GRASS, "block_moss", 3F, 1, SoundType.PLANT, SovietCore.tabMain);
	//container
	public static Block bedside = new BlockBedside("bedside").setCreativeTab(SovietCore.tabInsDeco);
	public static Block tableside = new BlockTableside("tableside").setCreativeTab(SovietCore.tabInsDeco);
	public static Block soviet_box = new SovietBox("soviet_box").setCreativeTab(SovietCore.tabInsDeco);

	public static Block iron_beam = new BasicBlockSideWithCustomModel(Material.IRON, "iron_beam", 4F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabMain);

	public static Block soviet_chair = new SovietChair(Material.IRON, "soviet_chair", 4F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);
	public static Block iron_beam_withbeton = new BasicBlockSideWithCustomModel(Material.IRON, "iron_beam_withbeton", 4F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabMain);
	public static Block iron_beam_vertical = new BasicBlockSideWithCustomModel(Material.IRON, "iron_beam_vertical", 4F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabMain);

	public static Block iron_beam_thin = new BasicBlockSideWithCustomModel(Material.IRON, "iron_beam_thin", 4F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabMain);
	public static Block iron_beam_thin_vertical = new BasicBlockSideWithCustomModel(Material.IRON, "iron_beam_thin_vertical", 4F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabMain);

	//	public static Block statue_lenin = new BasicBlockSideWithCustomModel(Material.IRON, "statue_lenin", 2F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabMain);

	public static Block lab_table_left = new LabTableLeft("lab_table_left").setCreativeTab(SovietCore.tabInsDeco);
	public static Block lab_table_right = new LabTableRight("lab_table_right").setCreativeTab(SovietCore.tabInsDeco);
	public static Block lab_table_center = new LabTable("lab_table_center").setCreativeTab(SovietCore.tabInsDeco);

	public static Block electro_board = new BlockElectroBoard(Material.IRON, "electro_board", 4F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);


	public static Block lab_glass_case = new LabGlassCase(Material.GLASS, "lab_glass_case", 2F, 1, SoundType.GLASS).setCreativeTab(SovietCore.tabInsDeco);

	public static Block dry_cab = new DryCab("dry_cab").setCreativeTab(SovietCore.tabInsDeco);
	public static Block comp = new ElectronikaMonitor(Material.IRON, "comp", 2F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);
	public static Block toilet = new BlockToilet(Material.ROCK, "toilet", 2F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);
	public static Block sink = new BlockSink(Material.ROCK, "sink", 2F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);
	public static Block sysblock = new SystemBlock(Material.IRON, "sysblock", 2F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);
	//	public static Block red_wire = new RedWire("red_wire",false).setCreativeTab(SovietCore.tabMain);;
	//	public static Block red_wire_on = new RedWire("red_wire_on",true);

	public static Block pipe_autoclave = new PipeAutoclave(Material.IRON, "pipe_autoclave", 2F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);
	public static Block mixer = new Mixer(Material.GLASS, "mixer", 1F, 1, SoundType.GLASS).setCreativeTab(SovietCore.tabInsDeco);
	public static Block magnetmixer = new MagnetMixer(Material.IRON, "magnetmixer", 2F, 1, SoundType.GLASS).setCreativeTab(SovietCore.tabInsDeco);
	public static Block alkofire = new DistillApp(Material.GLASS, "alkofire", 1F, 1, SoundType.GLASS).setCreativeTab(SovietCore.tabInsDeco);

	public static Block biolab_tile = new BiolabTable(Material.ROCK, "biolab_tile", 0.5F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);
	public static Block biolab_tile_up = new BiolabTableUp(Material.ROCK, "biolab_tile_up", 0.5F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);

	public static Block pipes = new BlockPipes(Material.IRON, "pipes", 3F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);;
	public static Block pipeangle = new BlockPipes(Material.IRON, "pipeangle", 3F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);;

	public static Block rubbish = new BlockRubbish(Material.ROCK, "rubbish", 0.5F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);
	public static Block floor_grid = new FloorGrid(Material.IRON, "floor_grid", 0.5F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);

	public static Block red_lamp = new RedLamp(Material.GLASS, "red_lamp", 0.5F, 1, SoundType.GLASS, false).setCreativeTab(SovietCore.tabInsDeco);
	public static Block red_lamp_on = new RedLamp(Material.GLASS, "red_lamp_on", 0.5F, 1, SoundType.GLASS, true);

	//TODO сделать что то
	public static Block mega_lamp = new MegaLamp(Material.IRON, "mega_lamp", 4F, 1, SoundType.METAL,false);
	public static Block mega_lamp_true = new MegaLamp(Material.IRON, "mega_lamp_true", 4F, 1, SoundType.METAL,true);

	public static Block lift_down = new BlockLift(Material.WOOD, "lift_down", 0.5F, 1, SoundType.WOOD, false).setCreativeTab(SovietCore.tabInsDeco);
	public static Block lift_up = new BlockLift(Material.WOOD, "lift_up", 0.5F, 1, SoundType.WOOD, true);


	public static Block steve_helm_s = new SteveHelm(Material.IRON, "steve_helm_s", 4F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);
	public static Block steve_helm = new SteveHelm(Material.IRON, "steve_helm", 4F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);
	public static Block distill_app = new DistillApp(Material.IRON, "distill_app", 4F, 1, SoundType.GLASS).setCreativeTab(SovietCore.tabInsDeco);
	public static Block quartz_tigel = new QuarzTigel(Material.IRON, "quartz_tigel", 4F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);
	public static Block keyboard = new BlockKeyboard(Material.IRON, "keyboard", 4F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);
	public static Block electro_stove = new ElectroStove(Material.IRON, "electro_stove", 4F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);

	public static Block rasty_rall = new RastyRall(Material.IRON, "rasty_rall", 5F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);

	public static Block wood_labshelf_down = new WLabTable("wood_labshelf_down").setCreativeTab(SovietCore.tabInsDeco);
	public static Block wood_labshelf_down_break = new WLabTableBreak("wood_labshelf_down_break").setCreativeTab(SovietCore.tabInsDeco);
	public static Block wood_labshelf_upper = new BasicBlockSideWithCustomModel(Material.WOOD, "wood_labshelf_upper", 4F, 1, SoundType.WOOD).setCreativeTab(SovietCore.tabInsDeco);
	public static Block wood_labshelf_upper_break = new BasicBlockSideWithCustomModel(Material.WOOD, "wood_labshelf_upper_break", 4F, 1, SoundType.WOOD).setCreativeTab(SovietCore.tabInsDeco);

//	public static Block BAR = new BlockAnalogRedstone(Material.IRON, "bar", 5F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabMain);

	public static Block vent_pipe_base = new BasicBlockSideWithCustomModel(Material.IRON, "vent_pipe_base", 4F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);


	//public static Block colba = new BasicBlock(Material.ROCK, "colba", 5F, 1, SoundType.STONE);
	public static Block soviet_column = new SovietColumn(Material.IRON, "soviet_column", 5F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);

	//public static Block sov_sign = new SovBlockSign("sov_sign").setCreativeTab(SovietCore.tabMain);

	public static Block chem_stuff_1 = new ChemStuff(Material.GLASS, "chem_stuff_1", 0.5F, 1, SoundType.GLASS).setCreativeTab(SovietCore.tabInsDeco);
	public static Block chem_stuff_2 = new ChemStuff(Material.GLASS, "chem_stuff_2", 0.5F, 1, SoundType.GLASS).setCreativeTab(SovietCore.tabInsDeco);

	public static Block small_tiles_red = new BasicBlock(Material.ROCK, "small_tiles_red", 3F, 1, SoundType.STONE);
	public static Block small_tiles_red_cracked = new BasicBlock(Material.ROCK, "small_tiles_red_cracked", 3F, 1, SoundType.STONE);
	public static Block small_tiles_yellow = new BasicBlock(Material.ROCK, "small_tiles_yellow", 3F, 1, SoundType.STONE);
	public static Block small_tiles_yellow_cracked = new BasicBlock(Material.ROCK, "small_tiles_yellow_cracked", 3F, 1, SoundType.STONE);
	
	public static Block small_tiles = new BasicBlock(Material.ROCK, "small_tiles", 3F, 1, SoundType.STONE);
	public static Block small_tiles_blue = new BasicBlock(Material.ROCK, "small_tiles_blue", 3F, 1, SoundType.STONE);
	public static Block small_tiles_cracked = new BasicBlock(Material.ROCK, "small_tiles_cracked", 3F, 1, SoundType.STONE);
	public static Block small_tiles_blue_cracked = new BasicBlock(Material.ROCK, "small_tiles_blue_cracked", 3F, 1, SoundType.STONE);

	public static Block lino1 = new BasicBlock(Material.CACTUS, "lino1", 2F, 1, SoundType.CLOTH);
	public static Block lino2 = new BasicBlock(Material.CACTUS, "lino2", 2F, 1, SoundType.CLOTH);
	public static Block lino3 = new BasicBlock(Material.CACTUS, "lino3", 2F, 1, SoundType.CLOTH);
	
	public static Block light_bricks = new BasicBlock(Material.ROCK, "light_bricks", 2F, 1, SoundType.STONE);
	public static Block light_bricks_crack = new BasicBlock(Material.ROCK, "light_bricks_crack", 2F, 1, SoundType.STONE);


	public static Block nii_glass_1 = new BasicTranslucentBlock(Material.GLASS, "nii_glass_1", 2F, 1, SoundType.GLASS);
	public static Block nii_glass_2 = new BasicTranslucentBlock(Material.GLASS, "nii_glass_2", 2F, 1, SoundType.GLASS);
	
	public static Block windproof_beton = new WindProofBeton(Material.ROCK, "windproof_beton", 2F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabOutDeco);

	public static Block street_light_false = new StreetLight(Material.IRON, "street_light_false", 6F, 1, SoundType.METAL, false).setCreativeTab(SovietCore.tabOutDeco);
	public static Block street_light_true = new StreetLight(Material.IRON, "street_light_true", 6F, 1, SoundType.METAL, true);

	public static Block sl_top_1_on = new StreetLightLampBlock1(Material.IRON, "street_light_top_1_on", 6F, 1, SoundType.METAL, true);
	public static Block sl_top_1_off = new StreetLightLampBlock1(Material.IRON, "street_light_top_1", 6F, 1, SoundType.METAL, false).setCreativeTab(SovietCore.tabOutDeco);
	public static Block sl_top_2_on = new StreetLightLampBlock2(Material.IRON, "street_light_top_2_on", 6F, 1, SoundType.METAL, true);
	public static Block sl_top_2_off = new StreetLightLampBlock2(Material.IRON, "street_light_top_2", 6F, 1, SoundType.METAL, false).setCreativeTab(SovietCore.tabOutDeco);


	public static Block street_light_down_1 = new StreetLightBlock(Material.IRON, "street_light_down_1", 6F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	public static Block street_light_down_2 = new StreetLightBlock(Material.IRON, "street_light_down_2", 6F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	public static Block street_light_middle = new StreetLightBlock(Material.IRON, "street_light_middle", 6F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	public static Block base_po2 = new BasicBlockSideWithCustomModel(Material.IRON, "base_po2", 6F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	public static Block soviet_chair_wood = new SovietChair(Material.WOOD, "soviet_chair_wood", 6F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);

	public static Block soviet_tumb = new SovietTumb("soviet_tumb").setCreativeTab(SovietCore.tabInsDeco);

	public static Block street_fence = new GofroHandhold(Material.WOOD, "street_fence", 6F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	public static Block street_fence_angle = new GofroHandholdAngle(Material.IRON, "street_fence_angle", 2F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	public static Block gofro_handhold_angle = new GofroHandholdAngle(Material.IRON, "gofro_handhold_angle", 2F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);

	public static Block vibro_wire = new VibroWire("vibro_wire", 4F).setCreativeTab(SovietCore.tabOutDeco);
	public static Block vibro_wire_b = new VibroWireB("vibro_wire_b", 4F).setCreativeTab(SovietCore.tabOutDeco);
	
	public static Block contact_wire = new ContactWire("contact_wire", 4F).setCreativeTab(SovietCore.tabOutDeco);
	public static Block contact_wire_base = new ContactWireBase("contact_wire_base", 4F).setCreativeTab(SovietCore.tabOutDeco);
	public static Block contact_wire_angle = new ContactWireAngle(Material.IRON, "contact_wire_angle", 4F, 0, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);

	public static Block beton_wall = new SlabVertBlock(Material.ROCK, "beton_wall", 4F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);

	public static Block bordur = new BordurBlock(Material.ROCK, "bordur", 2F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabOutDeco);
	public static Block road_asphalt = new RoadAsphalt(Material.ROCK, "road_asphalt", 2F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabOutDeco);

	public static Block motion_sensor = new MotionSensor(Material.ROCK, "motion_sensor", 2F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	
	public static Block ug_rail = new UGRail(Material.IRON, "ug_rail", 2F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	public static Block ug_rail_rot = new UGRail(Material.IRON, "ug_rail_rot", 2F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	public static Block ug_rail_rot2 = new UGRail(Material.IRON, "ug_rail_rot2", 2F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	
	public static Block ug_rail_rot3 = new UGRail(Material.IRON, "ug_rail_rot3", 2F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	public static Block ug_rail_rot4 = new UGRail(Material.IRON, "ug_rail_rot4", 2F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	
	public static Block ug_rail_diag = new UGRail(Material.IRON, "ug_rail_diag", 2F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabOutDeco);
	
	
	public static Block soviet_bricks_crack = new BasicBlock(Material.ROCK, "soviet_bricks_crack", 5F, 1, SoundType.STONE);
	public static Block soviet_bricks_with_white_crack = new BasicBlock(Material.ROCK, "soviet_bricks_with_white_crack", 5F, 1, SoundType.STONE);
	
	public static Block very_small_tile = new BasicBlock(Material.ROCK, "very_small_tile", 2F, 1, SoundType.STONE);
	public static Block small_bricks = new BasicBlockNoMIP(Material.ROCK, "small_bricks", 2F, 1, SoundType.STONE);
	public static Block white_soviet_bricks_crack = new BasicBlock(Material.ROCK, "white_soviet_bricks_crack", 5F, 1, SoundType.STONE);
	public static Block red_bricks = new BasicBlock(Material.ROCK, "red_bricks", 5F, 1, SoundType.STONE);
	
	public static Block yellow_bricks_1 = new BasicBlock(Material.ROCK, "ye_bricks_1", 5F, 1, SoundType.STONE);
	public static Block yellow_bricks_2 = new BasicBlock(Material.ROCK, "ye_bricks_2", 5F, 1, SoundType.STONE);
	public static Block yellow_bricks_3 = new BasicBlock(Material.ROCK, "ye_bricks_3", 5F, 1, SoundType.STONE);
	
	public static Block yellow_bricks_1_crack = new BasicBlock(Material.ROCK, "ye_bricks_1_crack", 5F, 1, SoundType.STONE);
	public static Block yellow_bricks_2_crack = new BasicBlock(Material.ROCK, "ye_bricks_2_crack", 5F, 1, SoundType.STONE);
	public static Block yellow_bricks_3_crack = new BasicBlock(Material.ROCK, "ye_bricks_3_crack", 5F, 1, SoundType.STONE);
	
	public static Block alum_window = new AlumWindow(Material.WOOD, "alum_window", 3F, 0, SoundType.WOOD).setCreativeTab(SovietCore.tabOutDeco);
	
	
	public static Block big_beton_plate = new BasicBlock(Material.ROCK, "big_beton_plate", 5F, 1, SoundType.STONE);
	
	public static Block uf_lamp = new UFLamp(Material.IRON, "uf_lamp", 4F, 1, SoundType.METAL,false).setCreativeTab(SovietCore.tabInsDeco);
	public static Block uf_lamp_break = new UFLampCracked(Material.IRON, "uf_lamp_break", 4F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);
	public static Block uf_lamp_enb = new UFLamp(Material.IRON, "uf_lamp_enb", 4F, 1, SoundType.METAL,true);

	public static Block armchair = new BBSWCMSit(Material.WOOD, "armchair", 6F, 1, SoundType.METAL).setCreativeTab(SovietCore.tabInsDeco);
	
	public static Block hermoblock = new BasicBlock(Material.ROCK, "hermoblock", 3F, 1, SoundType.STONE);
	public static Block parket_left = new BasicBlockSide(Material.ROCK, "parket_left", 3F, 1, SoundType.STONE);
	public static Block parket_right = new BasicBlockSide(Material.ROCK, "parket_right", 3F, 1, SoundType.STONE);
	
	public static Block parket_line = new BasicBlockSide(Material.ROCK, "parket_line", 3F, 1, SoundType.STONE);
	
	public static Block parket_line2 = new BasicBlock(Material.ROCK, "parket_line2", 3F, 1, SoundType.STONE);
	
	public static Block rusty_barrel = new BlocksBarrel(Material.ROCK, "rusty_barrel", 3F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	
	public static Block safe = new BlockSafe("safe").setCreativeTab(SovietCore.tabInsDeco);
	public static Block stillage = new StillageBlock("stillage").setCreativeTab(SovietCore.tabInsDeco);
	
	public static Block nii_wall_1_crack = new BasicBlock(Material.ROCK, "nii_wall_1_crack", 6F, 1, SoundType.STONE);
	public static Block light_bricks2 = new BasicBlock(Material.ROCK, "light_bricks2", 6F, 1, SoundType.STONE);
	public static Block light_bricks2_crack = new BasicBlock(Material.ROCK, "light_bricks2_crack", 6F, 1, SoundType.STONE);
	//physical update
	public static Block accl_stand = new BasicBlockSideWithCustomModel(Material.IRON, "physical/accl_stand", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block copper_rings = new BasicBlockSideWithCustomModel(Material.IRON, "physical/copper_rings", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block copper_rings_end = new BasicBlockSideWithCustomModel(Material.IRON, "physical/copper_rings_end", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block accl = new Accelerator(Material.IRON, "physical/accl", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block lead_wall = new LeadWall(Material.IRON, "physical/lead_wall", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block thin_lead_wall = new ThinLeadWall(Material.IRON, "physical/thin_lead_wall", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block spec_monitor = new FullFormMonitor(Material.IRON, "physical/spec_monitor", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block ameter = new Apparatus(Material.IRON, "physical/ameter", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block pmeter = new Apparatus(Material.IRON, "physical/pmeter", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block vmeter = new Apparatus(Material.IRON, "physical/vmeter", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block wmeter = new Apparatus(Material.IRON, "physical/wmeter", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block kmeter = new Apparatus(Material.IRON, "physical/kmeter", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block m_meter = new SmallApparatus(Material.IRON, "physical/m_meter", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block em_meter = new SmallApparatus(Material.IRON, "physical/em_meter", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block f_meter = new SmallApparatus(Material.IRON, "physical/f_meter", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block om_meter = new SmallApparatus(Material.IRON, "physical/om_meter", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block accl_tile = new BasicBlock(Material.ROCK, "physical/accl_tile", 6F, 1, SoundType.STONE);
	public static Block oscilloscope = new Oscilloscope(Material.IRON, "physical/oscilloscope", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block autowriter = new AutoWriter(Material.IRON, "physical/autowriter", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	
	public static Block accl_lamp_cracked = new AccelLampCracked(Material.IRON, "physical/accl_lamp_cracked", 6F, 1, SoundType.STONE).setCreativeTab(SovietCore.tabInsDeco);
	public static Block accl_lamp = new AccelLamp(Material.IRON, "physical/accl_lamp", 6F, 1, SoundType.STONE, false).setCreativeTab(SovietCore.tabInsDeco);
	public static Block accl_lamp_true = new AccelLamp(Material.IRON, "physical/accl_lamp_true", 6F, 1, SoundType.STONE, true);
	public static void register() {
		//physical update
		registerBlock(accl_stand);
		registerBlock(copper_rings);
		registerBlock(copper_rings_end);
		registerBlock(accl);
		registerBlock(lead_wall);
		registerBlock(thin_lead_wall);
		registerBlock(spec_monitor);
		registerBlock(ameter);
		registerBlock(vmeter);
		registerBlock(pmeter);
		registerBlock(m_meter);
		registerBlock(em_meter);
		registerBlock(f_meter);
		registerBlock(wmeter);
		registerBlock(om_meter);
		registerBlock(kmeter);
		registerBlock(accl_lamp);
		registerBlock(accl_lamp_true);
		registerBlock(accl_lamp_cracked);
		registerBlock(oscilloscope);
		registerBlock(autowriter);
		registerBlock(accl_tile);
		
		//older update
		registerBlock(safe);
		registerBlock(rusty_barrel);
		registerBlock(parket_line2);
		registerBlock(nii_wall_1_crack);
		registerBlock(parket_line);
		registerBlock(parket_left);
		registerBlock(parket_right);
		registerBlock(hermoblock);
		registerBlock(uf_lamp_break);
		registerBlock(armchair);
		registerBlock(uf_lamp);
		registerBlock(uf_lamp_enb);
		
		registerBlock(ye_beton_panel);
		registerBlock(ye_beton_panel_rot);
		registerBlock(ye_beton_panel_ang);
		
		registerBlock(soviet_bricks_crack);
		registerBlock(soviet_bricks_with_white_crack);
		
		registerBlock(alum_window);
		
		registerBlock(very_small_tile);
		registerBlock(small_bricks);
		registerBlock(white_soviet_bricks_crack);
		registerBlock(yellow_bricks_1);
		registerBlock(yellow_bricks_1_crack);
		registerBlock(yellow_bricks_2);
		registerBlock(yellow_bricks_2_crack);
	
		registerBlock(yellow_bricks_3);
		registerBlock(yellow_bricks_3_crack);
		
		
		registerBlock(rusty_iron_door);
		
		registerBlock(light_bricks_crack);
		
		registerBlock(motion_sensor);
		registerBlock(light_bricks);
		registerBlock(ug_rail);
		registerBlock(ug_rail_rot);
		registerBlock(ug_rail_rot2);
		registerBlock(ug_rail_rot3);
		registerBlock(ug_rail_rot4);
		registerBlock(ug_rail_diag);
		registerBlock(contact_wire_angle);
		registerBlock(contact_wire);
		registerBlock(contact_wire_base);
		SymbolList.registerSym();
		registerBlock(gofro_handhold_angle);
		registerBlock(street_fence);
		registerBlock(street_fence_angle);
		registerBlock(vibro_wire_lever);
		registerBlock(turnstile_off);
		registerBlock(turnstile_on);
		registerBlock(soviet_tumb);
		registerBlock(soviet_chair_wood);
		registerBlock(base_po2);
		registerBlock(panel_block);
		registerBlock(beton_wall);
		registerBlock(vibro_wire);
		registerBlock(vibro_wire_b);
		registerBlock(street_light_false);
		registerBlock(street_light_true);
		registerBlock(sl_top_1_on);
		registerBlock(sl_top_1_off);
		registerBlock(sl_top_2_off);
		registerBlock(sl_top_2_on);
		registerBlock(street_light_down_1);
		registerBlock(street_light_down_2);
		registerBlock(street_light_middle);
		registerBlock(closed_sovietlamp);
		registerBlock(closed_sovietlamptrue);
		registerBlock(nii_glass_1);
		registerBlock(brown_tile);
		registerBlock(small_tiles);
		registerBlock(small_tiles_blue);
		registerBlock(small_tiles_cracked);
		registerBlock(small_tiles_blue_cracked);

		registerBlock(alm_door);
		registerBlock(chem_stuff_1);
		registerBlock(chem_stuff_2);
		registerBlock(nii_wall_1);
		registerBlock(brown_tile_crack);
		registerBlock(vent_pipe_base);
		registerBlock(soviet_column);
		registerBlock(soviet_window_angle);
		registerBlock(lab_table_center);
		registerBlock(panel_block_ang);
		registerBlock(intro_doors);
		registerBlock(factory_window);
		registerBlock(aquamarine_tile);
		registerBlock(aquamarine_tile_cracked);
		registerBlock(inc_lamp_false);
		registerBlock(inc_lamp_true);
		registerBlock(wood_labshelf_down);
		registerBlock(wood_labshelf_down_break);
		registerBlock(wood_labshelf_upper);
		registerBlock(wood_labshelf_upper_break);
	//	registerBlock(swamp_water);
		registerBlock(vent_pipe);
		registerBlock(hermo_trapdoor);
		registerBlock(lab_table_right);
		registerBlock(lab_table_left);
		registerBlock(rusty_handhold_angle);
		registerBlock(gofro_gold);
		registerBlock(magnetmixer);
		registerBlock(alkofire);
		registerBlock(mixer);
		registerBlock(autoclave);
		registerBlock(barb_wire);
		registerBlock(hermo_door);
		registerBlock(fantom_block2);
		registerBlock(fantom_block);
		registerBlock(po_2_down);
		registerBlock(po_2_up);
		registerBlock(rasty_rall);
		registerBlock(electro_stove);
		registerBlock(keyboard);
		registerBlock(distill_app);
		registerBlock(quartz_tigel);
		registerBlock(steve_helm_s);
		registerBlock(steve_helm);
		registerBlock(dry_cab);
		registerBlock(block_moss);
		registerBlock(wood_door);
		registerBlock(wood_door_into);
		registerBlock(raw_beton);
		registerBlock(white_soviet_bricks);
		registerBlock(mega_lamp);
		registerBlock(mega_lamp_true);
		registerBlock(lift_up);
		registerBlock(lift_down);
		registerBlock(soviet_box);
		registerBlock(floor_grid);
		registerBlock(red_lamp);
		registerBlock(red_lamp_on);
		registerBlock(white_tilled_block);
		registerIBlock("glazed_tile_color", "glazed_tile_type", glazed_tile);
		registerIBlock("glazed_tile_blue_cracked_color", "glazed_tile_blue_cracked_type",glazed_tile_blue_cracked);
		registerIBlock("glazed_tile_white_cracked_color", "glazed_tile_white_cracked_type",glazed_tile_white_cracked);
		registerIBlock("glazed_tile_cracked_color", "glazed_tile_cracked_type",glazed_tile_cracked);
		registerIBlock("glazed_tile_blue_color", "glazed_tile_blue_type",glazed_tile_blue);
		registerIBlock("glazed_tile_white_color", "glazed_tile_white_type",glazed_tile_white);
		registerIBlock("tilled_block_cracked_color", "tilled_block_cracked_type",tilled_block_cracked);
		registerIBlock("moss_tilled_block_color", "moss_tilled_block_type",moss_tilled_block);
		registerIBlock("blue_tilled_block_color", "blue_tilled_block_type",blue_tilled_block);
		registerIBlock("tilled_block_color", "tilled_block_type",tilled_block);
		registerIBlock("blue_tilled_block_moss_color", "blue_tilled_block_moss_type",blue_tilled_block_moss);
		registerIBlock("blue_tilled_block_cracked_color", "blue_tilled_block_cracked_type",blue_tilled_block_cracked);
		registerIBlock("glazed_tile_black_color", "glazed_tile_black_type", glazed_tile_black);
		registerIBlock("glazed_tile_black_cracked_color", "glazed_tile_black_cracked_type", glazed_tile_black_cracked);
		registerBlock(toilet);
		registerBlock(sink);
		registerBlock(lino2);
		registerBlock(lab_glass_case);
		registerBlock(wires);
		registerBlock(glass_tube);
		registerBlock(tableside);
		registerBlock(beton_block);
		registerBlock(lab_tile);
		registerBlock(lab_tile2);
		registerBlock(full_diagonal_grid);
		registerBlock(full_diagonal_grid_invert);
		registerBlock(diagonal_grid);
		registerBlock(polu_circle_grid);
		registerBlock(sovietlamp_cracked);
		registerBlock(rubbish);
		registerBlock(soviet_window);
		registerBlock(airlock_door);
		registerBlock(pipe_autoclave);
		registerBlock(electro_board);
		registerBlock(thintube);
		registerBlock(comp);
		registerBlock(sysblock);
		registerBlock(pipes);
		registerBlock(pipeangle);
		registerBlock(iron_beam_thin_vertical);
		registerBlock(iron_beam_thin);
		registerBlock(soviet_chair);
		registerBlock(iron_beam_vertical);
		registerBlock(iron_beam_withbeton);
		registerBlock(iron_beam);
		registerBlock(beton_with_ralling);
		registerBlock(soviet_bricks_with_white);
		registerBlock(green_beton_with_ralling);
		registerBlock(lino3);
		registerBlock(soviet_ladder);
		registerBlock(panel_block_rot);

		registerBlock(biolab_tile);
		registerBlock(biolab_tile_up);
		
		registerBlock(beton_panel);
		registerBlock(beton_panel_ang);
		registerBlock(beton_panel_rot);


		registerBlock(bedside);
		registerBlock(beton_stairs);
		registerBlock(battery);

		registerBlock(rusty_handhold);
		registerBlock(gofro_handhold);
		registerBlock(soviet_bricks);
		registerBlock(green_bricks);
		registerBlock(rusty_ralling);
		registerBlock(soviet_window_leaf);
		registerBlock(lino1);

		registerBlock(soviet_selector);
		registerBlock(soviet_table);

		registerBlock(ralling_door);
		registerBlock(soviet_ladder2);
		//
		registerBlock(sovietlamp);
		registerBlock(sovietlamptrue);
		registerBlock(modern_window);
		registerBlock(travertine_block);
		registerBlock(soviet_bed);
		registerBlock(modern_window_leaf);
		registerBlockMeta(betons, new ItemBlockBeton(betons));
		registerBlockMeta(kafels, new ItemBlockKafel(kafels));
		registerBlockMeta(nii_blocks, new ItemBlockNIIBlocks(nii_blocks));

		registerBlock(asphalt);
		registerBlock(road_asphalt);
		registerBlock(nii_glass_2);
		registerBlock(bordur);
		registerBlock(windproof_beton);
		registerBlock(small_tiles_red);
		registerBlock(small_tiles_red_cracked);
		registerBlock(small_tiles_yellow);
		registerBlock(small_tiles_yellow_cracked);
		registerBlock(red_bricks);
		registerBlock(big_beton_plate);
		registerBlock(light_bricks2);
		registerBlock(light_bricks2_crack);
		registerBlock(stillage);
	}

	public static void registerRender() {
		
		//physical update
		registerRenderBlock(accl_stand);
		registerRenderBlock(copper_rings);
		registerRenderBlock(copper_rings_end);
		registerRenderBlock(accl);
		registerRenderBlock(lead_wall);
		registerRenderBlock(thin_lead_wall);
		registerRenderBlock(spec_monitor);
		registerRenderBlock(ameter);
		registerRenderBlock(vmeter);
		registerRenderBlock(pmeter);
		registerRenderBlock(m_meter);
		registerRenderBlock(em_meter);
		registerRenderBlock(f_meter);
		registerRenderBlock(accl_lamp);
		registerRenderBlock(accl_lamp_true);
		registerRenderBlock(accl_lamp_cracked);
		registerRenderBlock(wmeter);
		registerRenderBlock(om_meter);
		registerRenderBlock(kmeter);
		registerRenderBlock(oscilloscope);
		registerRenderBlock(autowriter);
		registerRenderBlock(accl_tile);
		
		//older update
		registerRenderBlock(stillage);
		registerRenderBlock(safe);
		registerRenderBlock(rusty_barrel);
		registerRenderBlock(parket_line2);
		registerRenderBlock(light_bricks2);
		registerRenderBlock(light_bricks2_crack);
		registerRenderBlock(nii_wall_1_crack);
		registerRenderBlock(parket_left);
		registerRenderBlock(parket_right);
		registerRenderBlock(parket_line);
		registerRenderBlock(armchair);
		registerRenderBlock(uf_lamp);
		registerRenderBlock(uf_lamp_enb);
		registerRenderBlock(hermoblock);
		registerRenderBlock(biolab_tile);
		registerRenderBlock(biolab_tile_up);
		
		registerRenderBlock(ye_beton_panel);
		registerRenderBlock(ye_beton_panel_rot);
		registerRenderBlock(ye_beton_panel_ang);
		
		registerRenderBlock(big_beton_plate);
		registerRenderBlock(soviet_bricks_crack);
		registerRenderBlock(soviet_bricks_with_white_crack);
		registerRenderBlock(white_soviet_bricks_crack);
		registerRenderBlock(small_bricks);
		registerRenderBlock(yellow_bricks_1_crack);
		registerRenderBlock(yellow_bricks_2_crack);
		registerRenderBlock(very_small_tile);
		registerRenderBlock(yellow_bricks_1);
		registerRenderBlock(yellow_bricks_2);
		registerRenderBlock(yellow_bricks_3);
		registerRenderBlock(yellow_bricks_3_crack);
		registerRenderBlock(light_bricks);
		registerRenderBlock(red_bricks);
		registerRenderBlock(soviet_bricks_with_white);
		registerRenderBlock(white_soviet_bricks);
		registerRenderBlock(soviet_bricks);
		registerRenderBlock(uf_lamp_break);
		registerRenderBlock(alum_window);
		
		registerRenderBlock(light_bricks_crack);
		
		registerRenderBlock(rusty_iron_door);
		registerRenderBlock(small_tiles_red);
		registerRenderBlock(small_tiles_red_cracked);
		registerRenderBlock(small_tiles_yellow);
		registerRenderBlock(small_tiles_yellow_cracked);
		registerRenderBlock(motion_sensor);
		
		SymbolList.registerRenderSym();
		registerRenderBlock(contact_wire);
		registerRenderBlock(contact_wire_angle);
		registerRenderBlock(contact_wire_base);
		registerRenderBlock(road_asphalt);
		registerRenderBlock(bordur);
		registerRenderBlock(nii_glass_2);
		registerRenderBlock(windproof_beton);
		registerRenderBlock(vibro_wire_lever);
		registerRenderBlock(gofro_handhold_angle);
		registerRenderBlock(street_fence_angle);
		registerRenderBlock(street_fence);
		registerRenderBlock(travertine_block);
		registerRenderBlock(ug_rail);
		registerRenderBlock(ug_rail_rot);
		registerRenderBlock(ug_rail_rot2);
		registerRenderBlock(ug_rail_diag);
		registerRenderBlock(ug_rail_rot3);
		registerRenderBlock(ug_rail_rot4);
		registerRenderBlock(panel_block_ang);
		registerRenderBlock(factory_window);
		registerRenderBlock(panel_block);
		registerRenderBlock(panel_block_rot);
		registerRenderBlock(soviet_tumb);
		registerRenderBlock(soviet_bed);
		registerRenderBlock(vibro_wire);
		registerRenderBlock(beton_wall);
		registerRenderBlock(lino1);
		registerRenderBlock(soviet_chair_wood);
		registerRenderBlock(base_po2);
		registerRenderBlock(vibro_wire_b);
		registerRenderBlock(street_light_false);
		registerRenderBlock(alm_door);
		registerRenderBlock(street_light_true);
		registerRenderBlock(sl_top_1_on);
		registerRenderBlock(closed_sovietlamp);
		registerRenderBlock(closed_sovietlamptrue);
		registerRenderBlock(sl_top_1_off);
		registerRenderBlock(soviet_window_angle);
		registerRenderBlock(sl_top_2_off);
		registerRenderBlock(sl_top_2_on);
		registerRenderBlock(street_light_down_1);
		registerRenderBlock(street_light_down_2);
		registerRenderBlock(street_light_middle);
		registerRenderBlock(modern_window);
		registerRenderBlock(modern_window_leaf);
		registerRenderBlock(nii_glass_1);
		registerRenderBlock(small_tiles);
		registerRenderBlock(small_tiles_blue);
		registerRenderBlock(small_tiles_cracked);
		registerRenderBlock(small_tiles_blue_cracked);
		registerRenderBlock(ralling_door);
		registerRenderBlock(chem_stuff_1);
		registerRenderBlock(chem_stuff_2);
		registerRenderBlock(nii_wall_1);
		registerRenderBlock(vent_pipe_base);
		registerRenderBlock(soviet_column);
		registerRenderBlock(lab_tile);
		registerRenderBlock(lab_tile2);
		registerRenderBlock(aquamarine_tile);
		registerRenderBlock(brown_tile);
		registerRenderBlock(aquamarine_tile_cracked);
		registerRenderBlock(intro_doors);
		registerRenderBlock(inc_lamp_false);
		registerRenderBlock(inc_lamp_true);
	//	registerRenderBlock(swamp_water);
		registerRenderBlock(wood_labshelf_down);
		registerRenderBlock(wood_labshelf_down_break);
		registerRenderBlock(wood_labshelf_upper);
		registerRenderBlock(wood_labshelf_upper_break);
		registerRenderBlock(wood_door);
		registerRenderBlock(vent_pipe);
		registerRenderBlock(dry_cab);
		registerRenderBlock(lab_table_right);
		registerRenderBlock(lab_glass_case);
		registerRenderBlock(brown_tile_crack);
		registerRenderBlock(lab_table_left);
		registerRenderBlock(barb_wire);
		registerRenderBlock(beton_panel);
		registerRenderBlock(beton_panel_ang);
		registerRenderBlock(beton_panel_rot);
		registerRenderBlock(rusty_handhold_angle);
		registerRenderBlock(airlock_door);
		registerRenderBlock(magnetmixer);
		registerRenderBlock(alkofire);
		registerRenderBlock(mixer);
		registerRenderBlock(autoclave);
		registerRenderBlock(fantom_block);
		registerRenderBlock(po_2_down);
		registerRenderBlock(po_2_up);
		registerRenderBlock(rasty_rall);
		registerRenderBlock(electro_stove);
		registerRenderBlock(lino2);
		registerRenderBlock(lino3);
		registerRenderBlock(distill_app);
		registerRenderBlock(quartz_tigel);
		registerRenderBlock(keyboard);
		registerRenderBlock(steve_helm_s);
		registerRenderBlock(steve_helm);
		registerRenderBlock(block_moss);
		registerRenderBlock(wood_door_into);
		registerRenderBlock(raw_beton);
		
		registerRenderBlock(mega_lamp_true);
		registerRenderBlock(mega_lamp);
		registerRenderBlock(lift_up);
		registerRenderBlock(lift_down);
		registerRenderBlock(asphalt);
		registerRenderBlock(soviet_box);
		registerRenderBlock(floor_grid);
		registerRenderBlock(glazed_tile_black);
		registerRenderBlock(glazed_tile_black_cracked);
		registerRenderBlock(tableside);
		registerRenderBlock(red_lamp);
		registerRenderBlock(red_lamp_on);
		registerRenderBlock(beton_block);
		registerRenderBlock(lab_table_center);
		registerRenderBlock(soviet_ladder2);
		registerRenderBlock(rubbish);
		registerRenderBlock(hermo_trapdoor);
		registerRenderBlock(toilet);
		registerRenderBlock(sink);
		registerRenderBlock(wires);
		registerRenderBlock(glass_tube);
		registerRenderBlock(white_tilled_block);
		registerRenderBlock(sovietlamp_cracked);
		registerRenderBlock(sysblock);
		registerRenderBlock(thintube);
		registerRenderBlock(comp);
		registerRenderBlock(pipes);
		registerRenderBlock(pipeangle);
		registerRenderBlock(blue_tilled_block_moss);
		registerRenderBlock(blue_tilled_block_cracked);
		registerRenderBlock(full_diagonal_grid);
		registerRenderBlock(full_diagonal_grid_invert);
		registerRenderBlock(diagonal_grid);
		registerRenderBlock(polu_circle_grid);
		registerRenderBlock(soviet_window);
		registerRenderBlock(soviet_window_leaf);
		registerRenderBlock(electro_board);
		registerRenderBlock(pipe_autoclave);
		registerRenderBlock(glazed_tile_blue_cracked);
		registerRenderBlock(glazed_tile_white_cracked);
		registerRenderBlock(glazed_tile_cracked);
		registerRenderBlock(glazed_tile_blue);
		registerRenderBlock(glazed_tile_white);
		registerRenderBlock(glazed_tile);
		registerRenderBlock(iron_beam_thin_vertical);
		registerRenderBlock(iron_beam_thin);
		registerRenderBlock(soviet_chair);

		registerRenderBlock(turnstile_off);
		registerRenderBlock(turnstile_on);

		registerRenderBlock(iron_beam_vertical);
		registerRenderBlock(iron_beam_withbeton);
		registerRenderBlock(iron_beam);
		registerRenderBlock(beton_with_ralling);
		registerRenderBlock(soviet_ladder);
		registerRenderBlock(hermo_door);
		registerRenderBlock(bedside);
		registerRenderBlock(beton_stairs);
		registerRenderBlock(battery);
		
		registerRenderBlock(rusty_handhold);
		registerRenderBlock(green_bricks);
		registerRenderBlock(rusty_ralling);
		registerRenderBlock(soviet_bricks);
		registerRenderBlock(green_beton_with_ralling);
		registerRenderBlock(gofro_gold);
		registerRenderBlock(gofro_handhold);
		registerRenderBlock(tilled_block_cracked);
		registerRenderBlock(blue_tilled_block);
		registerRenderBlock(soviet_selector);
		registerRenderBlock(soviet_table);
		registerRenderBlock(sovietlamptrue);
		registerRenderBlock(sovietlamp);
		registerRenderBlock(moss_tilled_block);

		registerRenderBlock(tilled_block);
		
	//	registerRenderBlock(big_hd);
	//	registerRenderBlock(big_hd_corner);
	//	registerRenderBlock(big_hd_edge);

	}
	public static void registerBlockMeta(Block block, ItemBlock itemBlock) {
		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(itemBlock.setRegistryName(block.getRegistryName()));
	}
	public static void registerIBlock(String color, String type, Block block) {
		ForgeRegistries.BLOCKS.register(block);
		if (block instanceof BasicBlockSideWithInfo) {
			ForgeRegistries.ITEMS.register(new BasicItemBlock(color, type, block).setRegistryName(block.getRegistryName()));
		}
	}
	public static void registerBlock(Block block) {
		ForgeRegistries.BLOCKS.register(block);

		ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}
	public static void registerRenderBlock(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
	public static void registerRenderOBJ(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),0, new ModelResourceLocation(new ResourceLocation(block.getRegistryName().getResourceDomain(), block.getRegistryName().getResourcePath().concat(".obj")),"inventory"));
	}

}