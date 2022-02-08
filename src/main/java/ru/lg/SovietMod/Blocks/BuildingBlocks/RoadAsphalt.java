package ru.lg.SovietMod.Blocks.BuildingBlocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockWithCustomModel;

public class RoadAsphalt extends BasicBlockSideWithCustomModel {

	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 0D, 1D, 0.75D, 1D),
			 new AxisAlignedBB(0D, 0D, 0D, 1D, 0.75D, 1D),
			 new AxisAlignedBB(0D, 0D, 0D, 1D, 0.75D, 1D),
			 new AxisAlignedBB(0D, 0D, 0D, 1D, 0.75D, 1D)
	};
	public RoadAsphalt(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case SOUTH:
			return SIDE_AABB[0];
		case NORTH:
		default:
			return SIDE_AABB[1];
		case WEST:
			return SIDE_AABB[2];
		case EAST:
			return SIDE_AABB[3];
		}
	}
}
