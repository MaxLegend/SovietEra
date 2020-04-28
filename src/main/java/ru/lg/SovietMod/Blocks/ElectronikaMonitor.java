package ru.lg.SovietMod.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class ElectronikaMonitor extends BasicBlockSideWithCustomModel {
	public static final PropertyBool ENABLE = PropertyBool.create("enable");
	public ElectronikaMonitor(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ENABLE, Boolean.valueOf(false)));
	}
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		if (!worldIn.isRemote)
		{
			worldIn.scheduleUpdate(pos, this, 4);
			if(worldIn.isBlockPowered(pos)) {

				worldIn.setBlockState(pos, state.withProperty(FACING, state.getValue(FACING)).withProperty(ENABLE, true));
			} else {

				worldIn.setBlockState(pos, state.withProperty(FACING, state.getValue(FACING)).withProperty(ENABLE, false));
			}

		}
	}
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (!worldIn.isRemote)
		{
			if(worldIn.isBlockPowered(pos)) {

				worldIn.setBlockState(pos, state.withProperty(FACING, state.getValue(FACING)).withProperty(ENABLE, true));
			} else {

				worldIn.setBlockState(pos, state.withProperty(FACING, state.getValue(FACING)).withProperty(ENABLE, false));
			}
		}
	}
	  public IBlockState getStateFromMeta(int meta)
	    {
		  return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta)).withProperty(ENABLE, Boolean.valueOf((meta & 8) > 0));
	    }

	    /**
	     * Convert the BlockState into the correct metadata value
	     */
	    public int getMetaFromState(IBlockState state)
	    {
	        int i = 0;
	        i = i | ((EnumFacing)state.getValue(FACING)).getIndex();

	        if (((Boolean)state.getValue(ENABLE)).booleanValue())
	        {
	            i |= 8;
	        }

	        return i;
	    }
	public boolean canProvidePower(IBlockState state)
	{
		return true;
	}
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING, ENABLE});
	}
}
