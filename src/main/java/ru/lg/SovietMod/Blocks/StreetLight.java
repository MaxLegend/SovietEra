package ru.lg.SovietMod.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.RegSounds;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class StreetLight extends BasicBlockSideWithCustomModel {
	private boolean isOn;
	public StreetLight(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype, boolean isOn) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.isOn = isOn;
		if (isOn)
		{
			this.setLightLevel(1F);
		}
	}
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{

		if(worldIn.getBlockState(pos) == RegBlocks.street_light_false.getDefaultState().withProperty(FACING, state.getValue(FACING))) {
			this.isOn = false;
			if(worldIn.isBlockPowered(pos)) {
				isOn = true;
			}
		}
		if(worldIn.getBlockState(pos) == RegBlocks.street_light_true.getDefaultState().withProperty(FACING, state.getValue(FACING))) {
			this.isOn = true;
			if(worldIn.isBlockPowered(pos)) {
				isOn = false;
			}
		}
		worldIn.scheduleBlockUpdate(pos, this, 20, 0);
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{

		if(worldIn.isRemote) {
			worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(),  RegSounds.lum_lamp_enable, SoundCategory.BLOCKS, 0.1F, 1.0F, true);
		}
		if (!worldIn.isRemote)
		{

			if(worldIn.getBlockState(pos) == RegBlocks.street_light_true.getDefaultState().withProperty(FACING, state.getValue(FACING))) {
				this.isOn = false;
				worldIn.setBlockState(pos, RegBlocks.street_light_false.getDefaultState().withProperty(FACING, state.getValue(FACING)));
				return true;

			} 

			if(worldIn.getBlockState(pos) == RegBlocks.street_light_false.getDefaultState().withProperty(FACING, state.getValue(FACING))) {
				this.isOn = true;

				worldIn.setBlockState(pos, RegBlocks.street_light_true.getDefaultState().withProperty(FACING, state.getValue(FACING)));

				return true;
			}


		}
		return true;


	}
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(RegBlocks.street_light_false);
	}
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		if (!worldIn.isRemote)
		{
			if(isOn) {
				worldIn.playSound(null, pos,  RegSounds.lum_lamp_enable, SoundCategory.BLOCKS, 0.08F, 1.0F);
			}
			if(!isOn && worldIn.isBlockPowered(pos)) {
				worldIn.playSound(null, pos,  RegSounds.lum_lamp_enable, SoundCategory.BLOCKS, 0.08F, 1.0F);
			}
			if(worldIn.isBlockPowered(pos)) {
				
				isOn = true;
				worldIn.setBlockState(pos, RegBlocks.street_light_true.getDefaultState().withProperty(FACING, state.getValue(FACING)));
			}
			if(!worldIn.isBlockPowered(pos)) {
				isOn = false;
				worldIn.setBlockState(pos, RegBlocks.street_light_false.getDefaultState().withProperty(FACING, state.getValue(FACING)));
			}
		}
	}
}
