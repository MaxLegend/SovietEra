package ru.lg.SovietMod.Blocks.DecorativeBlocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import ru.lg.SovietMod.SovietCore;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSide;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class SystemBlock extends BasicBlockSideWithCustomModel {

	 protected static final AxisAlignedBB AABB_Z = new AxisAlignedBB(0.25D, 0.0D, 0D, 0.75D, 0.91D, 1D);
	 protected static final AxisAlignedBB AABB_X = new AxisAlignedBB(0D, 0.0D, 0.25D, 1D, 0.91D, 0.75D);
	public SystemBlock(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);

	}
	   @Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
		{
			switch (state.getValue(FACING))
			{
			case SOUTH:
				return this.AABB_Z;
			case NORTH:
			default:
				return this.AABB_Z;
			case WEST:
				return this.AABB_X;
			case EAST:
				return this.AABB_X;
			}
		}
}
