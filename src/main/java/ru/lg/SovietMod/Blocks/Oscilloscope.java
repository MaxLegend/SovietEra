package ru.lg.SovietMod.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class Oscilloscope extends BasicBlockSideWithCustomModel {

	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0.23D, 0D, 0.06D, 0.83D,  0.455D, 0.94D),
			new AxisAlignedBB(0.178D, 0D, 0.06D, 0.76D,  0.455D, 0.94D),
			
			 new AxisAlignedBB(0.06D, 0D, 0.23D, 0.94D,  0.455D, 0.83D),
			new AxisAlignedBB(0.13D, 0D, 0.05D, 0.88D,  0.469D, 0.95D)

	};
	public Oscilloscope(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case SOUTH:
			return new AxisAlignedBB(0.23D, 0D, 0.06D, 0.83D,  0.455D, 0.94D);
		case NORTH:
		default:
			return new AxisAlignedBB(0.178D, 0D, 0.06D, 0.76D,  0.455D, 0.94D);
		case WEST:
			return new AxisAlignedBB(0.06D, 0D, 0.23D, 0.94D,  0.455D, 0.83D);
		case EAST:
			return new AxisAlignedBB(0.06D, 0D, 0.178D, 0.94D,  0.455D, 0.76D);
		}
	}
	

	
}