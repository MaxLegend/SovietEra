package ru.lg.SovietMod.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class FullFormMonitor extends BasicBlockSideWithCustomModel {
	public static final PropertyBool ENABLE = PropertyBool.create("enable");
	public FullFormMonitor(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ENABLE, Boolean.valueOf(false)));
	}
	
	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 0.19D, 1D, 1D, 1D),
			new AxisAlignedBB(0D, 0D, 0.0D, 1D, 1D, 0.81D),
			new AxisAlignedBB(0D, 0D, 0.0D, 0.81D, 1D, 1D),
			new AxisAlignedBB(0.19D, 0D, 0.0D, 1D, 1D, 1D)
	};
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case SOUTH:
			return SIDE_AABB[0];
		case NORTH:
		default:
			return SIDE_AABB[1];
		case WEST:
			return SIDE_AABB[2];
		case EAST:
			return SIDE_AABB[3];
		}
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