package ru.lg.SovietMod.Blocks.DecorativeBlocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class ThinLeadWall extends BasicBlockSideWithCustomModel {

	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 0.3D, 1D, 1D, 0D),
			new AxisAlignedBB(0D, 0D, 1D, 1D, 1D, 0.7D),
			new AxisAlignedBB(1D, 0D, 1D, 0.7D, 1D, 0D),
			new AxisAlignedBB(0.3D, 0D, 1D, 0D, 1D, 0D)
	};
	public ThinLeadWall(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
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