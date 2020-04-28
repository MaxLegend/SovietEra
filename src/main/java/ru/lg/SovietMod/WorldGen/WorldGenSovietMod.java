package ru.lg.SovietMod.WorldGen;

import java.util.Random;

import javax.swing.text.Utilities;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import ru.lg.SovietMod.SovietCore;

public class WorldGenSovietMod implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

		switch (world.provider.getDimension()){
		case 0:
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
			break;
		}
	}
	public void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider){		 
		
		generateForestHouse(world, random, chunkX, chunkZ);
		generateSnowHouse(world, random, chunkX, chunkZ);
	
		generateJungleHouse(world, random, chunkX, chunkZ);
	}
	
	private void generateJungleHouse(World world, Random random, int chunkX, int chunkZ){
		int x = (chunkX << 4) + 8;
		int z = (chunkZ << 4) + 8;
		int y = random.nextInt(world.getActualHeight());
		if(y < 60) return;
		if(y > 100) return;
		BlockPos position = new BlockPos(x, y, z);
		WorldServer worldServer = (WorldServer)world;
		MinecraftServer minecraftServer = world.getMinecraftServer();
		TemplateManager templateManager = worldServer.getStructureTemplateManager();
		Template snow_house = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":aband_home_jungle"));
		PlacementSettings settings = new PlacementSettings();

		if(		   world.getBiome(new BlockPos(x ,y,z)) == Biomes.JUNGLE 
				|| world.getBiome(new BlockPos(x ,y,z)) == Biomes.JUNGLE_EDGE
				|| world.getBiome(new BlockPos(x ,y,z)) == Biomes.JUNGLE_HILLS 
				|| world.getBiome(new BlockPos(x ,y,z)) == Biomes.MUTATED_JUNGLE_EDGE
				|| world.getBiome(new BlockPos(x ,y,z)) == Biomes.MUTATED_JUNGLE) 
		{
			if(random.nextInt(11) == 4)
			{

				if(!world.isAirBlock(new BlockPos(x ,y - 1,z))) {
					if(world.getBlockState(new BlockPos(x ,y - 1,z)) instanceof BlockBush)
					{
						return;
					}
					if(world.getBlockState(new BlockPos(x ,y - 1,z)) instanceof BlockLeaves)
					{
						return;
					}
					if(world.getBlockState(new BlockPos(x ,y - 1,z)) instanceof BlockLog)
					{
						return;
					}
					snow_house.addBlocksToWorld(world, position.down(1), settings);
				}
			}
		}

		for (int j = 0; j <= 10; j++) {
			for (int k = 0; k <= 14; k++) {
				for (int l = 0; l <= 5; l++) {
					BlockPos check = new BlockPos(x + j, y + l, z + k);
					IBlockState state = world.getBlockState(check);
					if(state.getBlock() == Blocks.CHEST){
						TileEntity tile = world.getTileEntity(check);
						if(tile != null && tile instanceof TileEntityChest){
							TileEntityChest chest = (TileEntityChest)tile;
			
							chest.setLootTable(new ResourceLocation("minecraft:chests/simple_dungeon"), 0);
							chest.fillWithLoot(null);
						}
					}
				}
			}
		}
	}
	
	private void generateForestHouse(World world, Random random, int chunkX, int chunkZ){
		int x = (chunkX << 4) + 8;
		int z = (chunkZ << 4) + 8;
		int y = random.nextInt(world.getActualHeight());
		if(y < 60) return;
		if(y > 100) return;
		BlockPos position = new BlockPos(x, y, z);
		WorldServer worldServer = (WorldServer)world;
		MinecraftServer minecraftServer = world.getMinecraftServer();
		TemplateManager templateManager = worldServer.getStructureTemplateManager();
		Template snow_house = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":aband_home_forest"));
		PlacementSettings settings = new PlacementSettings();

		if(		   world.getBiome(new BlockPos(x ,y,z)) == Biomes.FOREST 
				|| world.getBiome(new BlockPos(x ,y,z)) == Biomes.FOREST_HILLS
				|| world.getBiome(new BlockPos(x ,y,z)) == Biomes.BIRCH_FOREST 
				|| world.getBiome(new BlockPos(x ,y,z)) == Biomes.BIRCH_FOREST_HILLS
				|| world.getBiome(new BlockPos(x ,y,z)) == Biomes.MUTATED_BIRCH_FOREST) 
		{
			if(random.nextInt(11) == 4)
			{

				if(!world.isAirBlock(new BlockPos(x ,y - 1,z))) {
					if(world.getBlockState(new BlockPos(x ,y - 1,z)) instanceof BlockBush)
					{
						return;
					}
					if(world.getBlockState(new BlockPos(x ,y - 1,z)) instanceof BlockLeaves)
					{
						return;
					}
					if(world.getBlockState(new BlockPos(x ,y - 1,z)) instanceof BlockLog)
					{
						return;
					}
					snow_house.addBlocksToWorld(world, position.down(1), settings);
				}
			}
		}

		for (int j = 0; j <= 8; j++) {
			for (int k = 0; k <= 11; k++) {
				for (int l = 0; l <= 5; l++) {
					BlockPos check = new BlockPos(x + j, y + l, z + k);
					IBlockState state = world.getBlockState(check);
					if(state.getBlock() == Blocks.CHEST){
						TileEntity tile = world.getTileEntity(check);
						if(tile != null && tile instanceof TileEntityChest){
							TileEntityChest chest = (TileEntityChest)tile;
			
							chest.setLootTable(new ResourceLocation("minecraft:chests/simple_dungeon"), 0);
							chest.fillWithLoot(null);
						}
					}
				}
			}
		}

	}
	private void generateSnowHouse(World world, Random random, int chunkX, int chunkZ){
		int x = (chunkX << 4) + 8;
		int z = (chunkZ << 4) + 8;
		int y = random.nextInt(world.getActualHeight());
		if(y < 60) return;
		if(y > 100) return;
		BlockPos position = new BlockPos(x, y, z);
		WorldServer worldServer = (WorldServer)world;
		MinecraftServer minecraftServer = world.getMinecraftServer();
		TemplateManager templateManager = worldServer.getStructureTemplateManager();
		Template snow_house = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":aband_snow_home"));
		PlacementSettings settings = new PlacementSettings();

		if(		   world.getBiome(new BlockPos(x ,y,z)) == Biomes.TAIGA 
				|| world.getBiome(new BlockPos(x ,y,z)) == Biomes.TAIGA_HILLS
				|| world.getBiome(new BlockPos(x ,y,z)) == Biomes.COLD_BEACH 
				|| world.getBiome(new BlockPos(x ,y,z)) == Biomes.COLD_TAIGA
				|| world.getBiome(new BlockPos(x ,y,z)) == Biomes.COLD_TAIGA_HILLS) 
		{
			if(random.nextInt(1) == 4)
			{

				if(!world.isAirBlock(new BlockPos(x ,y - 1,z))) {
					if(world.getBlockState(new BlockPos(x ,y - 1,z)) instanceof BlockBush)
					{
						return;
					}
					if(world.getBlockState(new BlockPos(x ,y - 1,z)) instanceof BlockLeaves)
					{
						return;
					}
					if(world.getBlockState(new BlockPos(x ,y - 1,z)) instanceof BlockLog)
					{
						return;
					}
					snow_house.addBlocksToWorld(world, position.down(1), settings);
				}
			}
		}

		for (int j = 0; j <= 15; j++) {
			for (int k = 0; k <= 12; k++) {
				for (int l = 0; l <= 6; l++) {
					BlockPos check = new BlockPos(x + j, y + l, z + k);
					IBlockState state = world.getBlockState(check);
					if(state.getBlock() == Blocks.CHEST){
						TileEntity tile = world.getTileEntity(check);
						if(tile != null && tile instanceof TileEntityChest){
							TileEntityChest chest = (TileEntityChest)tile;
			
							chest.setLootTable(new ResourceLocation("minecraft:chests/simple_dungeon"), 0);
							chest.fillWithLoot(null);
						}
					}
				}
			}
		}

	}
	
	


}