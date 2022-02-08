package ru.lg.SovietMod.Blocks.BuildingBlocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class WindProofBeton extends BasicBlockSideWithCustomModel{
	private static AxisAlignedBB AABB_X  = new AxisAlignedBB(0.38D, 0D, 0D, 0.63D, 1D, 1D);
	private static AxisAlignedBB AABB_Z = new AxisAlignedBB(0D, 0D, 0.38D, 1D, 1D, 0.63D);
	public WindProofBeton(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		// TODO Auto-generated constructor stub
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case SOUTH:
			return AABB_X;
		case NORTH:
		default:
			return AABB_X;
		case WEST:
			return AABB_Z;
		case EAST:
			return AABB_Z;
		}
	}
}
