package ru.lg.SovietMod.Blocks.DecorativeBlocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class PipeAutoclave extends BasicBlockSideWithCustomModel {
	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0.35D, 0.63D, 1D, 0.65D, 0.87D, 0.65D),
			new AxisAlignedBB(0.35D, 0.63D, 0D, 0.65D, 0.87D, 0.35D),
			new AxisAlignedBB(0.35D, 0.63D, 0.35D, 0D, 0.87D, 0.65D),
			new AxisAlignedBB(0.65D, 0.63D, 0.35D, 1D, 0.87D, 0.65D)
	};
	public PipeAutoclave(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		// TODO Auto-generated constructor stub
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
}
