package ru.lg.SovietMod.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import ru.lg.SovietMod.SovietCore;
import ru.lg.SovietMod.Blocks.Basic.BasicBlock;

public class TestGen extends BasicBlock{

	public TestGen(Material materialIn, String name, float hardness,
			float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		// TODO Auto-generated constructor stub
	}
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{

		if(!world.isRemote) {
			WorldServer worldServer = (WorldServer)world;
			MinecraftServer minecraftServer = world.getMinecraftServer();
			TemplateManager templateManager = worldServer.getStructureTemplateManager();
			Template template = templateManager.get(minecraftServer, new ResourceLocation(SovietCore.MODID + ":fgfgh§r"));
			PlacementSettings settings = new PlacementSettings();
			template.addBlocksToWorld(world, pos, settings);
			return true;
		}

		return false;
	}
}
