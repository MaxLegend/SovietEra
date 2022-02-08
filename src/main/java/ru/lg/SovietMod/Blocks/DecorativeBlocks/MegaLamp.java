package ru.lg.SovietMod.Blocks.DecorativeBlocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockWithCustomModel;

public class MegaLamp extends BasicBlockWithCustomModel {
	private boolean isOn;
	public static final PropertyDirection FACING = PropertyDirection.create("facing");

	public MegaLamp(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype, boolean isOn) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.isOn = isOn;
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.DOWN));
		if (isOn)
		{
			this.setLightLevel(1F);
		}
	}




	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING});
	}
	public IBlockState getStateFromMeta(int meta)
	{
		IBlockState iblockstate = this.getDefaultState();

		switch (meta)
		{
		case 1:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.EAST);
			break;
		case 2:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.WEST);
			break;
		case 3:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.SOUTH);
			break;
		case 4:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.NORTH);
			break;
		case 5:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.DOWN);
			break;
		case 6:
		default:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.UP);
		}

		return iblockstate;
	}
	public int getMetaFromState(IBlockState state)
	{
		int i = 0;

		switch ((EnumFacing)state.getValue(FACING))
		{
		case EAST:
			i = i | 1;
			break;
		case WEST:
			i = i | 2;
			break;
		case SOUTH:
			i = i | 3;
			break;
		case NORTH:
			i = i | 4;
			break;
		case DOWN:
			i = i | 5;
			break;
		case UP:
		default:
			i = i | 6;
		}

		return i;
	}
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return canPlaceBlock(worldIn, pos, facing) ? this.getDefaultState().withProperty(FACING, facing) : this.getDefaultState().withProperty(FACING, EnumFacing.DOWN);
	}
	protected static boolean canPlaceBlock(World worldIn, BlockPos pos, EnumFacing direction)
	{
		BlockPos blockpos = pos.offset(direction.getOpposite());
		IBlockState iblockstate = worldIn.getBlockState(blockpos);
		boolean flag = iblockstate.getBlockFaceShape(worldIn, blockpos, direction) == BlockFaceShape.SOLID;
		Block block = iblockstate.getBlock();

		if (direction == EnumFacing.UP)
		{
			return iblockstate.isTopSolid() || !isExceptionBlockForAttaching(block) && flag;
		}
		else
		{
			return !isExceptBlockForAttachWithPiston(block) && flag;
		}
	}
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(RegBlocks.mega_lamp);
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{

		if (!worldIn.isRemote)
		{
			worldIn.scheduleBlockUpdate(pos, this,35, 0);
			if (this.isOn && !worldIn.isBlockPowered(pos))
			{
				worldIn.setBlockState(pos, RegBlocks.mega_lamp.getDefaultState().withProperty(FACING, state.getValue(FACING)), 2);
			}
			else if (!this.isOn && worldIn.isBlockPowered(pos))
			{


				worldIn.setBlockState(pos, RegBlocks.mega_lamp_true.getDefaultState().withProperty(FACING, state.getValue(FACING)), 2);
			}
		}
	}
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		if (!worldIn.isRemote)
		{

			if (this.isOn && !worldIn.isBlockPowered(pos))
			{
				worldIn.scheduleUpdate(pos, this, 4);
			}
			else if (!this.isOn && worldIn.isBlockPowered(pos))
			{


				worldIn.setBlockState(pos, RegBlocks.mega_lamp_true.getDefaultState().withProperty(FACING, state.getValue(FACING)), 2);
			}
		}
	}
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (!worldIn.isRemote)
		{
			super.updateTick(worldIn, pos, state, rand);
			if (worldIn.isBlockPowered(pos))
			{
				worldIn.scheduleBlockUpdate(pos, this,35, 0);


			}

			if (this.isOn && !worldIn.isBlockPowered(pos))
			{
				worldIn.setBlockState(pos, RegBlocks.mega_lamp.getDefaultState().withProperty(FACING, state.getValue(FACING)), 2);
			}
		}
	}
}


