package ru.lg.SovietMod.Blocks.DecorativeBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockFullRotate;
import ru.lg.SovietMod.Blocks.Basic.NewBasicXZBlock;

public class VentFilter extends NewBasicXZBlock {
	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(1D, 0D, 0.87D, 0D, 0.265D, 0.13D), //upx
			new AxisAlignedBB(0.87D, 0D, 1D, 0.13D, 0.265D, 0D),//upz
			new AxisAlignedBB(0.87D, 1D, 1D, 0.13D, 0.735D, 0D),//downz
			new AxisAlignedBB(1D, 1D, 0.87D, 0D, 0.735D, 0.13D),//downx
			new AxisAlignedBB(0D, 0.13D, 0D, 1D, 0.87D,  0.265D),//south
			new AxisAlignedBB(0D, 0.13D, 0.735D, 1D, 0.87D, 1D), //north
			new AxisAlignedBB(0.735D, 0.13D, 0D, 1D, 0.87D, 1D),//west
			new AxisAlignedBB(0D, 0.13D, 0D, 0.265D, 0.87D, 1D),//east
	};
	public VentFilter(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		// TODO Auto-generated constructor stub
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case UP_X:
			return SIDE_AABB[0];
		case UP_Z:
			return SIDE_AABB[1];
		case DOWN_Z:
			return SIDE_AABB[2];
		case DOWN_X:
			return SIDE_AABB[3];
		case SOUTH:
			return SIDE_AABB[4];
		case NORTH:
		default:
			return SIDE_AABB[5];
		case WEST:
			return SIDE_AABB[6];
		case EAST:
			return SIDE_AABB[7];
		}
	}

}
