package ru.lg.SovietMod.Blocks;

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
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.RegSounds;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class RedLamp extends BasicBlockSideWithCustomModel {
	private boolean isOn;

	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0.35D, 0.35D, 1D, 0.65D, 0.65D, 0.65D),
			new AxisAlignedBB(0.35D, 0.35D, 0D, 0.65D, 0.65D, 0.35D),
			new AxisAlignedBB(0.35D, 0.35D, 0.35D, 0D, 0.65D, 0.65D),
			new AxisAlignedBB(0.65D, 0.35D, 0.35D, 1D, 0.65D, 0.65D)
	};
	public RedLamp(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype,boolean isOn) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.isOn = isOn;

		if (isOn)
		{
			this.setLightLevel(0.5F);
		}
	}

	

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{

		if(worldIn.isRemote) {
			
		}
		if (!worldIn.isRemote)
		{

			if(worldIn.getBlockState(pos) == RegBlocks.red_lamp_on.getDefaultState().withProperty(FACING, state.getValue(FACING))) {
				this.isOn = false;
				worldIn.setBlockState(pos, RegBlocks.red_lamp.getDefaultState().withProperty(FACING, state.getValue(FACING)));
				return true;

			} 

			if(worldIn.getBlockState(pos) == RegBlocks.red_lamp.getDefaultState().withProperty(FACING, state.getValue(FACING))) {
				this.isOn = true;

				worldIn.setBlockState(pos, RegBlocks.red_lamp_on.getDefaultState().withProperty(FACING, state.getValue(FACING)));

				return true;
			}


		}
		return true;


	}
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(RegBlocks.red_lamp);
	}


	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		if (!worldIn.isRemote)
		{
			IBlockState neighborState = worldIn.getBlockState(fromPos);
			Block neighbor = worldIn.getBlockState(fromPos).getBlock();

			if(neighbor instanceof IncLamp || neighbor instanceof SovietLamp|| neighbor instanceof RedLamp ) {
				return;
			} else {
			if(worldIn.isBlockPowered(pos)) {
				isOn = true;
				worldIn.setBlockState(pos, RegBlocks.red_lamp_on.getDefaultState().withProperty(FACING, state.getValue(FACING)));
			}
			if(!worldIn.isBlockPowered(pos)) {
				isOn = false;
				worldIn.setBlockState(pos, RegBlocks.red_lamp.getDefaultState().withProperty(FACING, state.getValue(FACING)));
			}
			}
		}
	}
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{

		if(worldIn.getBlockState(pos) == RegBlocks.red_lamp.getDefaultState().withProperty(FACING, state.getValue(FACING))) {
			this.isOn = false;
			if(worldIn.isBlockPowered(pos)) {
				isOn = true;
			}
		}
		if(worldIn.getBlockState(pos) == RegBlocks.red_lamp_on.getDefaultState().withProperty(FACING, state.getValue(FACING))) {
			this.isOn = true;
			if(worldIn.isBlockPowered(pos)) {
				isOn = false;
			}
		}
		worldIn.scheduleBlockUpdate(pos, this, 21, 0);
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{

		worldIn.scheduleBlockUpdate(pos, this, 21, 0);
		if(!worldIn.isRemote) {
			if(isOn)
			{
				worldIn.playSound(null,pos, RegSounds.lum_lamp_buzz, SoundCategory.BLOCKS, 0.1F, 1F);
			}
			if(isOn && worldIn.isBlockPowered(pos)) { 
				
				worldIn.playSound(null,pos, RegSounds.lum_lamp_buzz, SoundCategory.BLOCKS, 0.1F, 1F);
			}
		}


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
			return this.SIDE_AABB[1];
		case WEST:
			return this.SIDE_AABB[2];
		case EAST:
			return this.SIDE_AABB[3];
		}
	}
}
