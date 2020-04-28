package ru.lg.SovietMod.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.RegSounds;
import ru.lg.SovietMod.Blocks.Basic.BasicLogBlock;

public class SovietColumn extends BasicLogBlock {

	public SovietColumn(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
setTickRandomly(true);
	}
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{

		if(worldIn.isBlockPowered(pos)) {
			worldIn.playSound(null, pos, RegSounds.vent_start, SoundCategory.BLOCKS, 0.9F, 1.0F);
			worldIn.scheduleBlockUpdate(pos, this, 30, 0);
		}
	}
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		
		worldIn.scheduleBlockUpdate(pos, this, 30, 0);
		if(!worldIn.isRemote) {
			if(worldIn.isBlockPowered(pos)) {
				worldIn.playSound(null, pos, RegSounds.vent, SoundCategory.BLOCKS, 0.9F, 1.0F);
			}
		}
	}
}
