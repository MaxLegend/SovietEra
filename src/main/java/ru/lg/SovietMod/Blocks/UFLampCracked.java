package ru.lg.SovietMod.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class UFLampCracked extends BasicBlockSideWithCustomModel{

	public UFLampCracked(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		// TODO Auto-generated constructor stub
	}
	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0.5D, 1D, 1D, 0.69D, 0.8D),
			new AxisAlignedBB(0D, 0.5D, 0D, 1D, 0.69D, 0.2D),
			new AxisAlignedBB(0D, 0.5D, 0D, 0.2D, 0.69D, 1D),
			new AxisAlignedBB(1D, 0.5D, 0D, 0.8D, 0.69D, 1D)

	};
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case SOUTH:
			return 	SIDE_AABB[0];
		case NORTH:
		default:
			return SIDE_AABB[1];
		case WEST:
			return SIDE_AABB[2];
		case EAST:
			return  SIDE_AABB[3];
		
		}}
}
