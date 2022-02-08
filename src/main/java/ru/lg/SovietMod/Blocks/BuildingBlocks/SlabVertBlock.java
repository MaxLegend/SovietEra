package ru.lg.SovietMod.Blocks.BuildingBlocks;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSide;

public class SlabVertBlock extends BasicBlockSide{
	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 0.35D, 1D, 1D, 0.65D),
			new AxisAlignedBB(0D, 0D, 0.35D, 1D, 1D, 0.65D),
			new AxisAlignedBB(0.35D, 0D, 0D, 0.65D, 1D, 1D),
			new AxisAlignedBB(0.35D, 0D, 0D, 0.65D, 1D, 1D)
	};
	public SlabVertBlock(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);

	}
	
	

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case SOUTH:
			return this.SIDE_AABB[0];
		case NORTH:
		default:
			return this.SIDE_AABB[1];
		case WEST:
			return this.SIDE_AABB[2];
		case EAST:
			return this.SIDE_AABB[3];
		}
	}

	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
}
