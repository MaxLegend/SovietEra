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
import ru.lg.SovietMod.Blocks.AccelLamp;
import ru.lg.SovietMod.Blocks.BasicRotateXZBlock;
import ru.lg.SovietMod.Blocks.IncLamp;
import ru.lg.SovietMod.Blocks.RedLamp;

public class AccelLampCracked extends BasicRotateXZBlock {



	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0.7D, 1D, 1D, 0.3D, 0.85D, 0D),
			new AxisAlignedBB(0.7D, 1D, 1D, 0.3D, 0.85D, 0D),
			new AxisAlignedBB(1D, 1D, 0.7D, 0D, 0.85D, 0.3D),
			new AxisAlignedBB(1D, 1D, 0.7D, 0D, 0.85D, 0.3D)

	};
	public AccelLampCracked(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, BasicRotateXZBlock.EnumOrientation.NORTH));
	

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
			return new AxisAlignedBB(1D, 0D, 0.67D, 0D, 0.15D, 0.3D);
		case UP_Z:
			return new AxisAlignedBB(0.7D, 0D, 1D, 0.33D, 0.15D, 0D);
		case DOWN_Z:
			return new AxisAlignedBB(0.67D, 1D, 1D, 0.3D, 0.85D, 0D);
		case DOWN_X:
			return new AxisAlignedBB(1D, 1D, 0.67D, 0D, 0.85D, 0.3D);
		case SOUTH:
			return new AxisAlignedBB(0D, 0.33D, 0D, 1D, 0.7D, 0.15D);
		case NORTH:
		default:
			return new AxisAlignedBB(0D, 0.33D, 0.85D, 1D, 0.7D, 1D);
		case WEST:
			return new AxisAlignedBB(0.85D, 0.33D, 0D, 1D, 0.7D, 1D);
		case EAST:
			return new AxisAlignedBB(0D, 0.33D, 0D, 0.15D, 0.7D, 1D);
		}
	}
}

