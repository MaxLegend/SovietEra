package ru.lg.SovietMod.Blocks.DecorativeBlocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockTable;

public class RadiatorBlock extends BasicBlockTable {
	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 0.3D),
			new AxisAlignedBB(0D, 0D, 0.7D, 1D, 1D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 0.3D, 1D, 1D),
			new AxisAlignedBB(0.7D, 0D, 0D, 1D, 1D, 1D)

	};
	public RadiatorBlock(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
	
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case NORTH:
			return this.SIDE_AABB[0];
		case SOUTH:
		default:
			return this.SIDE_AABB[1];
		case WEST:
			return this.SIDE_AABB[2];
		case EAST:
			return this.SIDE_AABB[3];
		}
	}
}
