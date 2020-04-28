package ru.lg.SovietMod.Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.Blocks.Basic.BasicBlock;

public class FantomBlock extends BasicBlock{

	public FantomBlock(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setCreativeTab(null);
	}

	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.INVISIBLE;
	}
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state)
	{
		if (!world.isRemote)
		{
			if(world.getBlockState(pos.south()).getBlock() == RegBlocks.autoclave||world.getBlockState(pos.west()).getBlock() == RegBlocks.soviet_bed) {
				world.setBlockState(pos.south(), Blocks.AIR.getDefaultState()); 
			}
			if(world.getBlockState(pos.north()).getBlock() == RegBlocks.autoclave||world.getBlockState(pos.west()).getBlock() == RegBlocks.soviet_bed ) {
				world.setBlockState(pos.north(), Blocks.AIR.getDefaultState());
			}
			if(world.getBlockState(pos.east()).getBlock() == RegBlocks.autoclave||world.getBlockState(pos.west()).getBlock() == RegBlocks.soviet_bed) {
				world.setBlockState(pos.east(), Blocks.AIR.getDefaultState());
			}
			if(world.getBlockState(pos.west()).getBlock() == RegBlocks.autoclave||world.getBlockState(pos.west()).getBlock() == RegBlocks.soviet_bed) {
				world.setBlockState(pos.west(), Blocks.AIR.getDefaultState());
			}
		}
	}
}

