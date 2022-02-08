package ru.lg.SovietMod.Blocks.DecorativeBlocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class QuarzTigel extends BasicBlockSideWithCustomModel{
	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0.3D, 0D, 0.3D, 0.7D, 0.4D, 0.7D),
			new AxisAlignedBB(0.3D, 0D, 0.3D, 0.7D, 0.4D, 0.7D),
			new AxisAlignedBB(0.3D, 0D, 0.3D, 0.7D, 0.4D, 0.7D),
			new AxisAlignedBB(0.3D, 0D, 0.3D, 0.7D, 0.4D, 0.7D)

	};
	public QuarzTigel(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
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
			return this.SIDE_AABB[0];
		case WEST:
			return this.SIDE_AABB[0];
		case EAST:
			return this.SIDE_AABB[0];
		}
	}
}
