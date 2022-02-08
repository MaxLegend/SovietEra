package ru.lg.SovietMod.Blocks.DecorativeBlocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class ContactWireAngle extends BasicBlockSideWithCustomModel {
	private static AxisAlignedBB AABB = new AxisAlignedBB(0.02D, 0.45D, 0.02D, 0.98D, 0.74D, 0.98D);
	public ContactWireAngle(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		// TODO Auto-generated constructor stub
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case SOUTH:
			return AABB;
		case NORTH:
		default:
			return AABB;
		case WEST:
			return AABB;
		case EAST:
			return AABB;
		}
	}
}
