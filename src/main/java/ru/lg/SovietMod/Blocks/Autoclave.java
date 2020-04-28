package ru.lg.SovietMod.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class Autoclave extends BasicBlockSideWithCustomModel {

	public Autoclave(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);

	}
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state)
	{
		if (!world.isRemote)
		{
			if(state.getValue(FACING) == EnumFacing.SOUTH) {
				world.setBlockState(pos.north(), RegBlocks.fantom_block2.getDefaultState());
			}
			if(state.getValue(FACING) == EnumFacing.NORTH) {
				world.setBlockState(pos.south(), RegBlocks.fantom_block2.getDefaultState());
			}
			if(state.getValue(FACING) == EnumFacing.EAST) {
				world.setBlockState(pos.west(), RegBlocks.fantom_block2.getDefaultState());
			}
			if(state.getValue(FACING) == EnumFacing.WEST) {
				world.setBlockState(pos.east(), RegBlocks.fantom_block2.getDefaultState());
			}
		}
	}
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state)
	{
		if (!world.isRemote)
		{
			if(world.getBlockState(pos.south()).getBlock() == RegBlocks.fantom_block2) {
				world.setBlockState(pos.south(), Blocks.AIR.getDefaultState());
			}
			if(world.getBlockState(pos.north()).getBlock() == RegBlocks.fantom_block2) {
				world.setBlockState(pos.north(), Blocks.AIR.getDefaultState());
			}
			if(world.getBlockState(pos.east()).getBlock() == RegBlocks.fantom_block2) {
				world.setBlockState(pos.east(), Blocks.AIR.getDefaultState());
			}
			if(world.getBlockState(pos.west()).getBlock() == RegBlocks.fantom_block2) {
				world.setBlockState(pos.west(), Blocks.AIR.getDefaultState());
			}
		}
	}
}
