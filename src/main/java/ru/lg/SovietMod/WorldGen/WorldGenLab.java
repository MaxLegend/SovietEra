package ru.lg.SovietMod.WorldGen;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import ru.lg.SovietMod.RegConfig;
import ru.lg.SovietMod.SovietCore;

public class WorldGenLab  implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

		switch (world.provider.getDimension()){
		case 0:
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
			break;
		}
	}

	public void check() {
		for(int x = 0; x < 6; x++) {
			for(int y = 0; y < 6; y++) {
				for(int z = 0; z < 6; z++) {
					int result = x*y*z;
				}
			}
		}
	}
	public void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider){	
		ThreadLocalRandom trrand =	ThreadLocalRandom.current();

		//	
		if(RegConfig.enableLabGenerator) {
			if (world.getWorldInfo().getTerrainType() != WorldType.FLAT) {
				if(trrand.nextInt(RegConfig.chanceGeneration1) == 1 && trrand.nextInt(RegConfig.chanceGeneration2) == 3) {

			//	generateLab(world, random, chunkX, chunkZ);
				}
			}
		} else if(!RegConfig.enableLabGenerator) {

		}

	}


	public boolean checkAirSquare(World world, Random random,BlockPos pos) {
		for(int x = 0; x < 12; x++) {
			for(int z = 0; z < 14; z++) {
				if(world.getBlockState(new BlockPos(pos.getX() + x, pos.getY(), pos.getZ() + z)) == Blocks.AIR.getDefaultState()) {
					return false;
				} 
			}
		}
		return true;

	}
	private void generateLab(World world, Random random, int chunkX, int chunkZ){

		ThreadLocalRandom trrand = ThreadLocalRandom.current();
		int x = (chunkX << 4) + trrand.nextInt(8);
		int z = (chunkZ << 4) + trrand.nextInt(8);
		int y = 15;// trrand.nextInt(15, 43);


		BlockPos pos = new BlockPos(x, y, z);
		WorldServer worldServer = (WorldServer)world;
		MinecraftServer minecraftServer = world.getMinecraftServer();
		TemplateManager templateManager = worldServer.getStructureTemplateManager();
		Template template = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":cor"));

		Template templateFour = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":cor_quad"));

		Template st_start = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":cor_st_start"));
		Template st_end = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":cor_st_end"));
		Template st_middle = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":cor_st_middle"));

		//	Template template_OreMine = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":iron_ore_mine"));
		//	Template template_ABLab = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":aband_lab"));

		Template toilets = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":toilets"));
		Template barak = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":barak"));
		Template gener = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":gener"));
		Template lab1 = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":lab1"));

		Template complex_labs = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":complex_labs"));
		Template fvu = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":fvu"));

		Template ventil_start = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":ventil_start"));
		Template ventil_middle = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":ventil_middle"));
		Template ventil_end = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":ventil_end"));

		PlacementSettings settings1 = new PlacementSettings();
		PlacementSettings settings2 = new PlacementSettings();
		PlacementSettings settings3 = new PlacementSettings();

		PlacementSettings settings4 = new PlacementSettings();

		PlacementSettings settings5 = new PlacementSettings();
		System.out.println(pos);
		Biome biome = world.getBiome(pos);

		if(biome == Biomes.PLAINS ||biome == Biomes.SWAMPLAND||biome == Biomes.DESERT ||biome == Biomes.MUTATED_PLAINS||biome == Biomes.MESA_ROCK||biome == Biomes.MESA ||biome == Biomes.SWAMPLAND 
				||biome == Biomes.MUTATED_DESERT||biome == Biomes.ICE_PLAINS||biome == Biomes.MUTATED_SAVANNA||biome == Biomes.MUTATED_ICE_FLATS||biome == Biomes.MUTATED_SAVANNA_ROCK||biome == Biomes.SAVANNA
				||biome == Biomes.SAVANNA_PLATEAU||biome == Biomes.MESA_CLEAR_ROCK) {
			//	template.addBlocksToWorld(world, new BlockPos(pos.getX() , pos.getY(), pos.getZ()), settings);
			//положительный Х удлиняющий четверную развилку
			for(int i = 2; i < 32; i+=4) {
				template.addBlocksToWorld(world, new BlockPos(pos.getX() + i -3 , pos.getY(), pos.getZ() + 2), settings1);
			}

			//отрицательный Х удлиняющий четверную развилку -
			for(int i = 2; i < 32; i+=4) {
				template.addBlocksToWorld(world, new BlockPos(pos.getX() - i -13, pos.getY(), pos.getZ() + 2), settings1);
			}



			//отрицательный Z удлиняющий четверную развилку
			for(int i = 2; i < 32; i+=4) {
				template.addBlocksToWorld(world, new BlockPos(pos.getX() - 8, pos.getY(), pos.getZ() - i), settings2.setRotation(Rotation.COUNTERCLOCKWISE_90));
			}


			//положительный Z удлиняющий четверную развилку -
			for(int i = 2; i < 32; i+=4) {
				template.addBlocksToWorld(world, new BlockPos(pos.getX() - 5, pos.getY(), pos.getZ() + i + 8), settings3.setRotation(Rotation.CLOCKWISE_90));
			}
			templateFour.addBlocksToWorld(world, new BlockPos(pos.getX()-11, pos.getY(), pos.getZ() - 1), settings1);

			//параллельнный отрицательный X
			for(int i = 2; i < 32; i+=4) {
				template.addBlocksToWorld(world, new BlockPos(pos.getX() - i - 9 , pos.getY(), pos.getZ() - 24), settings1);
			}



			//параллельный отрицательный Z
			for(int i = 2; i < 32; i+=4) {
				template.addBlocksToWorld(world, new BlockPos(pos.getX() + 13, pos.getY(), pos.getZ() - i + 4), settings2.setRotation(Rotation.COUNTERCLOCKWISE_90));
			}



			// параллельнный положительный Z
			for(int i = 2; i < 32; i+=4) {
				template.addBlocksToWorld(world, new BlockPos(pos.getX() - 27, pos.getY(), pos.getZ() + i + 6), settings2.setRotation(Rotation.COUNTERCLOCKWISE_90));
			}
			//параллельнный положительный X
			for(int i = 2; i < 32; i+=4) {
				template.addBlocksToWorld(world, new BlockPos(pos.getX() + i - 7, pos.getY(), pos.getZ() + 19), settings1);
			}

			//2-параллельный отрицательный Z
			for(int i = 2; i < 32; i+=4) {
				template.addBlocksToWorld(world, new BlockPos(pos.getX() - 18, pos.getY(), pos.getZ() - i - 22), settings2.setRotation(Rotation.COUNTERCLOCKWISE_90));
			}

			// 2-параллельный отрицательный Х 
			for(int i = 2; i < 32; i+=4) {
				template.addBlocksToWorld(world, new BlockPos(pos.getX() - i - 28, pos.getY(), pos.getZ() + 17), settings1);
			}

			//2-параллельный положительный Z
			for(int i = 2; i < 32; i+=4) {
				template.addBlocksToWorld(world, new BlockPos(pos.getX() +18, pos.getY(), pos.getZ() + i + 20), settings3.setRotation(Rotation.CLOCKWISE_90));
			}
			//2 - параллельнный положительный X
			for(int i = 2; i < 32; i+=4) {
				template.addBlocksToWorld(world, new BlockPos(pos.getX() + i + 14, pos.getY(), pos.getZ() - 19), settings1);
			}

			st_start.addBlocksToWorld(world, new BlockPos(pos.getX() -50, pos.getY(), pos.getZ() + 2), settings1);



			for(int i = 0; i < 80; i+=6) {


				BlockPos endPos = new BlockPos(pos.getX() -50, pos.getY() + i+ 7, pos.getZ() + 2);


				st_middle.addBlocksToWorld(world, new BlockPos(pos.getX() -50, pos.getY() + i + 1, pos.getZ() + 2), settings1);


				if(world.getBlockState(endPos) == Blocks.LEAVES.getDefaultState() && world.getBlockState(endPos) == Blocks.LEAVES2.getDefaultState()) {
					break;
				}
				if(!world.canSeeSky(endPos)) {
					continue;
				} else 

					if(world.getBlockState(endPos) == Blocks.AIR.getDefaultState()) {

						st_end.addBlocksToWorld(world, endPos, settings1);




						break;
					} 



			}

			//Туалеты
			toilets.addBlocksToWorld(world, new BlockPos(pos.getX() -11 , pos.getY(), pos.getZ() - 51), settings4);

			//Казарма
			barak.addBlocksToWorld(world, new BlockPos(pos.getX() -31 , pos.getY(), pos.getZ() + 37), settings4);
			//Лаборатория 1
			lab1.addBlocksToWorld(world, new BlockPos(pos.getX() + 27 , pos.getY(), pos.getZ() + 11), settings4);

			//Генераторная
			gener.addBlocksToWorld(world, new BlockPos(pos.getX() + 20 , pos.getY(), pos.getZ() - 36),  settings3.setRotation(Rotation.CLOCKWISE_90));

			//Вентшахта 1
			ventil_start.addBlocksToWorld(world, new BlockPos(pos.getX() -50, pos.getY() + 1, pos.getZ() + 14), settings1);
			for(int i = 0; i < 80; i+=6) {
				BlockPos endPos2 = new BlockPos(pos.getX() -51, pos.getY() + i + 12, pos.getZ() + 13);

				ventil_middle.addBlocksToWorld(world, new BlockPos(pos.getX() - 50, pos.getY()+ i + 5, pos.getZ() + 14), settings1);
				if(!world.canSeeSky(endPos2)) {
					continue;
				} else
					if(world.getBlockState(endPos2) == Blocks.LEAVES.getDefaultState() && world.getBlockState(endPos2) == Blocks.LEAVES2.getDefaultState()) {
						break;
					} else

						if(world.getBlockState(endPos2) == Blocks.AIR.getDefaultState()) {

							ventil_end.addBlocksToWorld(world, endPos2, settings1);

							break;
						} 
			}

			//Вентшахта 2
			ventil_start.addBlocksToWorld(world, new BlockPos(pos.getX() +19, pos.getY() + 1, pos.getZ() - 26), settings3.setRotation(Rotation.CLOCKWISE_90));
			for(int i = 0; i < 80; i+=6) {
				BlockPos endPos3 = new BlockPos(pos.getX() +20, pos.getY() + i + 12, pos.getZ() - 27);

				ventil_middle.addBlocksToWorld(world, new BlockPos(pos.getX() +19, pos.getY() + 5+ i, pos.getZ() - 26), settings3.setRotation(Rotation.CLOCKWISE_90));
				if(!world.canSeeSky(endPos3)) {
					continue;
				} else
					if(world.getBlockState(endPos3) == Blocks.LEAVES.getDefaultState() && world.getBlockState(endPos3) == Blocks.LEAVES2.getDefaultState()) {
						break;
					} else

						if(world.getBlockState(endPos3) == Blocks.AIR.getDefaultState()) {

							ventil_end.addBlocksToWorld(world, endPos3, settings3.setRotation(Rotation.CLOCKWISE_90));

							break;
						} 
			}

			//Вентшахта 3
			ventil_start.addBlocksToWorld(world, new BlockPos(pos.getX() +20, pos.getY() + 1, pos.getZ() + 16), settings5);
			for(int i = 0; i < 80; i+=6) {
				BlockPos endPos4 = new BlockPos(pos.getX() + 19, pos.getY() + i + 12, pos.getZ() + 15);

				ventil_middle.addBlocksToWorld(world, new BlockPos(pos.getX() +20, pos.getY() + 5+ i, pos.getZ() + 16), settings5);

				if(!world.canSeeSky(endPos4)) {
					continue;
				} else
					if(world.getBlockState(endPos4) == Blocks.LEAVES.getDefaultState() && world.getBlockState(endPos4) == Blocks.LEAVES2.getDefaultState()) {
						break;
					} else

						if(world.getBlockState(endPos4) == Blocks.AIR.getDefaultState()) {

							ventil_end.addBlocksToWorld(world, endPos4, settings5);

							break;
						} 
			}

			//Вентшахта 4
			ventil_start.addBlocksToWorld(world, new BlockPos(pos.getX() -30, pos.getY() + 1, pos.getZ() - 27), settings5);
			for(int i = 0; i < 80; i+=6) {
				BlockPos endPos5 = new BlockPos(pos.getX() -31, pos.getY() + i + 12, pos.getZ() -28);

				ventil_middle.addBlocksToWorld(world, new BlockPos(pos.getX() - 30, pos.getY() + 5+ i, pos.getZ() - 27), settings5);
				if(!world.canSeeSky(endPos5)) {
					continue;
				} else
					if(world.getBlockState(endPos5) == Blocks.LEAVES.getDefaultState() && world.getBlockState(endPos5) == Blocks.LEAVES2.getDefaultState()) {
						break;
					} else
						if(world.getBlockState(endPos5) == Blocks.AIR.getDefaultState()) {

							ventil_end.addBlocksToWorld(world, endPos5, settings5);

							break;
						} 
			}
			//ФВУ
			fvu.addBlocksToWorld(world, new BlockPos(pos.getX() -11, pos.getY(), pos.getZ() + 42), settings5);

			//Комплекс лабораторий
			complex_labs.addBlocksToWorld(world, new BlockPos(pos.getX() + 63, pos.getY(), pos.getZ() - 8), settings5.setRotation(Rotation.CLOCKWISE_180));
		}

	}
}

