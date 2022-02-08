package ru.lg.SovietMod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.lg.SovietMod.Blocks.Basic.BasicRotateXZBlock;
import ru.lg.SovietMod.Blocks.Basic.NewBasicXZBlock;
import ru.lg.SovietMod.Blocks.DecorativeBlocks.AccelLamp;
import ru.lg.SovietMod.Blocks.DecorativeBlocks.IncLamp;
import ru.lg.SovietMod.Blocks.DecorativeBlocks.RedLamp;

public class AccelLampCracked extends NewBasicXZBlock {


	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(1D, 0D, 0.67D, 0D, 0.15D, 0.3D), //upx
			new AxisAlignedBB(0.7D, 0D, 1D, 0.33D, 0.15D, 0D),//upz
			new AxisAlignedBB(0.67D, 1D, 1D, 0.3D, 0.85D, 0D),//downz
			new AxisAlignedBB(1D, 1D, 0.67D, 0D, 0.85D, 0.3D),//downx
			new AxisAlignedBB(0D, 0.33D, 0D, 1D, 0.7D, 0.15D),//south
			new AxisAlignedBB(0D, 0.33D, 0.85D, 1D, 0.7D, 1D), //north
			new AxisAlignedBB(0.85D, 0.33D, 0D, 1D, 0.7D, 1D),//west
			new AxisAlignedBB(0D, 0.33D, 0D, 0.15D, 0.7D, 1D),//east
	};
	public AccelLampCracked(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, NewBasicXZBlock.EnumOrientation.NORTH));
	

	}

	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(RegBlocks.accl_lamp_cracked);
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

